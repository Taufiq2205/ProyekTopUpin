package polije.kuliah.topupin.presentation.di.home

import dagger.Subcomponent
import polije.kuliah.topupin.presentation.di.user.UserScope
import polije.kuliah.topupin.presentation.di.user.UserSubComponent
import polije.kuliah.topupin.presentation.user.home.MainActivity
import polije.kuliah.topupin.presentation.user.LoginActivity

@UserScope
@HomeScope
@Subcomponent(modules = [HomeModule::class])
interface HomeSubComponent {
    fun inject(mainActivity: MainActivity)
    @Subcomponent.Factory
    interface Factory {
        fun create(): HomeSubComponent
    }
}