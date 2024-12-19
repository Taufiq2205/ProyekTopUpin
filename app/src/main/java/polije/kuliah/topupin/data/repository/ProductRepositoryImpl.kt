package polije.kuliah.topupin.data.repository

import android.util.Log
import polije.kuliah.topupin.data.model.JenisProduk
import polije.kuliah.topupin.data.model.Product
import polije.kuliah.topupin.data.repository.datasource.product.ProductLocalDataSource
import polije.kuliah.topupin.data.repository.datasource.product.ProductRemoteDataSource
import polije.kuliah.topupin.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val productLocalDataSource : ProductLocalDataSource,
    private val productRemoteDataSource: ProductRemoteDataSource
) : ProductRepository {

    override suspend fun getProduct(): List<Product> {
        return getProductFromDB()
    }

    override suspend fun getCategoryProduct(): List<String> {
        return getCategoryProductFromAPI()
    }

    suspend fun getProductFromAPI() : List<Product>{
        lateinit var product: List<Product>
        try{
            val response = productRemoteDataSource.getProduct()
            val body = response.body()
            if(body!=null){
                product = body.product
            }

        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        return product
    }
    
    suspend fun getProductFromDB():List<Product>{
        lateinit var product:List<Product>
        try {
            product = productLocalDataSource.getProductFromDB()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if(product.size>0){
            return product
        }else{
            product = getProductFromAPI()
            productLocalDataSource.saveProductFromDB(product)
        }
        return product
    }

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