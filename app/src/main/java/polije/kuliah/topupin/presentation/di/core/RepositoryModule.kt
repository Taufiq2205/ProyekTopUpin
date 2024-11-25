package polije.kuliah.topupin.presentation.di.core

import dagger.Module
import dagger.Provides
import polije.kuliah.topupin.data.repository.ProfileRepositoryImpl
import polije.kuliah.topupin.data.repository.datasource.UserLocalDataSource
import polije.kuliah.topupin.data.repository.datasource.UserRemoteDataSource
import polije.kuliah.topupin.domain.repository.ProfileRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideProfileRepository(
      userLocalDataSource: UserLocalDataSource,
      userRemoteDataSource: UserRemoteDataSource
    ) : ProfileRepository{
        return ProfileRepositoryImpl(userLocalDataSource,userRemoteDataSource)
    }
}