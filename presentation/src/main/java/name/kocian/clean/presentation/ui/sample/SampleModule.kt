package name.kocian.clean.presentation.ui.sample

import dagger.Provides
import name.kocian.clean.datasource.repository.SampleRepositoryImpl
import name.kocian.clean.domain.repository.SampleRepository
import name.kocian.clean.presentation.di.ActivityScope

@ActivityScope
@dagger.Module
class SampleModule {

    @Provides
    fun provideSampleRepository(): SampleRepository {
        return SampleRepositoryImpl()
    }
}
