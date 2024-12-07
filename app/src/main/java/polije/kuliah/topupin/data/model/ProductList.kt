package polije.kuliah.topupin.data.model


import com.google.gson.annotations.SerializedName

data class ProductList(
    @SerializedName("data")
    val product: List<Product>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)