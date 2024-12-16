package polije.kuliah.topupin.presentation.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import polije.kuliah.topupin.data.model.User
import polije.kuliah.topupin.data.model.UserData
import polije.kuliah.topupin.data.model.UserLogin
import polije.kuliah.topupin.domain.usecase.DeleteDatabaseUser
import polije.kuliah.topupin.domain.usecase.GetCategoryProductUseCase
import polije.kuliah.topupin.domain.usecase.GetUserProfileUseCase
import polije.kuliah.topupin.domain.usecase.SaveUserProfileUseCase
import polije.kuliah.topupin.domain.usecase.UpdateUserProfileUseCase

class UserViewModel(
    private val getUserProfileUseCase: GetUserProfileUseCase,
    private val updateUserProfileUseCase: UpdateUserProfileUseCase,
    private val getCategoryProductUseCase: GetCategoryProductUseCase,
    private val deleteDatabaseUser: DeleteDatabaseUser,
    private val saveUserProfileUseCase: SaveUserProfileUseCase
) : ViewModel() {


    fun saveUser(user: User) = CoroutineScope(Dispatchers.IO).launch {
        saveUserProfileUseCase.execute(user)
    }

    fun getUserProfile(userLogin: UserLogin) = liveData {
        val getUser = getUserProfileUseCase.execute(userLogin)
        emit(getUser)
    }

    fun getUserProfile() = liveData {
        val getUser = getUserProfileUseCase.execute()
        emit(getUser)
    }

    fun getCategoryProduct() = liveData {
        val getCategory = getCategoryProductUseCase.execute()
        emit(getCategory)
    }
    fun updateProfile(userData: UserData) {
        CoroutineScope(Dispatchers.IO).launch {
            updateUserProfileUseCase.execute(userData)
        }
    }

    fun getUserProfileAPI(userLogin: UserLogin) = liveData {
        val getUser = getUserProfileUseCase.executeAPI(userLogin)
        emit(getUser)
    }
    fun deleteAllUser() = CoroutineScope(Dispatchers.IO).launch {
        deleteDatabaseUser.execute()
    }

}