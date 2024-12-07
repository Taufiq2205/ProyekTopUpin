package polije.kuliah.topupin.presentation.di.core

import dagger.Module
import dagger.Provides
import polije.kuliah.topupin.data.api.TopUpinService
import polije.kuliah.topupin.data.repository.datasource.product.ProductRemoteDataSource
import polije.kuliah.topupin.data.repository.datasource.user.UserRemoteDataSource
import polije.kuliah.topupin.data.repository.datasourceImpl.product.ProductRemoteDataSourceImpl
import polije.kuliah.topupin.data.repository.datasourceImpl.user.UserRemoteDataSourceImpl
import javax.inject.Singleton

@Module
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideUserRemoteDataSource(topUpinService: TopUpinService): UserRemoteDataSource {
        return UserRemoteDataSourceImpl(topUpinService)
    }
    @Singleton
    @Provides
    fun productRemoteDataSource(topUpinService: TopUpinService):ProductRemoteDataSource{
        return ProductRemoteDataSourceImpl(topUpinService)
    }
}