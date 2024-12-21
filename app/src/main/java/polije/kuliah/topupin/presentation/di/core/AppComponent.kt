package polije.kuliah.topupin.presentation.di.core

import dagger.Component
import polije.kuliah.topupin.presentation.di.user.UserSubComponent
import polije.kuliah.topupin.presentation.di.product.ProductSubComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    DatabaseModule::class,
    LocalDataModule::class,
    NetModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class
])
interface AppComponent {
    fun userSubComponent():UserSubComponent.Factory
    fun productSubComponent(): ProductSubComponent.Factory
}