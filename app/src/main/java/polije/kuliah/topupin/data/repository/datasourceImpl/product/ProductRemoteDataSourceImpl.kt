package polije.kuliah.topupin.data.repository.datasourceImpl.product

import polije.kuliah.topupin.data.api.TopUpinService
import polije.kuliah.topupin.data.model.JenisProduk
import polije.kuliah.topupin.data.model.ProductList
import polije.kuliah.topupin.data.model.SendProduct
import polije.kuliah.topupin.data.repository.datasource.product.ProductRemoteDataSource
import retrofit2.Response

class ProductRemoteDataSourceImpl(private val topUpinService: TopUpinService) : ProductRemoteDataSource  {
    override suspend fun getProduct(categoryName:SendProduct): Response<ProductList> {
        return topUpinService.getProduct(categoryName)
    }


    override suspend fun getCategoryProduct(): Response<JenisProduk> {
        return topUpinService.getJenis()
    }

}