package polije.kuliah.topupin.domain.repository

import polije.kuliah.topupin.data.model.JenisProduk
import polije.kuliah.topupin.data.model.Product

interface ProductRepository {
    suspend fun getProduct() : List<Product>
    suspend fun getCategoryProduct() : List<String>
}