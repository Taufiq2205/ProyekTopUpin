package polije.kuliah.topupin.domain.usecase

import polije.kuliah.topupin.data.model.Product
import polije.kuliah.topupin.domain.repository.ProductRepository

class GetProductUseCase(private val repository: ProductRepository) {
    suspend fun execute() : List<Product> = repository.getProduct()
}