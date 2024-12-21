package polije.kuliah.topupin.domain.repository

import polije.kuliah.topupin.data.model.JenisProduk
import polije.kuliah.topupin.data.model.Product
import polije.kuliah.topupin.data.model.SendProduct

interface ProductRepository {
    suspend fun getProduct(categoryName:SendProduct) : List<Product>?
    suspend fun getCategoryProduct() : List<String>
}