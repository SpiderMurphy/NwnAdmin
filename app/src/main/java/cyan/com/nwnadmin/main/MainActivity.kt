package cyan.com.nwnadmin.main

import android.os.Bundle
import cyan.com.nwnadmin.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainView {
    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(appToolbar)
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }
}
