package name.kocian.clean.device.network

import io.reactivex.Observable

interface NetworkManager {

    fun isConnectionEstablished(): Boolean

    fun networkChangesObservable(): Observable<Boolean>
}
