package polije.kuliah.topupin.presentation.di.user

import dagger.Module
import dagger.Provides
import polije.kuliah.topupin.domain.usecase.DeleteDatabaseUser
import polije.kuliah.topupin.domain.usecase.GetCategoryProductUseCase
import polije.kuliah.topupin.domain.usecase.GetUserProfileUseCase
import polije.kuliah.topupin.domain.usecase.SaveUserProfileUseCase
import polije.kuliah.topupin.domain.usecase.UpdateUserProfileUseCase
import polije.kuliah.topupin.presentation.user.UserViewModelFactory

@Module
class UserModule {
    @UserScope
    @Provides
    fun provideUserViewModelFactory(
        getUserProfileUseCase: GetUserProfileUseCase,   
        updateUserProfileUseCase: UpdateUserProfileUseCase,
        getCategoryProductUseCase: GetCategoryProductUseCase,
        deleteDatabaseUser: DeleteDatabaseUser,
        saveUserProfileUseCase: SaveUserProfileUseCase
    ) : UserViewModelFactory{
        return UserViewModelFactory(getUserProfileUseCase, updateUserProfileUseCase,getCategoryProductUseCase,deleteDatabaseUser,saveUserProfileUseCase)
    }

}