package polije.kuliah.topupin.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import polije.kuliah.topupin.data.model.UserSend
import polije.kuliah.topupin.presentation.di.core.AppComponent
import polije.kuliah.topupin.presentation.di.core.AppModule
import polije.kuliah.topupin.presentation.di.core.DaggerAppComponent
import polije.kuliah.topupin.presentation.di.core.DatabaseModule
import polije.kuliah.topupin.presentation.di.core.LocalDataModule
import polije.kuliah.topupin.presentation.di.core.NetModule
import polije.kuliah.topupin.presentation.di.core.RemoteDataModule
import polije.kuliah.topupin.presentation.di.user.UserSubComponent
import polije.kuliah.topupin.presentation.user.UserViewModel
import polije.kuliah.topupin.presentation.user.UserViewModelFactory

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent
    val baseUrl = "http://10.0.2.2/ppob2/"
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

//    override fun createUserSubComponent(userSend: UserSend): UserSubComponent {
//        return appComponent.userSubComponent().create(userSend)
//    }


}