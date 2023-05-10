package disdukcapil.kalteng.ppid.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import disdukcapil.kalteng.ppid.utils.IClick
import disdukcapil.kalteng.ppid.models.Menu
import disdukcapil.kalteng.ppid.adapters.HeaderAdapter
import disdukcapil.kalteng.ppid.adapters.MenuAdapter
import disdukcapil.kalteng.ppid.databinding.FragmentMainBinding
import disdukcapil.kalteng.ppid.databinding.ItemMenuBinding
import disdukcapil.kalteng.ppid.utils.MenuObject

class MainFragment : Fragment(), IClick {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ConcatAdapter
    private lateinit var menuAdapter: MenuAdapter
    private lateinit var headerAdapter: HeaderAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.button.setOnClickListener {
            val submissionFragment = SubmissionFragment.newInstance()
            submissionFragment.show(
                parentFragmentManager,
                SubmissionFragment.TAG
            )
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setupUI()
        setupObserver()
    }

    private fun setupUI() {
        headerAdapter = HeaderAdapter(arrayListOf())
        menuAdapter = MenuAdapter(arrayListOf(), this)
        adapter = ConcatAdapter(headerAdapter, menuAdapter)
        binding.recyclerView.adapter = menuAdapter
        binding.recyclerView.layoutManager = GridLayoutManager(
            this@MainFragment.context, 3
        )
    }

    private fun renderList(it: List<Menu>) {
        menuAdapter.addAll(it)
        menuAdapter.notifyDataSetChanged()
    }

    private fun setupObserver() {
        val menuItem = MenuObject.item()
        if (menuItem.size > 12) {
            menuItem.subList(11, menuItem.size).clear()
            menuItem.add(MenuObject.addAppsButton)
        }
        renderList(menuItem)

        val header = listOf("Menu Utama")
        headerAdapter.addAll(header)
    }

    override fun onClick(menu: Menu, position: Int, view: ItemMenuBinding) {
        if (menu.url == null) {
            val bottomDialogFragment =
                menu.destination?.newInstance() as BottomSheetDialogFragment
            bottomDialogFragment.show(
                parentFragmentManager,
                AllMenuFragment.TAG
            )
        } else {
            val navController = findNavController()
            val action = MainFragmentDirections.actionMainFragmentToWebFragment(menu)
            navController.navigate(action)
            Animatoo.animateFade(this.requireContext())
        }
    }
}
