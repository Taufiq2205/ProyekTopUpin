package polije.kuliah.topupin.data.repository

import android.util.Log
import polije.kuliah.topupin.data.model.Product
import polije.kuliah.topupin.data.model.SendProduct
import polije.kuliah.topupin.data.repository.datasource.product.ProductLocalDataSource
import polije.kuliah.topupin.data.repository.datasource.product.ProductRemoteDataSource
import polije.kuliah.topupin.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val productLocalDataSource : ProductLocalDataSource,
    private val productRemoteDataSource: ProductRemoteDataSource
) : ProductRepository {

    override suspend fun getProduct(categoryName:SendProduct): List<Product>? {
        return getProductFromAPI(categoryName)
    }

    override suspend fun getCategoryProduct(): List<String> {
        return getCategoryProductFromAPI()
    }

    suspend fun getProductFromAPI(categoryName: SendProduct) : List<Product>?{
         var product: List<Product>? = null
        try{
            val response = productRemoteDataSource.getProduct(categoryName)
            val body = response.body()
            if(body!=null){
                product = body.product
            }

        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        return product
    }

//    suspend fun getProductFromDB():List<Product>{
//        try{
//            val response = productLocalDataSource
//        }catch (e:Exception){
//            Log.i("MyTag",e.message.toString())
//        }
//    }

    suspend fun getCategoryProductFromAPI():List<String>{
        lateinit var jenisProduk: List<String>
        try{
            val response = productRemoteDataSource.getCategoryProduct()
            val body = response.body()
            if(body!=null){
                jenisProduk = body.data
            }
        }catch (e:Exception){
            Log.i("MyTag",e.message.toString())
        }
        return jenisProduk
    }

}