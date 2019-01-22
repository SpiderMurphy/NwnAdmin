package cyan.com.nwnadmin.model.data

import android.os.Parcel
import android.os.Parcelable

data class PlayerCharacter(
    var uuid: Int?,
    var username: String?,
    var cdkey: String?,
    var name: String?,
    var hsexp: Int?,
    var exp: Int?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {}

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(uuid)
        parcel.writeString(username)
        parcel.writeString(cdkey)
        parcel.writeString(name)
        parcel.writeValue(hsexp)
        parcel.writeValue(exp)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlayerCharacter> {
        override fun createFromParcel(parcel: Parcel): PlayerCharacter {
            return PlayerCharacter(parcel)
        }

        override fun newArray(size: Int): Array<PlayerCharacter?> {
            return arrayOfNulls(size)
        }
    }
}