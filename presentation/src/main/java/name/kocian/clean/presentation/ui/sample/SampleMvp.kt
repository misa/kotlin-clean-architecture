package name.kocian.clean.presentation.ui.sample

import name.kocian.clean.presentation.mvp.MvpPresenter
import name.kocian.clean.presentation.mvp.MvpView

interface SampleMvp {

    interface View : MvpView {
        fun showGreetings(message: String)
    }

    interface Presenter : MvpPresenter<View> {
        fun initPresenter()
    }
}
