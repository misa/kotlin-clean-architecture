package name.kocian.clean.datasource.service

import io.reactivex.Observable
import name.kocian.clean.datasource.dto.TubeDto
import retrofit2.http.GET

interface SampleService {

    @get:GET("/line/mode/tube/status")
    val lineStatus: Observable<List<TubeDto>>
}
