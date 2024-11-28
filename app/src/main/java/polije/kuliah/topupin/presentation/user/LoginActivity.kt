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

class LoginActivity : AppCompatActivity(){
    private lateinit var userViewModel: UserViewModel
    private lateinit var binding: ActivityLoginBinding
    @Inject
    lateinit var factory: UserViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        (application as Injector).createUserSubComponent()
            .inject(this)
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)

        userViewModel = ViewModelProvider(this,factory)
            .get(UserViewModel::class.java)

        binding.btnLogin.setOnClickListener{
            val usernameText  = binding.txtUsername.text.toString()
            val passwordText = binding.txtPassword.text.toString()
            if(!usernameText.isEmpty() || !passwordText.isEmpty()){
                val responseLiveData = userViewModel.getUserProfile(UserSend(usernameText,passwordText))

                responseLiveData.observe(this, Observer {
                    try {
                        if (it != null) {
//                            val intent = Intent(this,MainActivity::class.java)
//                            startActivity(intent)
                        }
                    }catch (exception:Exception){
                        Toast.makeText(applicationContext,exception.message.toString(),Toast.LENGTH_SHORT).show()
                    }
                })
            }else{
                Toast.makeText(applicationContext,"Username atau Password Tidak Boleh Kosong",Toast.LENGTH_SHORT).show()
            }



        }


    }

}