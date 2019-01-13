package cyan.com.nwnadmin.adapter.character

interface CharacterPresenter {
    fun getCount(): Int
    fun displayCharacter(index: Int, view: CharacterView)
}