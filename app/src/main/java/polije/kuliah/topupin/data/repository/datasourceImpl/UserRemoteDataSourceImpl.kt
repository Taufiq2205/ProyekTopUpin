package polije.kuliah.topupin.data.repository.datasourceImpl

import polije.kuliah.topupin.data.api.TopUpinService
import polije.kuliah.topupin.data.model.User
import polije.kuliah.topupin.data.model.UserList
import polije.kuliah.topupin.data.model.UserSend
import polije.kuliah.topupin.data.repository.datasource.UserRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class UserRemoteDataSourceImpl (private val topUpinService: TopUpinService) : UserRemoteDataSource{
    override suspend fun getUser(userDatas:UserSend): Response<UserList> {
        return topUpinService.getProfile(userDatas)
    }
}