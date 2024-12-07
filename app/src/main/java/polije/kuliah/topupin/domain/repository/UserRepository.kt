package polije.kuliah.topupin.domain.repository

import polije.kuliah.topupin.data.model.User
import polije.kuliah.topupin.data.model.UserData
import polije.kuliah.topupin.data.model.UserLogin

interface UserRepository {
    suspend fun getUserProfileFromDB(userLogin: UserLogin) : User?
    suspend fun getUserProfileFromDB() : User?
    suspend fun updateUserProfile(userData: UserData)
}