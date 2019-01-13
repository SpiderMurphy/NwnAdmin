package cyan.com.nwnadmin.characters

import cyan.com.nwnadmin.mvp.BasePresenter

interface CharacterListPresenter : BasePresenter {
    fun fetchCharacters()
    fun fetchCharactersByUsername(username: String?)
    fun fetchCharactersByCdKey(cdkey: String?)
}