package polije.kuliah.topupin.data.model


import com.google.gson.annotations.SerializedName

data class JenisProduk(
    @SerializedName("data")
    val data: List<String>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)