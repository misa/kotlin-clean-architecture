package name.kocian.clean.presentation.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import name.kocian.clean.presentation.CleanApplication

@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        ActivitiesModule::class
))
interface ApplicationComponent {

    fun inject(app: CleanApplication)
}
