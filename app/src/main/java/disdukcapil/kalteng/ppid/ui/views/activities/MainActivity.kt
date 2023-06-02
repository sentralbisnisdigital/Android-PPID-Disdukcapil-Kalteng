package disdukcapil.kalteng.ppid.ui.views.activities

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import disdukcapil.kalteng.ppid.R
import disdukcapil.kalteng.ppid.databinding.ActivityMainBinding
import disdukcapil.kalteng.ppid.data.models.Menu
import disdukcapil.kalteng.ppid.data.models.Tracking
import disdukcapil.kalteng.ppid.ui.viewmodels.TrackingViewModel
import disdukcapil.kalteng.ppid.ui.views.fragments.MainFragmentDirections
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private var navController : NavController? = null
    private val trackingViewModel: TrackingViewModel by viewModel()
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
            // Insert to database
            val code : String = data.pathSegments.last()
            val type : String = data.pathSegments[data.pathSegments.size - 1]
            trackingViewModel.insert(Tracking(null,trackingCode = code, trackingType = type, createdAt = "2020-05-01 00:00:00"))
            // show into web fragment
            val menu = Menu(url = data.toString())
            val action = MainFragmentDirections.actionMainFragmentToWebFragment(menu)
            navController!!.navigate(action)
            Animatoo.animateFade(this)
        }

    }



}