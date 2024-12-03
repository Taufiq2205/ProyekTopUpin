package polije.kuliah.topupin.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import polije.kuliah.topupin.R
import polije.kuliah.topupin.databinding.FragmentProfileBinding
import polije.kuliah.topupin.presentation.user.UserViewModel

class ProfileFragment: Fragment(R.layout.fragment_profile) {
    private lateinit var binding: FragmentProfileBinding
    private val userViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Use DataBinding to inflate the fragment layout
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        // Observe the user profile LiveData from the ViewModel
        val responseLiveData = userViewModel.getUserProfile()

        responseLiveData.observe(viewLifecycleOwner, Observer { user ->
            user?.let {
                binding.tvName.text = user.username
                binding.tvEmail.text = user.email
                binding.tvPhoneNumber.text = user.noHp
            } ?: run {
                // Handle null user case
                Toast.makeText(context, "User data not available", Toast.LENGTH_SHORT).show()
            }
        })

        return binding.root
    }
}
