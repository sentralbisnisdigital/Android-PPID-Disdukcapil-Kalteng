package id.mazafathi.ppidcapilkalteng.ui.views.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.InputFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import id.mazafathi.ppidcapilkalteng.R
import id.mazafathi.ppidcapilkalteng.data.models.Menu
import id.mazafathi.ppidcapilkalteng.data.models.Tracking
import id.mazafathi.ppidcapilkalteng.databinding.FragmentTrackingBinding
import id.mazafathi.ppidcapilkalteng.databinding.ItemTrackingHistoryBinding
import id.mazafathi.ppidcapilkalteng.ui.adapters.TrackingAdapter
import id.mazafathi.ppidcapilkalteng.ui.viewmodels.TrackingViewModel
import id.mazafathi.ppidcapilkalteng.ui.views.utils.ITracking
import id.mazafathi.ppidcapilkalteng.utils.Config
import id.mazafathi.ppidcapilkalteng.utils.Env
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
    ): View {
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
        binding.textInputTracking.filters = arrayOf(InputFilter.AllCaps(), InputFilter.LengthFilter(11))
    }

    private fun setupObserver() {
        trackingViewModel.allTracking.observe(this) {
            renderList(it)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
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
                        title = Config.setTrackingTitle(tracking),
                        url = Env.url(tracking, "/ppid/tracking/")
                    )
                    showTrackingIntoWebFragment(menu)
                } else {
                    it.error = context?.getString(R.string.text_error_input_tracking)
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
        val menu = Menu(
            title = Config.setTrackingTitle(item.trackingCode.toString()),
            url = Env.url(item.trackingCode.toString(), "/ppid/tracking/")
        )
        showTrackingIntoWebFragment(menu)
    }

    override fun onItemDeleted(item: Tracking, position: Int) {
        trackingViewModel.deleteItem(item)
    }
}