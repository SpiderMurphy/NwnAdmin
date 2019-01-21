package cyan.com.nwnadmin.characters.details

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import cyan.com.nwnadmin.R
import cyan.com.nwnadmin.model.data.PlayerCharacter

class CharacterDetailFragment : Fragment(), CharacterDetailView {
    lateinit var presenter: CharacterDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedInstanceState?.let {
            presenter = CharacterDetailPresenterImpl(this, CharacterDetailFragmentArgs.fromBundle(it).character)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_character_details, menu)
    }

    override fun onDisplayCharacter(character: PlayerCharacter) {

    }
}