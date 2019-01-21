package cyan.com.nwnadmin.adapter.character

import cyan.com.nwnadmin.characters.CharacterListView
import cyan.com.nwnadmin.model.data.PlayerCharacter

class CharacterPresenterImpl(
    private var view: CharacterListView?,
    private val model: List<PlayerCharacter>
) : CharacterPresenter {
    override fun destroy() {
        view = null
    }

    override fun displayCharacter(index: Int, view: CharacterView) {
        view.bindCharacter(model[index])
        view.setOnCharacterClickListener(index)
    }

    override fun clickCharacter(position: Int) {
        view?.onClickCharacter(model[position])
    }

    override fun getCount(): Int = model.size
}