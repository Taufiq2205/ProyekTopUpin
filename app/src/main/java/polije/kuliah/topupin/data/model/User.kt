package polije.kuliah.topupin.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_data")
data class User(
    @PrimaryKey
    val user: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("no_hp")
    val noHp: String,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("full_name")
    val fullName :String
)