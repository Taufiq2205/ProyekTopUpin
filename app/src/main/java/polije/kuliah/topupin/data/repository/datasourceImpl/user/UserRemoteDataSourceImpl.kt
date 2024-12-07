package polije.kuliah.topupin.data.repository.datasourceImpl.user

import polije.kuliah.topupin.data.api.TopUpinService
import polije.kuliah.topupin.data.model.UserData
import polije.kuliah.topupin.data.model.UserList
import polije.kuliah.topupin.data.model.UserLogin
import polije.kuliah.topupin.data.repository.datasource.user.UserRemoteDataSource
import retrofit2.Response

class UserRemoteDataSourceImpl (private val topUpinService: TopUpinService) : UserRemoteDataSource {
    override suspend fun getUser(userDatas:UserLogin): Response<UserList> {
        return topUpinService.getProfile(userDatas)
    }

    override suspend fun updateuser(userData: UserData) : Response<UserList> {
        return topUpinService.editProfile(userData)
    }
}