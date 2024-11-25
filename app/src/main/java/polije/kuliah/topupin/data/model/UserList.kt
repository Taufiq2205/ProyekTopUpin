package polije.kuliah.topupin.data.model


import com.google.gson.annotations.SerializedName

data class UserList(
    @SerializedName("data")
    val user: User,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)