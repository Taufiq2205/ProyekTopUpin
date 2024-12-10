package polije.kuliah.topupin.presentation.user.home

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import polije.kuliah.topupin.R
import polije.kuliah.topupin.databinding.ActivityMainBinding
import polije.kuliah.topupin.presentation.Injector
import polije.kuliah.topupin.presentation.user.UserViewModel
import polije.kuliah.topupin.presentation.user.UserViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var factory: UserViewModelFactory
    private lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        (application as Injector).createUserSubComponent().inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        userViewModel = ViewModelProvider(this, factory)
            .get(UserViewModel::class.java)

        replaceFragment(HomeFragment())
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home_bar -> replaceFragment(HomeFragment())
                R.id.profile_bar -> replaceFragment(ProfileFragment())
                else -> {

                }
            }
            true
        }

    }

        private fun replaceFragment(fragment: Fragment) {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frameLayout, fragment)
            fragmentTransaction.commit()

    }
}
