package polije.kuliah.topupin.data.repository.datasourceImpl.product

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import polije.kuliah.topupin.data.db.ProductDAO
import polije.kuliah.topupin.data.model.Product
import polije.kuliah.topupin.data.repository.datasource.product.ProductLocalDataSource

class ProductLocalDataSourceImpl(private val productDAO: ProductDAO) : ProductLocalDataSource {
    override suspend fun getProductFromDB(): List<Product> {
        return productDAO.getAllProduct()
    }

    override suspend fun saveProductFromDB(product: List<Product>) {
        CoroutineScope(Dispatchers.IO).launch {

            productDAO.saveProduct(product)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            productDAO.deleteAllProduct()

        }
    }
}