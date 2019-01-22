package cyan.com.nwnadmin.characters.details

import cyan.com.nwnadmin.model.data.PlayerCharacter

class CharacterDetailPresenterImpl(
    private var view: CharacterDetailView?,
    private val character: PlayerCharacter
) : CharacterDetailPresenter {
    override fun viewReady() {
        view?.onDisplayCharacter(character)
    }

    override fun destroy() {
        view = null
    }
}