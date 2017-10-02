package name.kocian.clean.domain.usecase

import io.reactivex.Observable

interface UseCase<T> {
    fun asObservable(): Observable<T>
}
