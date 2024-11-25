package polije.kuliah.topupin.data.api

import android.provider.ContactsContract.Data
import polije.kuliah.topupin.data.model.User
import polije.kuliah.topupin.data.model.UserList
import polije.kuliah.topupin.data.model.UserSend
import retrofit2.http.POST
import retrofit2.Response
import retrofit2.http.Body

interface TopUpinService {
    @POST("api/api_login.php")
    suspend fun getProfile(@Body userinfo:UserSend) : Response<UserList>
}