package polije.kuliah.topupin.data.model

import com.google.gson.annotations.SerializedName

data class SendProduct (
    @SerializedName("category")
    val productName : String
)