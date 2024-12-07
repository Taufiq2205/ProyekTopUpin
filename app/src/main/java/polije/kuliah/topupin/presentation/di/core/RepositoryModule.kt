package polije.kuliah.topupin.presentation.di.core

import dagger.Module
import dagger.Provides
import polije.kuliah.topupin.data.repository.ProductRepositoryImpl
import polije.kuliah.topupin.data.repository.UserRepositoryImpl
import polije.kuliah.topupin.data.repository.datasource.product.ProductLocalDataSource
import polije.kuliah.topupin.data.repository.datasource.product.ProductRemoteDataSource
import polije.kuliah.topupin.data.repository.datasource.user.UserLocalDataSource
import polije.kuliah.topupin.data.repository.datasource.user.UserRemoteDataSource
import polije.kuliah.topupin.domain.repository.ProductRepository
import polije.kuliah.topupin.domain.repository.UserRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideProfileRepository(
        userLocalDataSource: UserLocalDataSource,
        userRemoteDataSource: UserRemoteDataSource
    ) : UserRepository{
        return UserRepositoryImpl(userLocalDataSource,userRemoteDataSource)
    }

    @Singleton
    @Provides
    fun provideProductRepository(
        productLocalDataSource: ProductLocalDataSource,
        productRemoteDataSource: ProductRemoteDataSource
    ) : ProductRepository{
        return ProductRepositoryImpl(productLocalDataSource,productRemoteDataSource)
}
}