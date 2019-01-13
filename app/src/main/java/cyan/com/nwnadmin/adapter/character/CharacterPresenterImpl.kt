package cyan.com.nwnadmin.adapter.character

import cyan.com.nwnadmin.model.data.PlayerCharacter

class CharacterPresenterImpl(
    private val model: List<PlayerCharacter>
) : CharacterPresenter {
    override fun displayCharacter(index: Int, view: CharacterView) {
        view.bindCharacter(model[index])
    }

    override fun getCount(): Int = model.size
}