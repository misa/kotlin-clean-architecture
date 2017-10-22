package name.kocian.clean.datasource.repository

import io.reactivex.Observable
import name.kocian.clean.datasource.service.SampleService
import name.kocian.clean.domain.repository.SampleRepository
import javax.inject.Inject

class SampleRepositoryImpl @Inject constructor(
        private val sampleService: SampleService) : SampleRepository {

    override fun getTest(): Observable<String> {
        return sampleService.lineStatus
                .map { t -> t.joinToString(separator = "\n") { it.name } }
    }
}
