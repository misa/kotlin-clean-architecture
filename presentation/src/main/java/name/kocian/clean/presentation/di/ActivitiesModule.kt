package name.kocian.clean.presentation.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import name.kocian.clean.presentation.ui.sample.MainActivity
import name.kocian.clean.presentation.ui.sample.SampleModule

@Module
@ActivityScope
@Suppress("unused")
abstract class ActivitiesModule {

    @ContributesAndroidInjector(modules = arrayOf(
            SampleModule::class
    ))
    abstract fun provideMainActivityInjector(): MainActivity
}
