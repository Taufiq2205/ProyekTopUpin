package polije.kuliah.topupin.presentation.di.user

import dagger.Module
import dagger.Provides
import polije.kuliah.topupin.data.model.UserSend
import polije.kuliah.topupin.domain.usecase.GetUserProfileUseCase
import polije.kuliah.topupin.presentation.user.UserViewModelFactory
import javax.inject.Singleton

@Module
class UserModule() {
    @UserScope
    @Provides
    fun provideUserViewModelFactory(
        getUserProfileUseCase: GetUserProfileUseCase) : UserViewModelFactory{
        return UserViewModelFactory(getUserProfileUseCase)
    }

}