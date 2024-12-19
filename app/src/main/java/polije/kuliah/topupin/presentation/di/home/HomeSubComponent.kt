package polije.kuliah.topupin.presentation.di.home

import dagger.Subcomponent
import polije.kuliah.topupin.presentation.di.user.UserScope
import polije.kuliah.topupin.presentation.user.RegisterActivity

@UserScope
@HomeScope
@Subcomponent(modules = [HomeModule::class])
interface HomeSubComponent {
    fun inject(mainActivity: RegisterActivity)
    @Subcomponent.Factory
    interface Factory {
        fun create(): HomeSubComponent
    }
}