package cyan.com.nwnadmin.di

import android.app.Application
import cyan.com.nwnadmin.NwnAdmin
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    RepositoryModule::class,
    ActivityBuilder::class
])
@Singleton
interface ApplicationComponent : AndroidInjector<NwnAdmin> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }

    override fun inject(app: NwnAdmin)
}