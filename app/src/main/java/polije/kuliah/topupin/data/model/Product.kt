package polije.kuliah.topupin.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "product_data")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val idLocal : Int,
    @SerializedName("harga_jual")
    val hargaJual: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("kategori")
    val kategori: String,
    @SerializedName("title")
    val title: String
)