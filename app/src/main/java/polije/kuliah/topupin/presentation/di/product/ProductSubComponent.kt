package polije.kuliah.topupin.presentation.di.product

import dagger.Subcomponent
import polije.kuliah.topupin.presentation.product.ProductActivity

@ProductScope
@Subcomponent(modules = [ProductModule::class])
interface ProductSubComponent {
    fun inject(productActivity: ProductActivity)
    @Subcomponent.Factory
    interface Factory {
        fun create(): ProductSubComponent
    }
}