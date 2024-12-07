package polije.kuliah.topupin.presentation.di.core

import android.content.Context
import dagger.Module
import dagger.Provides
import polije.kuliah.topupin.presentation.di.home.HomeSubComponent
import polije.kuliah.topupin.presentation.di.user.UserSubComponent
import polije.kuliah.topupin.presentation.di.product.ProductSubComponent
import javax.inject.Singleton

@Module(subcomponents = [UserSubComponent::class,HomeSubComponent::class, ProductSubComponent::class])
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideApplicationContext(): Context{
        return context.applicationContext
    }
}