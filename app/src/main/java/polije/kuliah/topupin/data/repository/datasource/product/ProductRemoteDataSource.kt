package polije.kuliah.topupin.data.repository.datasource.product

import polije.kuliah.topupin.data.model.ProductList
import retrofit2.Response

interface ProductRemoteDataSource {
    suspend fun getUser(): Response<ProductList>
}