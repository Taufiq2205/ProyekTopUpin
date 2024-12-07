package polije.kuliah.topupin.presentation.user

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import polije.kuliah.topupin.R
import polije.kuliah.topupin.data.model.UserLogin
import polije.kuliah.topupin.databinding.ActivityLoginBinding
import polije.kuliah.topupin.presentation.Injector
import polije.kuliah.topupin.presentation.user.home.MainActivity
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: UserViewModelFactory
    private lateinit var userViewModel: UserViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inject dependencies
        (application as Injector).createUserSubComponent().inject(this)

        // Initialize DataBinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        // ViewModel setup
        userViewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)

        // Button click listener
        binding.btnLogin.setOnClickListener {
            val usernameText = binding.txtUsername.text.toString()
            val passwordText = binding.txtPassword.text.toString()

            // Validate inputs first
            if (usernameText.isEmpty() || passwordText.isEmpty()) {
                Toast.makeText(applicationContext, "Username atau Password Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Save credentials asynchronously
            CoroutineScope(Dispatchers.IO).launch {
                val userDataManager = UserDataManager(applicationContext)
                userDataManager.saveCredential(usernameText, passwordText)
            }

            // Observe user profile and handle response
            userViewModel.getUserProfile(UserLogin(usernameText, passwordText)).observe(this, Observer { response ->
                if (response != null) {
                    // On successful login, navigate to MainActivity
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    // Show error if response is null
                    Toast.makeText(applicationContext, "Login gagal, silakan coba lagi.", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
