package cyan.com.nwnadmin.model

import cyan.com.nwnadmin.model.data.PlayerCharacter
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface AdminApi {
    @GET("character/all")
    fun getAll(): Single<List<PlayerCharacter>>

    @GET("character/cdkey/{cdkey}")
    fun getById(@Path("cdkey") cdkey: String): Single<List<PlayerCharacter>>

    @GET("character/username/{username}")
    fun getByUsername(@Path("username") username: String): Single<List<PlayerCharacter>>
}