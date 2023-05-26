package disdukcapil.kalteng.ppid.views.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import disdukcapil.kalteng.ppid.databinding.FragmentTrackingBinding
import disdukcapil.kalteng.ppid.models.Menu
import disdukcapil.kalteng.ppid.utils.Env


class TrackingFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentTrackingBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTrackingBinding.inflate(layoutInflater, container, false)
        inputTracking()
        return binding.root
    }

    companion object {
        fun newInstance(): TrackingFragment {
            return TrackingFragment()
        }
    }

    private fun inputTracking() {
        binding.textInputTracking.setOnEditorActionListener { it, actionId, _ ->
            val tracking = it.text.toString()
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                if(tracking.isNotEmpty()){
                    Toast.makeText(context, Env.url(tracking, "/ppid/public-information/"), Toast.LENGTH_SHORT).show()
                    val menu = Menu(
                        url = Env.url(tracking, "/ppid/public-information/")
                    )
                    showTrackingIntoWebFragment(menu)
                }else{
                    it.setError("Silahkan Inputan Terlebih dahulu nomor tracking")
                    it.isFocusable = true
                }
                return@setOnEditorActionListener true
            }
            false
        }
    }

    private fun showTrackingIntoWebFragment(menu: Menu) {
        dismiss() // close this fragment
        val navController = findNavController()
        val action = MainFragmentDirections.actionMainFragmentToWebFragment(menu)
        navController.navigate(action)
    }
}