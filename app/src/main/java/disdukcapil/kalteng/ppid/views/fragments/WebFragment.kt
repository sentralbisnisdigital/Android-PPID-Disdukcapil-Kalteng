package disdukcapil.kalteng.ppid.views.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import disdukcapil.kalteng.ppid.MainActivity
import disdukcapil.kalteng.ppid.databinding.FragmentWebBinding
import disdukcapil.kalteng.ppid.models.Menu


class WebFragment : Fragment() {
    private var _binding: FragmentWebBinding? = null
    private val binding get() = _binding!!
    private var menu : Menu? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentWebBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        menu = arguments?.let { WebFragmentArgs.fromBundle(it).menu }

        (activity as AppCompatActivity?)!!.supportActionBar!!.title = menu?.title

        menu?.url?.let {
            binding.webView.settings.javaScriptEnabled = true
            binding.webView.webViewClient = WebViewClient()
            binding.webView.loadUrl(it)
        }
        return view
    }

    inner class WebViewClient : android.webkit.WebViewClient() {

        // Load the URL
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return false
        }

        // ProgressBar will disappear once page is loaded
        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            binding.webView.visibility = View.VISIBLE
            binding.animationView.visibility = View.GONE
        }
    }

}