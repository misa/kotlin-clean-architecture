package name.kocian.clean.presentation.mvp

interface MvpPresenter<in T> {
    fun attachView(view: T)

    fun detachView()
}

open class BasePresenter<T> : MvpPresenter<T> {
    var view: T? = null

    override fun attachView(view: T) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }
}
