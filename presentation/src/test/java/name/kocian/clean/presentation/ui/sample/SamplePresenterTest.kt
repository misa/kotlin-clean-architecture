package name.kocian.clean.presentation.ui.sample

import io.reactivex.Observable
import name.kocian.clean.domain.usecase.SampleUseCase
import org.junit.Before
import org.junit.Test
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

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        presenter = SamplePresenter(sampleUseCase)
        presenter.attachView(view)
    }

    @Test
    fun initPresenterShowsWelcomeText() {
        val text = "test"
        `when`(sampleUseCase.asObservable()).thenReturn(Observable.just(text))

        presenter.initPresenter()

        verify(view).showGreetings(text)
    }
}
