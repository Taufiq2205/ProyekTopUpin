package polije.kuliah.topupin.presentation.di.core

import dagger.Module
import dagger.Provides
import polije.kuliah.topupin.domain.repository.ProductRepository
import polije.kuliah.topupin.domain.repository.UserRepository
import polije.kuliah.topupin.domain.usecase.GetProductUseCase
import polije.kuliah.topupin.domain.usecase.GetUserProfileUseCase
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
    fun provideGetProductUseCase(productRepository: ProductRepository):GetProductUseCase{
        return GetProductUseCase(productRepository)
    }
}