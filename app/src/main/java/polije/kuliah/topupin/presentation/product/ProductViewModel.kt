package polije.kuliah.topupin.presentation.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import polije.kuliah.topupin.domain.usecase.GetProductUseCase

class ProductViewModel(
    private val productUseCase: GetProductUseCase
) : ViewModel() {

    fun getProduct() =  liveData {
        val product = productUseCase.execute()
        emit(product)
    }
}