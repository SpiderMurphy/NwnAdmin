package cyan.com.nwnadmin.characters

import cyan.com.nwnadmin.model.Repository
import dagger.Module
import dagger.Provides

@Module
class CharacterListModule {
    @Provides
    fun provideView(view: CharacterListFragment): CharacterListView = view

    @Provides
    fun providePresenter(view: CharacterListView, model: Repository): CharacterListPresenter = CharacterListPresenterImpl(view, model)
}