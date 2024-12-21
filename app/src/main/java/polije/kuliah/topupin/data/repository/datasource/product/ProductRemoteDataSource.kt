package polije.kuliah.topupin.data.repository.datasource.product

import polije.kuliah.topupin.data.model.JenisProduk
import polije.kuliah.topupin.data.model.ProductList
import polije.kuliah.topupin.data.model.SendProduct
import retrofit2.Response

interface ProductRemoteDataSource {
    suspend fun getProduct(categoryName:SendProduct): Response<ProductList>
    suspend fun getCategoryProduct() : Response<JenisProduk>
}