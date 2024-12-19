package polije.kuliah.topupin.domain.repository

import polije.kuliah.topupin.data.model.User
import polije.kuliah.topupin.data.model.UserData
import polije.kuliah.topupin.data.model.UserLogin
import polije.kuliah.topupin.data.model.UserRegister

interface UserRepository {
    suspend fun getUserProfileFromDB(userLogin: UserLogin) : User?
    suspend fun getUserProfileFromDB() : User?
    suspend fun getUserProfileFromAPI(userLogin: UserLogin) : User?
    suspend fun updateUserProfile(userData: UserData)
    suspend fun saveUser(user: User)
    suspend fun deleleUserDatabase()
    suspend fun postUserRegister(userRegister: UserRegister)
}