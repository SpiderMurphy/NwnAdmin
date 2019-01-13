package cyan.com.nwnadmin.di

import cyan.com.nwnadmin.characters.CharacterListFragment
import cyan.com.nwnadmin.characters.CharacterListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {
    @ContributesAndroidInjector(modules = [CharacterListModule::class])
    abstract fun bindCharacterListView(): CharacterListFragment
}