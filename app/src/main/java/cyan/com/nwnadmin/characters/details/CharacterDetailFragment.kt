package cyan.com.nwnadmin.characters.details

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Menu
import android.view.MenuInflater
import cyan.com.nwnadmin.R
import cyan.com.nwnadmin.databinding.FragmentCharacterDetailsBinding
import cyan.com.nwnadmin.model.data.PlayerCharacter

class CharacterDetailFragment : Fragment(), CharacterDetailView {
    private lateinit var presenter: CharacterDetailPresenter
    private lateinit var binder: FragmentCharacterDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_character_details, container, false)
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            presenter = CharacterDetailPresenterImpl(this, CharacterDetailFragmentArgs.fromBundle(it).character)
            presenter.viewReady()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_character_details, menu)
    }

    override fun onDisplayCharacter(character: PlayerCharacter) {
        binder.character = character
    }
}