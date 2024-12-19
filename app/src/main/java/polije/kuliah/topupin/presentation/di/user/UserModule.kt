package polije.kuliah.topupin.presentation.di.user

import dagger.Module
import dagger.Provides
import polije.kuliah.topupin.domain.usecase.GetUserProfileUseCase
import polije.kuliah.topupin.domain.usecase.PostUserRegisterUseCase
import polije.kuliah.topupin.domain.usecase.UpdateUserProfileUseCase
import polije.kuliah.topupin.presentation.user.UserViewModelFactory

@Module
class UserModule {
    @UserScope
    @Provides
    fun provideUserViewModelFactory(
        getUserProfileUseCase: GetUserProfileUseCase,
        updateUserProfileUseCase: UpdateUserProfileUseCase,
        postUserRegisterUseCase: PostUserRegisterUseCase
    ) : UserViewModelFactory{
        return UserViewModelFactory(getUserProfileUseCase, updateUserProfileUseCase, postUserRegisterUseCase)
    }

}