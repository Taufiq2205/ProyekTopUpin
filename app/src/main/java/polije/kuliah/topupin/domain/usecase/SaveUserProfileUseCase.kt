package polije.kuliah.topupin.domain.usecase

import polije.kuliah.topupin.data.model.User
import polije.kuliah.topupin.domain.repository.UserRepository

class SaveUserProfileUseCase(private val repository: UserRepository) {
    suspend fun execute(user: User) = repository.saveUser(user)
}