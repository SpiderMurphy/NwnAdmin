package cyan.com.nwnadmin.characters

import cyan.com.nwnadmin.model.data.PlayerCharacter

interface CharacterListView {
    fun onFetchCharacter(characters: List<PlayerCharacter>?)
    fun onClickCharacter(character: PlayerCharacter)
}