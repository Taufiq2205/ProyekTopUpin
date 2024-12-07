package polije.kuliah.topupin.data.repository.datasource.user

import polije.kuliah.topupin.data.model.UserData
import polije.kuliah.topupin.data.model.UserList
import polije.kuliah.topupin.data.model.UserLogin
import retrofit2.Response

interface UserRemoteDataSource {
    suspend fun getUser(userLogin: UserLogin): Response<UserList>
    suspend fun updateuser(userData: UserData) : Response<UserList>
}