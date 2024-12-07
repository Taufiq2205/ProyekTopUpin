package polije.kuliah.topupin.domain.usecase

import polije.kuliah.topupin.data.model.UserData
import polije.kuliah.topupin.domain.repository.UserRepository

class UpdateUserProfileUseCase(private val repository:UserRepository) {
    suspend fun execute(userData: UserData) = repository.updateUserProfile(userData)
}