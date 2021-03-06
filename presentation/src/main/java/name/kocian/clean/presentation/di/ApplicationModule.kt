package name.kocian.clean.presentation.di

import android.content.Context
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import name.kocian.clean.device.network.NetworkManager
import name.kocian.clean.device.network.NetworkManagerImpl
import name.kocian.clean.domain.usecase.AbstractUseCase
import javax.inject.Named

@AppScope
@dagger.Module
class ApplicationModule(private val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

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

    @Provides
    fun provideNetworkManager(context: Context): NetworkManager {
        return NetworkManagerImpl(context)
    }
}
