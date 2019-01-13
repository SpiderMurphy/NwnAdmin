package cyan.com.nwnadmin.adapter.character

import cyan.com.nwnadmin.model.data.PlayerCharacter

interface CharacterView {
    fun bindCharacter(character: PlayerCharacter)
}