package polije.kuliah.topupin.presentation

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.transition.Slide
import androidx.transition.TransitionManager
import polije.kuliah.topupin.R
import polije.kuliah.topupin.databinding.ActivityMenuloginBinding
import polije.kuliah.topupin.presentation.user.LoginActivity
import polije.kuliah.topupin.presentation.user.RegisterActivity

class LoginMenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuloginBinding
    private var debounce = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_menulogin)


        binding.btnLogin.setOnClickListener {
//            <Animation>
//            toggle(!debounce)
//            debounce = !debounce

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    fun toggle(show: Boolean) {
        val transition = Slide(Gravity.TOP)
        transition.duration = 500
        transition.addTarget(binding.redLayout)

        TransitionManager.beginDelayedTransition(binding.root as ViewGroup, transition)


    }
}

