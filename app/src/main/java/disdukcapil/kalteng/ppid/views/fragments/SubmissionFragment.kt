package disdukcapil.kalteng.ppid.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import disdukcapil.kalteng.ppid.MainActivity
import disdukcapil.kalteng.ppid.adapters.MenuAdapter
import disdukcapil.kalteng.ppid.databinding.FragmentSubmissionBinding
import disdukcapil.kalteng.ppid.databinding.ItemMenuBinding
import disdukcapil.kalteng.ppid.models.Menu
import disdukcapil.kalteng.ppid.utils.IClick
import disdukcapil.kalteng.ppid.utils.MenuObject


class SubmissionFragment : BottomSheetDialogFragment(), IClick {

    companion object {
        fun newInstance(): SubmissionFragment {
            return SubmissionFragment()
        }
        const val TAG = "ActionBottomDialog"
    }

    private var _binding: FragmentSubmissionBinding? = null
    private val binding get() = _binding!!
    private lateinit var menuAdapter: MenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSubmissionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setupUI()
        setupObserver()
    }

    private fun setupUI() {

        menuAdapter = MenuAdapter(arrayListOf(), this)

        binding.recyclerView.adapter = menuAdapter
        binding.recyclerView.layoutManager = GridLayoutManager(this.context, 2)
    }

    private fun renderList(it: List<Menu>) {
        menuAdapter.addAll(it)
        menuAdapter.notifyDataSetChanged()
    }

    private fun setupObserver() {

        renderList(MenuObject.submissionItemMenu())

    }

    override fun onClick(menu: Menu, position: Int, view: ItemMenuBinding) {
        val navController = findNavController()
        val action = MainFragmentDirections.actionMainFragmentToWebFragment(menu)
        navController.navigate(action)
    }

}