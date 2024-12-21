package polije.kuliah.topupin.presentation.di.core

import dagger.Module
import dagger.Provides
import polije.kuliah.topupin.domain.repository.ProductRepository
import polije.kuliah.topupin.domain.repository.UserRepository
import polije.kuliah.topupin.domain.usecase.DeleteDatabaseUser
import polije.kuliah.topupin.domain.usecase.GetCategoryProductUseCase
import polije.kuliah.topupin.domain.usecase.GetProductUseCase
import polije.kuliah.topupin.domain.usecase.GetUserProfileUseCase
import polije.kuliah.topupin.domain.usecase.PostUserRegisterUseCase
import polije.kuliah.topupin.domain.usecase.SaveUserProfileUseCase
import polije.kuliah.topupin.domain.usecase.UpdateUserProfileUseCase


@Module
class UseCaseModule {

    @Provides
    fun provideGetUserProfileUseCase(userRepository: UserRepository) : GetUserProfileUseCase{
        return GetUserProfileUseCase(userRepository)
    }

    @Provides
    fun provideUpdateUserProfileUseCase(userRepository: UserRepository) : UpdateUserProfileUseCase{
        return UpdateUserProfileUseCase(userRepository)
    }

    @Provides
    fun provideGetCategoryProductUseCase(productRepository: ProductRepository): GetCategoryProductUseCase {
        return GetCategoryProductUseCase(productRepository)
    }

    @Provides
    fun provideGetProductUseCase(productRepository: ProductRepository): GetProductUseCase {
        return GetProductUseCase(productRepository)
    }

    @Provides
    fun provideDeleteUserDatabase(userRepository: UserRepository): DeleteDatabaseUser {
        return DeleteDatabaseUser(userRepository)
    }
    @Provides
    fun provideSaveUserUseCase(userRepository: UserRepository): SaveUserProfileUseCase {
        return SaveUserProfileUseCase(userRepository)
    }

    @Provides
    fun providePostRegisterUseCase(userRepository: UserRepository): PostUserRegisterUseCase {
        return PostUserRegisterUseCase(userRepository)
    }

}