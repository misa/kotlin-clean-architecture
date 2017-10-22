package name.kocian.clean.presentation.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import io.reactivex.Scheduler
import name.kocian.clean.datasource.di.NetworkModule
import name.kocian.clean.domain.usecase.AbstractUseCase
import name.kocian.clean.presentation.CleanApplication
import javax.inject.Named

@AppScope
@Component(modules = arrayOf(
        ApplicationModule::class,
        AndroidInjectionModule::class,
        ActivitiesModule::class,
        NetworkModule::class
))
interface ApplicationComponent {

    fun inject(app: CleanApplication)

    @Named(AbstractUseCase.SCHEDULER_WORKER)
    fun getWorkerScheduler(): Scheduler

    @Named(AbstractUseCase.SCHEDULER_RESULT)
    fun getResultScheduler(): Scheduler
}
