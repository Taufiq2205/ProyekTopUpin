package polije.kuliah.topupin.presentation.di.product

import dagger.Module
import dagger.Provides
import polije.kuliah.topupin.domain.usecase.GetProductUseCase
import polije.kuliah.topupin.presentation.product.ProductViewModelFactory

@Module
class ProductModule {
    @ProductScope
    @Provides
    fun provideProductViewModel(
        getProductUseCase: GetProductUseCase
    ):ProductViewModelFactory{
        return ProductViewModelFactory(getProductUseCase)
    }
}