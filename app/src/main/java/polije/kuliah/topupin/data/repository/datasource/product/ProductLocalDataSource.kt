package polije.kuliah.topupin.data.repository.datasource.product

import polije.kuliah.topupin.data.model.Product


interface ProductLocalDataSource {
    suspend fun getProductFromDB(): List<Product>
    suspend fun getProductFromDBFilterCategory():List<String>
    suspend fun saveProductFromDB(product: List<Product>)
    suspend fun clearAll()
}