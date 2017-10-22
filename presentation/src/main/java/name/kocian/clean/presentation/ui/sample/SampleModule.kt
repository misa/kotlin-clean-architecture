package name.kocian.clean.presentation.ui.sample

import dagger.Provides
import name.kocian.clean.datasource.repository.SampleRepositoryImpl
import name.kocian.clean.datasource.service.SampleService
import name.kocian.clean.device.network.NetworkManager
import name.kocian.clean.domain.repository.SampleRepository
import name.kocian.clean.domain.usecase.SampleUseCase
import name.kocian.clean.presentation.di.ActivityScope

@ActivityScope
@dagger.Module
class SampleModule {

    @Provides
    fun provideSampleRepository(sampleService: SampleService): SampleRepository {
        return SampleRepositoryImpl(sampleService)
    }

    @Provides
    fun provideSamplePresenter(sampleUseCase: SampleUseCase, networkManager: NetworkManager): SampleMvp.Presenter {
        return SamplePresenter(sampleUseCase, networkManager)
    }
}
