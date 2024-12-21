package polije.kuliah.topupin.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "product_data")
data class Product(

    @SerializedName("code")
    val code: String,
    @SerializedName("created_date")
    val createdDate: String,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("harga_jual")
    val hargaJual: String,
    @SerializedName("harga_modal")
    val hargaModal: String,
    @SerializedName("harga_reseller")
    val hargaReseller: String,
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("jenis")
    val jenis: String,
    @SerializedName("kategori")
    val kategori: String,
    @SerializedName("product_type")
    val productType: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("title")
    val title: String
)