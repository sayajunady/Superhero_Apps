package com.junadhi.superheroapps

import android.os.Parcel
import android.os.Parcelable

data class Superhero(val imageSrc: Int, val imageTitle: String?, val imageDesc: String?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    )


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageSrc)
        parcel.writeString(imageTitle)
        parcel.writeString(imageDesc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Superhero> {
        override fun createFromParcel(parcel: Parcel): Superhero {
            return Superhero(parcel)
        }

        override fun newArray(size: Int): Array<Superhero?> {
            return arrayOfNulls(size)
        }
    }
}

