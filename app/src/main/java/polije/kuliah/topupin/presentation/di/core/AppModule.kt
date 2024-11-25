package polije.kuliah.topupin.presentation.di.core

import android.content.Context
import dagger.Module
import dagger.Provides
import polije.kuliah.topupin.presentation.di.user.UserSubComponent
import javax.inject.Singleton

@Module(subcomponents = [UserSubComponent::class])
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideApplicationContext(): Context{
        return context.applicationContext
    }
}