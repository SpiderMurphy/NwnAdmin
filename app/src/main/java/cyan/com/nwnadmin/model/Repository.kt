package cyan.com.nwnadmin.model

import cyan.com.nwnadmin.model.data.PlayerCharacter
import io.reactivex.Single

interface Repository {
    fun fetchCharacterAll(): Single<List<PlayerCharacter>>
    fun fetchCharacterByCdkey(cdkey: String): Single<List<PlayerCharacter>>
    fun fetchCharacterByUsername(username: String): Single<List<PlayerCharacter>>
}