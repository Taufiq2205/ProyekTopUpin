package polije.kuliah.topupin.presentation

import android.app.Application
import polije.kuliah.topupin.presentation.di.core.AppComponent
import polije.kuliah.topupin.presentation.di.core.AppModule
import polije.kuliah.topupin.presentation.di.core.DaggerAppComponent
import polije.kuliah.topupin.presentation.di.core.DatabaseModule
import polije.kuliah.topupin.presentation.di.core.LocalDataModule
import polije.kuliah.topupin.presentation.di.core.NetModule
import polije.kuliah.topupin.presentation.di.home.HomeSubComponent
import polije.kuliah.topupin.presentation.di.user.UserSubComponent
import polije.kuliah.topupin.presentation.di.product.ProductSubComponent

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent
    val baseUrl = "https://topupin.web.id"
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(baseUrl))
            .databaseModule(DatabaseModule())
            .localDataModule(LocalDataModule())
            .build()
    }

    override fun createUserSubComponent(): UserSubComponent {
        return appComponent.userSubComponent().create()
    }

    override fun createHomeSubComponent(): HomeSubComponent {
        return appComponent.homeSubComponent().create()
    }

    override fun createProductSubComponent(): ProductSubComponent {
        return appComponent.productSubComponent().create()
    }



}