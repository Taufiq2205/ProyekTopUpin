package polije.kuliah.topupin.presentation.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import polije.kuliah.topupin.data.model.UserData
import polije.kuliah.topupin.data.model.UserLogin
import polije.kuliah.topupin.domain.usecase.GetUserProfileUseCase
import polije.kuliah.topupin.domain.usecase.UpdateUserProfileUseCase

class UserViewModel(
    private val getUserProfileUseCase: GetUserProfileUseCase,
    private val updateUserProfileUseCase: UpdateUserProfileUseCase
) :ViewModel() {


    fun getUserProfile(userLogin: UserLogin) = liveData {
        val getUser = getUserProfileUseCase.execute(userLogin)
        emit(getUser)
    }
    fun getUserProfile() = liveData {
        val getUser = getUserProfileUseCase.execute()
        emit(getUser)
    }
    fun updateProfile(userData: UserData) {
        CoroutineScope(Dispatchers.IO).launch {
            updateUserProfileUseCase.execute(userData)
        }
    }
}