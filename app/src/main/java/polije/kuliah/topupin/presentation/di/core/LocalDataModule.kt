package polije.kuliah.topupin.presentation.di.core

import dagger.Module
import dagger.Provides
import polije.kuliah.topupin.data.db.UserDAO
import polije.kuliah.topupin.data.repository.datasource.UserLocalDataSource
import polije.kuliah.topupin.data.repository.datasourceImpl.UserLocalDataSourceImpl
import javax.inject.Singleton

@Module
class LocalDataModule() {
    @Singleton
    @Provides
    fun provideUserLocalDataSource(userDAO: UserDAO) : UserLocalDataSource{
        return UserLocalDataSourceImpl(userDAO)
    }
}