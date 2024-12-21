package polije.kuliah.topupin.data.api

import polije.kuliah.topupin.data.model.ProductList
import polije.kuliah.topupin.data.model.SendProduct
import polije.kuliah.topupin.data.model.UserData
import polije.kuliah.topupin.data.model.UserList
import polije.kuliah.topupin.data.model.UserLogin
import retrofit2.http.POST
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface TopUpinService {
    @POST("api/api_login.php")
    suspend fun getProfile(@Body userinfo:UserLogin) : Response<UserList>

    @POST("api/edit_profile.php")
    suspend fun editProfile(@Body userData: UserData) : Response<UserList>

    @POST("api/api_produk.php")
    suspend fun getProduct(@Body categoryName:SendProduct) : Response<ProductList>

    @GET("api/api_produk.php")
    suspend fun getJenis() : Response<JenisProduk>

//    @GET("path/to/your/api/endpoint")
//    fun getTransactions(): Response<Transaction>>

    @POST("api/api_register.php")
    suspend fun postRegister(@Body userinfo: UserRegister)
}