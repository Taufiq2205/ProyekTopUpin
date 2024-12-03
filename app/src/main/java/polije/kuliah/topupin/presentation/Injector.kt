package polije.kuliah.topupin.presentation

import polije.kuliah.topupin.presentation.di.home.HomeSubComponent
import polije.kuliah.topupin.presentation.di.user.UserSubComponent

interface Injector {
    fun createUserSubComponent():UserSubComponent
    fun createHomeSubComponent(): HomeSubComponent
}