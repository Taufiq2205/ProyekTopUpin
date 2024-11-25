package polije.kuliah.topupin.data.model

import com.google.gson.annotations.SerializedName

data class UserSend(
    @SerializedName("username")
    var username: String,
    @SerializedName("password")
    var password: String
)