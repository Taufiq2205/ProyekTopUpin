package polije.kuliah.topupin.presentation.di.core

import dagger.Module
import dagger.Provides
import polije.kuliah.topupin.data.db.ProductDAO
import polije.kuliah.topupin.data.db.UserDAO
import polije.kuliah.topupin.data.repository.datasource.product.ProductLocalDataSource
import polije.kuliah.topupin.data.repository.datasource.user.UserLocalDataSource
import polije.kuliah.topupin.data.repository.datasourceImpl.product.ProductLocalDataSourceImpl
import polije.kuliah.topupin.data.repository.datasourceImpl.user.UserLocalDataSourceImpl
import javax.inject.Singleton

@Module
class LocalDataModule() {
    @Singleton
    @Provides
    fun provideUserLocalDataSource(userDAO: UserDAO) : UserLocalDataSource {
        return UserLocalDataSourceImpl(userDAO)
    }
    @Singleton
    @Provides
    fun provideProductLocalDataSource(productDAO: ProductDAO):ProductLocalDataSource{
        return ProductLocalDataSourceImpl(productDAO)
    }
}