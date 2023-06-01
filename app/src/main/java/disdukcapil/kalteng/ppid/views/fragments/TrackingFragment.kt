package disdukcapil.kalteng.ppid.views.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import disdukcapil.kalteng.ppid.adapters.TrackingAdapter
import disdukcapil.kalteng.ppid.databinding.FragmentTrackingBinding
import disdukcapil.kalteng.ppid.databinding.ItemTrackingHistoryBinding
import disdukcapil.kalteng.ppid.models.Menu
import disdukcapil.kalteng.ppid.models.Tracking
import disdukcapil.kalteng.ppid.utils.Env
import disdukcapil.kalteng.ppid.utils.ITracking
import disdukcapil.kalteng.ppid.viewmodels.TrackingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class TrackingFragment : BottomSheetDialogFragment(),
    ITracking<Tracking, ItemTrackingHistoryBinding> {

    private lateinit var adapter: TrackingAdapter
    private var _binding: FragmentTrackingBinding? = null
    private val binding get() = _binding!!
    private val trackingViewModel: TrackingViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTrackingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setupUI()
        setupObserver()
        inputTracking()
    }

    private fun setupUI() {
        adapter = TrackingAdapter(arrayListOf(), this)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

    }

    private fun setupObserver() {
        trackingViewModel.allTracking.observe(this) {
            renderList(it)
        }
    }

    private fun renderList(it: List<Tracking>) {
        adapter.addAll(it)
        adapter.notifyDataSetChanged()
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
                if (tracking.isNotEmpty()) {
                    val track = Tracking(
                        null,
                        trackingCode = tracking,
                        trackingType = null,
                        createdAt = null
                    )
                    trackingViewModel.insert(track)
                    val menu = Menu(
                        url = Env.url(tracking, "/ppid/public-information/")
                    )
                    showTrackingIntoWebFragment(menu)
                } else {
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

    override fun onClick(item: Tracking, position: Int, view: ItemTrackingHistoryBinding) {
        val menu = Menu(url = Env.url(item.trackingCode.toString(), "/ppid/public-information/"))
        showTrackingIntoWebFragment(menu)
    }

    override fun onItemDeleted(item: Tracking, position: Int) {

        item.let {
//            trackingViewModel.deleteItem(it)
        }
    }
}