package cyan.com.nwnadmin.characters.details

import cyan.com.nwnadmin.model.data.PlayerCharacter

interface CharacterDetailView {
    fun onDisplayCharacter(character: PlayerCharacter)
}