package polije.kuliah.topupin.presentation.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import polije.kuliah.topupin.domain.usecase.GetUserProfileUseCase

class UserViewModelFactory(
    private val getUserProfileUseCase: GetUserProfileUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(getUserProfileUseCase) as T
    }
}