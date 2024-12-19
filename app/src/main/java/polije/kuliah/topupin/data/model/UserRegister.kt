package polije.kuliah.topupin.data.model

import com.google.gson.annotations.SerializedName

data class UserRegister(

    @SerializedName("username")
    var username: String,
    @SerializedName("password")
    var password: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("nohp")
    var notelp: String,
    @SerializedName("fullname")
    var nama: String

)