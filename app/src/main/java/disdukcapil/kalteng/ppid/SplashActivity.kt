package disdukcapil.kalteng.ppid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import disdukcapil.kalteng.ppid.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var _binding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        supportActionBar?.hide()
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            Animatoo.animateZoom(this)
            finish()
        }, 1000)

    }
}