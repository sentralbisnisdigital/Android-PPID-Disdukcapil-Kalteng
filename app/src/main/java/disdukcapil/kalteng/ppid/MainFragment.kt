package disdukcapil.kalteng.ppid

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import disdukcapil.kalteng.ppid.databinding.FragmentMainBinding
import disdukcapil.kalteng.ppid.databinding.ItemMenuBinding

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
        (requireActivity() as MainActivity).title = "Hello"
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
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(this.context, 3)
    }

    private fun renderList(it: List<Menu>) {
        menuAdapter.addAll(it)
        menuAdapter.notifyDataSetChanged()
    }

    private fun setupObserver() {
        val list = listOf(
            Menu(
                icon = 1,
                title = "Produk Hukum",
                url = "https://ferys2195.github.io",
                subtitle = "lorem",
                destination = null
            ),
            Menu(
                icon = 1,
                title = "Daftar Informasi Publik",
                url = "https://laravel.com",
                subtitle = "lorem",
                destination = null
            ),
            Menu(
                icon = 1,
                title = "Formulir",
                url = "https://astro.build",
                subtitle = "lorem",
                destination = null
            ),
            Menu(
                icon = 1,
                title = "Data Penduduk",
                url = "https://nextjs.org",
                subtitle = "lorem",
                destination = null
            ),
            Menu(
                icon = 1,
                title = "Ok",
                url = "https://github.com",
                subtitle = "lorem",
                destination = null
            ),
            Menu(
                icon = 1,
                title = "All Apps",
                url = null,
                subtitle = "lorem",
                destination = MainActivity::class.java
            )
        )

        renderList(list)

        val header = listOf("Menu Utama")
        headerAdapter.addAll(header)
    }

    override fun onClick(note: Menu, position: Int, view: ItemMenuBinding) {
        if(note.url == null){
            startActivity(Intent(this@MainFragment.context, note.destination))
        }
        val navController = findNavController()
        val action = MainFragmentDirections.actionMainFragmentToWebFragment(note)
        navController.navigate(action)
    }
}

