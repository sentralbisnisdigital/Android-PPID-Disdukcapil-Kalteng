package disdukcapil.kalteng.ppid.ui.views.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import disdukcapil.kalteng.ppid.data.models.Menu
import disdukcapil.kalteng.ppid.databinding.FragmentMainBinding
import disdukcapil.kalteng.ppid.databinding.ItemMenuBinding
import disdukcapil.kalteng.ppid.ui.adapters.HeaderAdapter
import disdukcapil.kalteng.ppid.ui.adapters.MenuAdapter
import disdukcapil.kalteng.ppid.ui.views.utils.IClick
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
    ): View {

        _binding = FragmentMainBinding.inflate(inflater, container, false)

        hideToolbar()
        showServices()
        showTracking()

        return binding.root
    }

    private fun showServices(){
        binding.btnShowServices.setOnClickListener {
            val submissionFragment = SubmissionFragment.newInstance()
            submissionFragment.show(
                parentFragmentManager,
                SubmissionFragment.TAG
            )
        }
    }

    private fun showTracking(){
        binding.btnTracking.setOnClickListener {
            val trackingFragment = TrackingFragment.newInstance()
            trackingFragment.show(
                parentFragmentManager,
                SubmissionFragment.TAG
            )
        }
    }
    private fun hideToolbar(isHidden : Boolean = true){
        val activity = requireActivity() as AppCompatActivity
        val actionBar = activity.supportActionBar
        when(isHidden) {
            true -> actionBar?.hide()
            false -> actionBar?.show()
        }
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

    @SuppressLint("NotifyDataSetChanged")
    private fun renderList(it: List<Menu>) {
        menuAdapter.addAll(it)
        menuAdapter.notifyDataSetChanged()
    }

    private fun setupObserver() {
        val menuItem = MenuObject.item()
        if (menuItem.size > 9) {
            menuItem.subList(8, menuItem.size).clear()
            menuItem.add(MenuObject.addAppsButton)
        }
        renderList(menuItem)

        val header = listOf("Menu Utama")
        headerAdapter.addAll(header)
    }

    override fun onClick(menu: Menu, position: Int, view: ItemMenuBinding) {
        if (menu.url == null && menu.subMenu == null) {
            val bottomDialogFragment =
                menu.destination?.newInstance() as BottomSheetDialogFragment
            bottomDialogFragment.show(
                parentFragmentManager,
                AllMenuFragment.TAG
            )
        } else if (menu.url == null) {
                val submissionFragment = SubmissionFragment.newInstance(menu.subMenu, menu.title)
                submissionFragment.show(
                    parentFragmentManager,
                    SubmissionFragment.TAG
                )
            } else {
                val navController = findNavController()
                val action = MainFragmentDirections.actionMainFragmentToWebFragment(menu)
                navController.navigate(action)
                Animatoo.animateFade(this.requireContext())
            }
    }

    /*
    * Tampilkan kembali toolbar saat fragment ini tidak aktif
    */
    override fun onDestroyView() {
        super.onDestroyView()
        hideToolbar(false)
    }
}

