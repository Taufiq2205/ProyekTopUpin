package polije.kuliah.topupin.presentation.di.home

import dagger.Module
import dagger.Provides
import polije.kuliah.topupin.domain.usecase.GetUserProfileUseCase
import polije.kuliah.topupin.presentation.user.UserViewModelFactory

@Module
class HomeModule {
    @HomeScope
    @Provides
    fun provideHomeViewModelFactory(
        getUserProfileUseCase: GetUserProfileUseCase
    ) : UserViewModelFactory {
        return UserViewModelFactory(getUserProfileUseCase)
    }
}