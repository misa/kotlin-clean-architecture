package name.kocian.clean.domain.usecase

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import name.kocian.clean.domain.repository.SampleRepository
import org.junit.Rule
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

class SampleUseCaseTest {

    @Rule
    val rule: MockitoRule = MockitoJUnit.rule()

    private lateinit var sampleUseCase: SampleUseCase

    @Mock
    private lateinit var sampleRepository: SampleRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        sampleUseCase = SampleUseCase(
                sampleRepository,
                Schedulers.trampoline(),
                Schedulers.trampoline()
        )
    }

    @Test
    @DisplayName("asObservable # returns a result")
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
