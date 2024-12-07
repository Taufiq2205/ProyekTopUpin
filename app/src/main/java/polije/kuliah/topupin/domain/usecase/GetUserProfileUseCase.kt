package polije.kuliah.topupin.domain.usecase

import polije.kuliah.topupin.data.model.User
import polije.kuliah.topupin.data.model.UserLogin
import polije.kuliah.topupin.domain.repository.UserRepository

class GetUserProfileUseCase(private val repository: UserRepository) {
    suspend fun execute(userLogin: UserLogin): User? = repository.getUserProfileFromDB(userLogin)
    suspend fun execute(): User? = repository.getUserProfileFromDB()
}