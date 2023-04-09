package disdukcapil.kalteng.ppid

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.Toast
import disdukcapil.kalteng.ppid.databinding.FragmentWebBinding

class WebFragment : Fragment() {
    private var _binding: FragmentWebBinding? = null
    private val binding get() = _binding!!
    private var menu : Menu? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWebBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        menu = arguments?.let { WebFragmentArgs.fromBundle(it).menu }
        Log.d("fragmentweb", menu?.title.toString())
        (requireActivity() as MainActivity).title = menu?.title

        menu?.url?.let {
            binding.webView.settings.javaScriptEnabled = true
            binding.webView.webViewClient = WebViewClient()
            binding.webView.loadUrl(it)
        }
        return view
    }

}