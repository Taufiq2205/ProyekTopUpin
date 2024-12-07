package polije.kuliah.topupin.presentation

import polije.kuliah.topupin.presentation.di.home.HomeSubComponent
import polije.kuliah.topupin.presentation.di.user.UserSubComponent
import polije.kuliah.topupin.presentation.di.product.ProductSubComponent

interface Injector {
    fun createUserSubComponent():UserSubComponent
    fun createHomeSubComponent(): HomeSubComponent
    fun createProductSubComponent(): ProductSubComponent
}