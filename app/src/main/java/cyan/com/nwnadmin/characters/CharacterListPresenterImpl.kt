package cyan.com.nwnadmin.characters

import android.util.Log
import cyan.com.nwnadmin.model.Repository
import io.reactivex.disposables.CompositeDisposable

class CharacterListPresenterImpl(
    private var view: CharacterListView?,
    private val model: Repository
) : CharacterListPresenter {
    private val disposable = CompositeDisposable()

    override fun viewReady() {
        fetchCharacters()
    }

    override fun fetchCharacters() {
        disposable.add(
            model.fetchCharacterAll().let {
                it.subscribe({ characters -> view?.onFetchCharacter(characters) },
                    { error -> Log.w("Characters error", error.localizedMessage) })
            }
        )
    }

    override fun fetchCharactersByCdKey(cdkey: String?) {
        disposable.add(
            model.fetchCharacterByCdkey(cdkey = cdkey.orEmpty())
                .subscribe({ characters -> view?.onFetchCharacter(characters = characters) },
                    { error -> Log.w("Characters error", error.localizedMessage) })
        )
    }

    override fun fetchCharactersByUsername(username: String?) {
        disposable.add(
            model.fetchCharacterByUsername(username = username.orEmpty())
                .subscribe({ characters -> view?.onFetchCharacter(characters = characters) },
                    { error -> Log.w("Characters error", error.localizedMessage) })
        )
    }

    override fun destroy() {
        disposable.dispose()
        view = null
    }
}