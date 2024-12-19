package polije.kuliah.topupin.presentation.user

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import jakarta.inject.Inject
import polije.kuliah.topupin.R
import polije.kuliah.topupin.data.model.User
import polije.kuliah.topupin.data.model.UserRegister
import polije.kuliah.topupin.databinding.ActivityRegisterBinding
import polije.kuliah.topupin.presentation.Injector

class RegisterActivity: AppCompatActivity() {

    @Inject
    lateinit var factory: UserViewModelFactory

    private lateinit var userViewModel: UserViewModel
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        (application as Injector).createHomeSubComponent().inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        userViewModel = ViewModelProvider(this, factory)
            .get(UserViewModel::class.java)

        binding.btnRegister.setOnClickListener{
            val usernameText = binding.txtUsername.text.toString()
            val emailText = binding.txtEmail.text.toString()
            val passText = binding.txtPassword.text.toString()
            val ConfirmpassText = binding.txtConfirmpass.text.toString()
            val noHpText = binding.txtTelepon.text.toString()
            val namas = binding.txtNama.text.toString()

            if (usernameText.isEmpty() || emailText.isEmpty() || passText.isEmpty() || ConfirmpassText.isEmpty()) {
                Toast.makeText(this, "Semua kolom wajib diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (passText != ConfirmpassText) {
                Toast.makeText(this, "Password dan Konfirmasi Password tidak cocok", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            userViewModel.registerUser(UserRegister(usernameText, passText, emailText, noHpText, namas))
            Toast.makeText(this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show()
        }
    }
}