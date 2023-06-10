package disdukcapil.kalteng.ppid.ui.views.fragments

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import disdukcapil.kalteng.ppid.data.models.Menu
import disdukcapil.kalteng.ppid.databinding.FragmentWebBinding


@Suppress("DEPRECATION")
class WebFragment : Fragment() {
    private var _binding: FragmentWebBinding? = null
    private val binding get() = _binding!!
    private var menu: Menu? = null
    private var isError = false
    private var filePath: ValueCallback<Array<Uri>>? = null

    companion object{
        private const val REQUEST_PERMISSION = 101
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWebBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        menu = arguments?.let { WebFragmentArgs.fromBundle(it).menu }

        (activity as AppCompatActivity?)!!.supportActionBar!!.title = menu?.title
        menu?.url?.let {
            binding.webView.settings.javaScriptEnabled = true
            binding.webView.webViewClient = WebClient()
            binding.webView.webChromeClient = ChromeClient()
            binding.webView.loadUrl(it)
            binding.btnReload.setOnClickListener { _ ->
                binding.animationView.visibility = View.VISIBLE
                binding.webView.loadUrl(it)
                isError = false
            }
        }

        return view
    }


    inner class WebClient : WebViewClient() {

        // Load the URL
        @Deprecated("Deprecated in Java")
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            if (url.contains("/download")) {
                requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 102)
                downloadFile(url)
            }
            return false
        }

        // ProgressBar will disappear once page is loaded
        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            if(!isError){
                if(view.progress == 100){
                    binding.layoutError.visibility = View.GONE
                    binding.webView.visibility = View.VISIBLE
                    binding.animationView.visibility = View.GONE
                }
            }

        }

        override fun onReceivedError(
            view: WebView?,
            request: WebResourceRequest?,
            error: WebResourceError?
        ) {
            super.onReceivedError(view, request, error)
            binding.layoutError.visibility = View.VISIBLE
            binding.webView.visibility = View.GONE
            binding.animationView.visibility = View.GONE
            isError = true
        }
    }

    private fun downloadFile(url: String) {
        val manager = activity?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager?
        val uri = Uri.parse(url)
        val request = DownloadManager.Request(uri)
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        manager!!.enqueue(request)
    }

    inner class ChromeClient : WebChromeClient() {
        override fun onShowFileChooser(
            webView: WebView,
            filePathCallback: ValueCallback<Array<Uri>>,
            fileChooserParams: FileChooserParams
        ): Boolean {
            filePath = filePathCallback
            checkPermission()
            return true
        }

        override fun onPermissionRequest(request: PermissionRequest?) {
            request?.grant(request.resources)
        }
    }

    private fun checkPermission() {
        when {
            !isPermissionGranted() -> {
                requestPermissions(
                    arrayOf(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ),
                    REQUEST_PERMISSION
                )
            }
            else -> {
                openFileChooser()
            }
        }
    }

    private fun isPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun openFileChooser() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        val mimeTypes = arrayOf("image/jpeg", "image/png")
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        getFile.launch(intent)
    }


    private val getFile = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_CANCELED) {
            filePath?.onReceiveValue(null)
        } else if (it.resultCode == RESULT_OK && filePath != null) {
            filePath!!.onReceiveValue(
                WebChromeClient.FileChooserParams.parseResult(it.resultCode, it.data)
            )
            filePath = null
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            REQUEST_PERMISSION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openFileChooser()
                } else {
                    Toast.makeText(this@WebFragment.context, "Akses ditolak", Toast.LENGTH_SHORT)
                        .show()
                    activity?.onBackPressedDispatcher?.onBackPressed()
                }
            }
            102 -> {
                if (grantResults.isNotEmpty() && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this@WebFragment.context, "Akses ditolak", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

}