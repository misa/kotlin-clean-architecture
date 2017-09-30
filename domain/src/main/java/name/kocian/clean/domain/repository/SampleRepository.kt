package name.kocian.clean.domain.repository

import io.reactivex.Observable

interface SampleRepository {

    fun getTest(): Observable<String>
}
