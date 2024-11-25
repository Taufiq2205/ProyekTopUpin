package polije.kuliah.topupin.data.repository.datasource

import polije.kuliah.topupin.data.model.User
import polije.kuliah.topupin.data.model.UserList
import polije.kuliah.topupin.data.model.UserSend
import retrofit2.Response

interface UserRemoteDataSource {
    suspend fun getUser(userSend: UserSend): Response<UserList>
}