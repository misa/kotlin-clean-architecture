package name.kocian.clean.presentation.ui.sample

import io.reactivex.Observable
import name.kocian.clean.domain.usecase.SampleUseCase
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class SamplePresenterTest {
    private lateinit var presenter: SampleMvp.Presenter

    @Mock
    private lateinit var sampleUseCase: SampleUseCase

    @Mock
    private lateinit var view: SampleMvp.View

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        presenter = SamplePresenter(sampleUseCase)
        presenter.attachView(view)
    }

    @Test
    @DisplayName("initPresenter # shows welcome text")
    fun initPresenter() {
        val text = "test"
        `when`(sampleUseCase.asObservable()).thenReturn(Observable.just(text))

        presenter.initPresenter()

        verify(view).showGreetings(text)
    }
}
