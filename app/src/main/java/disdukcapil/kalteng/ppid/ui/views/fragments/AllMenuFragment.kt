package disdukcapil.kalteng.ppid.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import disdukcapil.kalteng.ppid.ui.views.utils.IClick
import disdukcapil.kalteng.ppid.ui.views.activities.MainActivity
import disdukcapil.kalteng.ppid.data.models.Menu
import disdukcapil.kalteng.ppid.ui.adapters.MenuAdapter
import disdukcapil.kalteng.ppid.databinding.FragmentAllMenuBinding
import disdukcapil.kalteng.ppid.databinding.ItemMenuBinding
import disdukcapil.kalteng.ppid.utils.MenuObject
import disdukcapil.kalteng.ppid.ui.views.fragments.MainFragmentDirections

class AllMenuFragment : BottomSheetDialogFragment(), IClick {

    companion object {
        fun newInstance(): AllMenuFragment {
            return AllMenuFragment()
        }
        const val TAG = "ActionBottomDialog"
    }

    private var _binding: FragmentAllMenuBinding? = null
    private val binding get() = _binding!!
    private lateinit var menuAdapter: MenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAllMenuBinding.inflate(inflater, container, false)
        (requireActivity() as MainActivity).title = "Hello"
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
        binding.recyclerView.layoutManager = GridLayoutManager(this.context, 3)
    }

    private fun renderList(it: List<Menu>) {
        menuAdapter.addAll(it)
        menuAdapter.removeItemInLastPosition()
        menuAdapter.notifyDataSetChanged()
    }

    private fun setupObserver() {

        renderList(MenuObject.item())

    }

    override fun onClick(menu: Menu, position: Int, view: ItemMenuBinding) {
        val navController = findNavController()
        val action = MainFragmentDirections.actionMainFragmentToWebFragment(menu)
        navController.navigate(action)
    }
}