package polije.kuliah.topupin.presentation.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import polije.kuliah.topupin.domain.usecase.GetProductUseCase

class ProductViewModelFactory (
    private val productUseCase: GetProductUseCase
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(productUseCase) as T
    }
}