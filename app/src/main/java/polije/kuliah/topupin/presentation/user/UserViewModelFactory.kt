package polije.kuliah.topupin.presentation.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Provides
import polije.kuliah.topupin.domain.usecase.DeleteDatabaseUser
import polije.kuliah.topupin.domain.usecase.GetCategoryProductUseCase
import polije.kuliah.topupin.domain.usecase.GetUserProfileUseCase
import polije.kuliah.topupin.domain.usecase.PostUserRegisterUseCase
import polije.kuliah.topupin.domain.usecase.UpdateUserProfileUseCase


class UserViewModelFactory(
    private val getUserProfileUseCase: GetUserProfileUseCase,
    private val updateUserProfileUseCase: UpdateUserProfileUseCase,
    private val postUserRegisterUseCase: PostUserRegisterUseCase,
    private val updateUserProfileUseCase: UpdateUserProfileUseCase,
    private val getCategoryProductUseCase: GetCategoryProductUseCase,
    private val deleteDatabaseUser: DeleteDatabaseUser,
    private val saveUserProfileUseCase: SaveUserProfileUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(getUserProfileUseCase,updateUserProfileUseCase,getCategoryProductUseCase,deleteDatabaseUser,saveUserProfileUseCase) as T
        return UserViewModel(getUserProfileUseCase,updateUserProfileUseCase, postUserRegisterUseCase) as T
    }
}