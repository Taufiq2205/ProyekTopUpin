package polije.kuliah.topupin.domain.usecase

import polije.kuliah.topupin.data.model.User
import polije.kuliah.topupin.data.model.UserSend
import polije.kuliah.topupin.domain.repository.ProfileRepository

class GetUserProfileUseCase(private val repository: ProfileRepository) {
    suspend fun execute(userSend: UserSend): User? = repository.getUserProfile(userSend)
}