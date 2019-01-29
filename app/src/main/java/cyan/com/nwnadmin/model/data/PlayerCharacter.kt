package cyan.com.nwnadmin.model.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlayerCharacter(
    var uuid: Int?,
    var username: String?,
    var cdkey: String?,
    var name: String?,
    var hsexp: Int?,
    var exp: Int?
) : Parcelable