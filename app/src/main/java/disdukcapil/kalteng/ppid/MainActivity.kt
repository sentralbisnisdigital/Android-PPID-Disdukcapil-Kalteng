package disdukcapil.kalteng.ppid

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import disdukcapil.kalteng.ppid.databinding.ActivityMainBinding
import disdukcapil.kalteng.ppid.models.Menu
import disdukcapil.kalteng.ppid.views.fragments.MainFragmentDirections

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private var navController : NavController? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController =  findNavController(R.id.nav_host_fragment_content_home)
        showFragmentUsingDeepLink()
        setupActionBarWithNavController(navController!!)
    }
    // Update action bar with the nav controller
    override fun onSupportNavigateUp(): Boolean {
        return navController!!.navigateUp() ||  super.onSupportNavigateUp()
    }

    private fun showFragmentUsingDeepLink(){
        val data: Uri? = intent?.data

        if (data != null) {
            val menu = Menu(title = null, url = data.toString(), subMenu = null, icon = null, destination = null, subtitle = null)
            val action = MainFragmentDirections.actionMainFragmentToWebFragment(menu)
            navController!!.navigate(action)
            Animatoo.animateFade(this)
        }

    }



}