package name.kocian.clean.presentation.ui.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import name.kocian.clean.R
import name.kocian.clean.domain.usecase.SampleUseCase
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var sampleUseCase: SampleUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        sampleUseCase.asObservable()
                .subscribe({ welcome.text = it })
    }
}
