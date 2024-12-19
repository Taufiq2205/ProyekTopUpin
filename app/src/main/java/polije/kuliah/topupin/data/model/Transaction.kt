package polije.kuliah.topupin.data.model

import com.google.gson.annotations.SerializedName

data class Transaction (

    @SerializedName("month")
    val month: String,
    @SerializedName("totalAmount")
    val totalAmount: String,
    @SerializedName("transactionType")
    val transactionType: String,
    @SerializedName("transactionDate")
    val transactionDate: String,
    @SerializedName("amount")
    val amount: String,
    @SerializedName("iconResId")
    val iconResId: Int

)
