package polije.kuliah.topupin.presentation.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import polije.kuliah.topupin.data.model.UserSend
import polije.kuliah.topupin.domain.usecase.GetUserProfileUseCase

class UserViewModel(
    private val getUserProfileUseCase: GetUserProfileUseCase
) :ViewModel() {
    fun getUserProfile(userSend: UserSend) = liveData {
        val getUser = getUserProfileUseCase.execute(userSend)
        emit(getUser)
    }
    fun getUserProfile() = liveData {
        val getUser = getUserProfileUseCase.execute()
        emit(getUser)
    }
}