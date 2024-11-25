package polije.kuliah.topupin.presentation.di.user

import dagger.BindsInstance
import dagger.Provides
import dagger.Subcomponent
import polije.kuliah.topupin.data.model.UserSend
import polije.kuliah.topupin.presentation.di.core.RemoteDataModule
import polije.kuliah.topupin.presentation.user.LoginActivity

@UserScope
@Subcomponent(modules = [UserModule::class])
interface UserSubComponent {

    fun inject(loginActivity: LoginActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): UserSubComponent
    }

}