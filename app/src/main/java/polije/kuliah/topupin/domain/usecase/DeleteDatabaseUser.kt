package polije.kuliah.topupin.domain.usecase

import polije.kuliah.topupin.domain.repository.UserRepository

class DeleteDatabaseUser(private val repository: UserRepository) {
    suspend fun execute() = repository.deleleUserDatabase()
}