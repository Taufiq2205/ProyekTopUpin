package polije.kuliah.topupin.presentation

import polije.kuliah.topupin.presentation.di.user.UserSubComponent
import polije.kuliah.topupin.presentation.di.product.ProductSubComponent

interface Injector {
    fun createUserSubComponent():UserSubComponent
    fun createProductSubComponent(): ProductSubComponent
}