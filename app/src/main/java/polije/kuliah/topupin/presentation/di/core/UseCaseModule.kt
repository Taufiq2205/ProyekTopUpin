package polije.kuliah.topupin.presentation.di.core

import dagger.Module
import dagger.Provides
import polije.kuliah.topupin.domain.repository.ProfileRepository
import polije.kuliah.topupin.domain.usecase.GetUserProfileUseCase


@Module
class UseCaseModule {

    @Provides
    fun provideGetUserProfileUseCase(profileRepository: ProfileRepository) : GetUserProfileUseCase{
        return GetUserProfileUseCase(profileRepository)
    }
}