package polije.kuliah.topupin.presentation.di.user

import dagger.Subcomponent
import polije.kuliah.topupin.presentation.user.LoginActivity
import polije.kuliah.topupin.presentation.user.ProfileSettingActivity
import polije.kuliah.topupin.presentation.user.RegisterActivity
import polije.kuliah.topupin.presentation.user.home.MainActivity

@UserScope
@Subcomponent(modules = [UserModule::class])
interface UserSubComponent {

    fun inject(loginActivity: LoginActivity)
    fun inject(profileSettingActivity: ProfileSettingActivity)
    fun inject(mainActivity: MainActivity)
    fun inject(registerActivity: RegisterActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): UserSubComponent
    }

}