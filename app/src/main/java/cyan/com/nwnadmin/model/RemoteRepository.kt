package cyan.com.nwnadmin.model

import cyan.com.nwnadmin.model.data.PlayerCharacter
import io.reactivex.Single

class RemoteRepository(
    private val apiService: AdminApi,
    private val executorService: ExecutorService
) : Repository {
    override fun fetchCharacterByUsername(username: String): Single<List<PlayerCharacter>> = apiService
        .getByUsername(username)
        .compose(executorService.singleThreadExecutor())

    override fun fetchCharacterAll(): Single<List<PlayerCharacter>> = apiService
        .getAll()
        .compose(executorService.singleThreadExecutor())

    override fun fetchCharacterByCdkey(cdkey: String): Single<List<PlayerCharacter>> = apiService
        .getById(cdkey)
        .compose(executorService.singleThreadExecutor())
}