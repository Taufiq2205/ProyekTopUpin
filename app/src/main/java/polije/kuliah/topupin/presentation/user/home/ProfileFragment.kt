package polije.kuliah.topupin.presentation.user.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import polije.kuliah.topupin.R
import polije.kuliah.topupin.data.model.UserLogin
import polije.kuliah.topupin.databinding.FragmentProfileBinding
import polije.kuliah.topupin.presentation.user.ProfileSettingActivity
import polije.kuliah.topupin.presentation.user.UserDataManager
import polije.kuliah.topupin.presentation.user.UserViewModel

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private val userViewModel: UserViewModel by activityViewModels()
    private lateinit var userDataManager: UserDataManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Use DataBinding to inflate the fragment layout
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        userDataManager = UserDataManager(requireContext())

        // Observe the user profile LiveData from the ViewModel

        // Collect the username and password from DataStore once


        // Navigate to ProfileSettings Activity
        binding.btnProfileSetting.setOnClickListener {
            val intent = Intent(context, ProfileSettingActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            getUserFromAPI()
            Log.d("MyTag","From Profile Fragment : API Called")
        }
    }
    suspend fun getUserFromAPI(){

            val username = userDataManager.getUserName().first() // Use `first()` to get the value immediately
            val password = userDataManager.getUserPassword().first() // Similarly collect password

            // Now you can use these values to request user profile data
            userViewModel.getUserProfile(UserLogin(username, password)).observe(viewLifecycleOwner, Observer { newUser ->
                newUser?.let {
                    // Only update the UI if data has changed
                    binding.tvName.text = it.fullName
                    binding.tvEmail.text = it.email
                    binding.tvPhoneNumber.text = it.noHp
                } ?: run {
                    // Handle case when `newUser` is null
                    Toast.makeText(context, "User data not available", Toast.LENGTH_SHORT).show()
                }
            })

    }
}
