package polije.kuliah.topupin.domain.usecase

import polije.kuliah.topupin.domain.repository.ProductRepository

class GetCategoryProductUseCase(private val repository: ProductRepository) {
    suspend fun execute() : List<String> = repository.getCategoryProduct()
}