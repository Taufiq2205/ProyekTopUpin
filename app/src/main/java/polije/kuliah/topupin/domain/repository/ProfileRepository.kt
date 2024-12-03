package polije.kuliah.topupin.domain.repository

import polije.kuliah.topupin.data.model.User
import polije.kuliah.topupin.data.model.UserSend

interface ProfileRepository {
    suspend fun getUserProfile(userSend: UserSend) : User?
    suspend fun getUserProfile() : User?
}