package name.kocian.clean.datasource.repository

import io.reactivex.Observable
import name.kocian.clean.datasource.dto.TubeDto
import name.kocian.clean.datasource.service.SampleService
import name.kocian.clean.domain.repository.SampleRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class SampleRepositoryImplTest {
    private lateinit var repository: SampleRepository

    @Mock
    private lateinit var mockSampleService: SampleService

    @Before
    fun setUp() {
        repository = SampleRepositoryImpl(mockSampleService)
    }

    @Test
    fun getTestReturnsSampleText() {
        val tubeDto = TubeDto("test")
        val response = Collections.singletonList(tubeDto)

        `when`(mockSampleService.lineStatus).thenReturn(Observable.just(response))

        repository.getTest()
                .test()
                .assertValueCount(1)
                .assertValue(tubeDto.name)
                .assertNoErrors()
                .assertComplete()
    }
}
