package polije.kuliah.topupin.data.model

import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("id")
    var id : String,
    @SerializedName("full_name")
    var full_name : String,
    @SerializedName("email")
    var email : String,
    @SerializedName("no_hp")
    var no_hp : String,
)