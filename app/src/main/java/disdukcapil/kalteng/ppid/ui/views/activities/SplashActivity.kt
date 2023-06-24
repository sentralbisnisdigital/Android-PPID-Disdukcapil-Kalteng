package disdukcapil.kalteng.ppid.ui.views.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import disdukcapil.kalteng.ppid.R
import disdukcapil.kalteng.ppid.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    private lateinit var _binding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        supportActionBar?.hide()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false
        window.statusBarColor = this.resources.getColor(R.color.bg_light)
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            Animatoo.animateZoom(this)
            finish()
        }, 1000)

    }
}