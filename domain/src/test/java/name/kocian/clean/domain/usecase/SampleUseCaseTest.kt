package name.kocian.clean.domain.usecase

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import name.kocian.clean.domain.repository.SampleRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

class SampleUseCaseTest {

    @get:Rule
    @Suppress("unused")
    val rule: MockitoRule = MockitoJUnit.rule()

    private lateinit var sampleUseCase: SampleUseCase

    @Mock
    private lateinit var sampleRepository: SampleRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        sampleUseCase = SampleUseCase(
                sampleRepository,
                Schedulers.trampoline(),
                Schedulers.trampoline()
        )
    }

    @Test
    fun testBuildObservable() {
        val result = "test"
        `when`(sampleRepository.getTest()).thenReturn(Observable.just(result))

        sampleUseCase.asObservable()
                .test()
                .assertValueCount(1)
                .assertValue(result)
                .assertNoErrors()
                .assertComplete()
    }
}
