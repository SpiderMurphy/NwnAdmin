package cyan.com.nwnadmin.main

import cyan.com.nwnadmin.model.Repository
import dagger.Module
import dagger.Provides

@Module
class MainModule {
    @Provides
    fun provideMainView(view: MainActivity): MainView = view

    @Provides
    fun provideMainPresenter(view: MainView, model: Repository): MainPresenter = MainPresenterImpl(view, model)
}