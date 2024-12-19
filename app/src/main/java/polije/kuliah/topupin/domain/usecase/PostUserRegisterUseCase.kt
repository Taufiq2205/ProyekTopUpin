package polije.kuliah.topupin.domain.usecase

import polije.kuliah.topupin.data.model.User
import polije.kuliah.topupin.data.model.UserRegister
import polije.kuliah.topupin.domain.repository.UserRepository

class PostUserRegisterUseCase(private val repository: UserRepository) {

    suspend fun execute(userRegister: UserRegister): Unit = repository.postUserRegister(userRegister)

}