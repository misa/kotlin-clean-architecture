package name.kocian.clean.datasource.repository

import io.reactivex.Observable
import name.kocian.clean.domain.repository.SampleRepository
import javax.inject.Inject

class SampleRepositoryImpl @Inject constructor() : SampleRepository {

    override fun getTest(): Observable<String> {
        return Observable.just("test")
    }
}
