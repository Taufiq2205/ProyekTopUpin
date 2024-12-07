package polije.kuliah.topupin.data.repository.datasourceImpl.product

import polije.kuliah.topupin.data.api.TopUpinService
import polije.kuliah.topupin.data.model.ProductList
import polije.kuliah.topupin.data.repository.datasource.product.ProductRemoteDataSource
import retrofit2.Response

class ProductRemoteDataSourceImpl(private val topUpinService: TopUpinService) : ProductRemoteDataSource  {
    override suspend fun getUser(): Response<ProductList> {
        return topUpinService.getProduct()
    }
}