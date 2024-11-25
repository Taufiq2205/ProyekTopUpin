package polije.kuliah.topupin.presentation.di.core

import dagger.Module
import dagger.Provides
import polije.kuliah.topupin.data.api.TopUpinService
import polije.kuliah.topupin.data.model.UserSend
import polije.kuliah.topupin.data.repository.datasource.UserRemoteDataSource
import polije.kuliah.topupin.data.repository.datasourceImpl.UserRemoteDataSourceImpl
import javax.inject.Singleton

@Module
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideUserRemoteDataSource(topUpinService: TopUpinService):UserRemoteDataSource{
        return UserRemoteDataSourceImpl(topUpinService)
    }
}