package disdukcapil.kalteng.ppid.ui.views.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import disdukcapil.kalteng.ppid.data.models.Menu
import disdukcapil.kalteng.ppid.databinding.FragmentSubmissionBinding
import disdukcapil.kalteng.ppid.databinding.ItemMenuBinding
import disdukcapil.kalteng.ppid.ui.adapters.MenuAdapter
import disdukcapil.kalteng.ppid.ui.views.utils.IClick
import disdukcapil.kalteng.ppid.utils.MenuObject


class SubmissionFragment(private val menu: ArrayList<Menu>? = null, private val title: String? = null) : BottomSheetDialogFragment(),
    IClick {

    companion object {
        fun newInstance(menu: ArrayList<Menu>? = null, title: String? = null): SubmissionFragment {
            return SubmissionFragment(menu, title)
        }
        const val TAG = "SubmissionFragment"
    }

    private var _binding: FragmentSubmissionBinding? = null
    private val binding get() = _binding!!
    private lateinit var menuAdapter: MenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSubmissionBinding.inflate(inflater, container, false)
        binding.textTitle.text = title ?: "Ajukan Permohonan / Keberatan"
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

    @SuppressLint("NotifyDataSetChanged")
    private fun renderList(it: List<Menu>) {
        menuAdapter.addAll(it)
        menuAdapter.notifyDataSetChanged()
    }

    private fun setupObserver() {
        val item = menu ?: listOf(MenuObject.subMenu()[0], MenuObject.subMenu()[2])
        renderList(item)

    }

    override fun onClick(menu: Menu, position: Int, view: ItemMenuBinding) {
        dismiss() // close this fragment
        val navController = findNavController()
        val action = MainFragmentDirections.actionMainFragmentToWebFragment(menu)
        navController.navigate(action)
    }

}