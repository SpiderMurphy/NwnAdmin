package cyan.com.nwnadmin.characters

import android.os.Bundle
import android.support.v7.widget.SearchView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import cyan.com.nwnadmin.R
import cyan.com.nwnadmin.adapter.character.AdapterCharacter
import cyan.com.nwnadmin.adapter.character.CharacterPresenterImpl
import cyan.com.nwnadmin.model.data.PlayerCharacter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_characters_list.*
import javax.inject.Inject

class CharacterListFragment : DaggerFragment(), CharacterListView {
    @Inject
    lateinit var presenter: CharacterListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_characters, menu)
        setMenuOptions(menu)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_characters_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.viewReady()
    }

    override fun onFetchCharacter(characters: List<PlayerCharacter>?) {
        characters?.let {
            val adapter = AdapterCharacter(CharacterPresenterImpl(it))
            rwCharacters.adapter = adapter
        }
    }

    private fun setMenuOptions(menu: Menu?) {
        menu?.let {
            (it.findItem(R.id.acionSearch).actionView as SearchView)
                .setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        presenter.fetchCharactersByUsername(query)
                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean = true
                })
        }
    }
}