package polije.kuliah.topupin.data.repository.datasource.user

import polije.kuliah.topupin.data.model.User

interface UserLocalDataSource {
    suspend fun getUserFromDB(userId:String):User
    suspend fun getUserFromDB():User
    suspend fun saveUserFromDB(user:User?)
    suspend fun clearAll()
}