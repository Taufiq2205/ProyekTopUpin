package polije.kuliah.topupin.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import polije.kuliah.topupin.R
import polije.kuliah.topupin.databinding.ActivityMenuloginBinding

class LoginMenuActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMenuloginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_menulogin)

    }
}