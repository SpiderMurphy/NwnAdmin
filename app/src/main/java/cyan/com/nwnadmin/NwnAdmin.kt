package cyan.com.nwnadmin

import cyan.com.nwnadmin.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class NwnAdmin : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out NwnAdmin> {
        return DaggerApplicationComponent.builder().application(this).build()
    }
}