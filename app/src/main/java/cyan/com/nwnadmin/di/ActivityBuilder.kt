package cyan.com.nwnadmin.di

import cyan.com.nwnadmin.main.MainActivity
import cyan.com.nwnadmin.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [
        FragmentBuilder::class,
        MainModule::class
    ])
    abstract fun bindMainView(): MainActivity
}