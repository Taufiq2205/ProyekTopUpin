package polije.kuliah.topupin.presentation.user

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import polije.kuliah.topupin.R
import polije.kuliah.topupin.data.model.UserSend
import polije.kuliah.topupin.databinding.ActivityLoginBinding
import polije.kuliah.topupin.presentation.Injector
import polije.kuliah.topupin.presentation.home.MainActivity
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: UserViewModelFactory

    private lateinit var userViewModel: UserViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        (application as Injector).createUserSubComponent().inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        userViewModel = ViewModelProvider(this, factory)
            .get(UserViewModel::class.java)

        binding.btnLogin.setOnClickListener {
            val usernameText = binding.txtUsername.text.toString()
            val passwordText = binding.txtPassword.text.toString()

            if (usernameText.isNotEmpty() && passwordText.isNotEmpty()) {
                userViewModel.getUserProfile(UserSend(usernameText, passwordText))
                    .observe(this, Observer { response ->
                        try {
                            if (response != null) {
                                val intent = Intent(this, RegisterActivity::class.java)
                                startActivity(intent)
                            }
                        } catch (exception: Exception) {
                            Toast.makeText(
                                applicationContext,
                                exception.message.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    })
            } else {
                Toast.makeText(
                    applicationContext,
                    "Username atau Password Tidak Boleh Kosong",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}