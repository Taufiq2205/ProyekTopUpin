package polije.kuliah.topupin.presentation.user

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.first
import polije.kuliah.topupin.R
import polije.kuliah.topupin.data.model.UserData
import polije.kuliah.topupin.data.model.UserLogin
import polije.kuliah.topupin.databinding.ActivityProfilesettingsBinding
import polije.kuliah.topupin.presentation.Injector
import javax.inject.Inject

class ProfileSettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfilesettingsBinding
    private lateinit var userViewModel: UserViewModel
    private lateinit var userDataManager: UserDataManager

    @Inject
    lateinit var factory: UserViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        (application as Injector).createUserSubComponent().inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profilesettings)
        userDataManager = UserDataManager(applicationContext)
        userViewModel = ViewModelProvider(this, factory)
            .get(UserViewModel::class.java)

        setProfile()
        binding.btnSave.setOnClickListener {
            val name = binding.edtOldPassword.text.toString()
            val email = binding.edtNewPassword.text.toString()
            val number = binding.edtConfirmPassword.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && number.isNotEmpty()) {
                userViewModel.getUserProfile().observe(this, Observer {
                    it?.let {
                        userViewModel.updateProfile(UserData(it.userId, name, email, number))

                        Log.i("MyTag","Test123")
                    }.run {
                        Toast.makeText(
                            applicationContext,
                            "Update Berhasil" + it.toString(),
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                })

            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun setProfile() {
        userViewModel.getUserProfile().observe(this, Observer { user ->
            user?.let {
                binding.edtOldPassword.setText(user.username)
                binding.edtNewPassword.setText(user.email)
                binding.edtConfirmPassword.setText(user.noHp)
            }
        })
    }

    suspend fun updateProfile() {
        val username = userDataManager.getUserName().first()
        val password = userDataManager.getUserPassword().first()

        userViewModel.getUserProfile(UserLogin(username, password)).observe(this, Observer { user ->
            user?.let {
                binding.edtOldPassword.setText(user.username)
                binding.edtNewPassword.setText(user.email)
                binding.edtConfirmPassword.setText(user.noHp)
            }
        })
    }
}
