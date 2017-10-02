package name.kocian.clean.presentation.ui.sample

import name.kocian.clean.domain.usecase.SampleUseCase
import name.kocian.clean.presentation.mvp.BasePresenter

class SamplePresenter(private val sampleUseCase: SampleUseCase)
    : SampleMvp.Presenter, BasePresenter<SampleMvp.View>() {

    override fun initPresenter() {
        sampleUseCase.asObservable()
                .subscribe({ view?.showGreetings(it) })
    }
}
