package polije.kuliah.topupin.presentation.di.core

import dagger.BindsInstance
import dagger.Component
import polije.kuliah.topupin.data.model.UserSend
import polije.kuliah.topupin.presentation.di.home.HomeSubComponent
import polije.kuliah.topupin.presentation.di.user.UserSubComponent
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
    fun homeSubComponent(): HomeSubComponent.Factory
}