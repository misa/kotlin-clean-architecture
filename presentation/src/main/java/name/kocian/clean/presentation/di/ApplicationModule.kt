package name.kocian.clean.presentation.di

import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import name.kocian.clean.domain.usecase.AbstractUseCase
import javax.inject.Named

@AppScope
@dagger.Module
class ApplicationModule {

    @Provides
    @Named(AbstractUseCase.SCHEDULER_WORKER)
    fun provideSchedulerWorker(): Scheduler {
        return Schedulers.io()
    }

    @Provides
    @Named(AbstractUseCase.SCHEDULER_RESULT)
    fun provideSchedulerResult(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}
