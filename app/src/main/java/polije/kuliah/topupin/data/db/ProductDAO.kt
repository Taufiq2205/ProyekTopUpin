package polije.kuliah.topupin.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import polije.kuliah.topupin.data.model.Product

@Dao
interface ProductDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProduct(product: List<Product>)
    @Query("DELETE FROM product_data")
    suspend fun deleteAllProduct()
    @Query("SELECT * FROM product_data")
    suspend fun getAllProduct() : List<Product>
//    @Query("SELECT ")
//    suspend fun getProductCategory():List<String>
}