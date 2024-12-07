package polije.kuliah.topupin.presentation.di.core

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import polije.kuliah.topupin.data.db.ProductDAO
import polije.kuliah.topupin.data.db.TopUpinDatabase
import polije.kuliah.topupin.data.db.UserDAO
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideUserDatabase(context: Context):TopUpinDatabase{
        return Room.databaseBuilder(context,TopUpinDatabase::class.java,"topupinclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideUserDAO(topUpinDatabase: TopUpinDatabase):UserDAO{
        return topUpinDatabase.UserDao()
    }
    @Singleton
    @Provides
    fun provideProductDAO(topUpinDatabase: TopUpinDatabase):ProductDAO{
        return topUpinDatabase.ProductDao()
    }
}