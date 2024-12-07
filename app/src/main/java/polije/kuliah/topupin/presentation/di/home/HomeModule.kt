package polije.kuliah.topupin.presentation.di.home

import dagger.Module
import dagger.Provides
import polije.kuliah.topupin.domain.usecase.GetUserProfileUseCase
import polije.kuliah.topupin.domain.usecase.UpdateUserProfileUseCase
import polije.kuliah.topupin.presentation.di.user.UserScope
import polije.kuliah.topupin.presentation.user.UserViewModelFactory

@Module
class HomeModule {
    @HomeScope
    @Provides
    fun provideHomeViewModelFactory(
        getUserProfileUseCase: GetUserProfileUseCase,
        updateUserProfileUseCase: UpdateUserProfileUseCase

    ) : UserViewModelFactory {
        return UserViewModelFactory(getUserProfileUseCase, updateUserProfileUseCase)
    }
}