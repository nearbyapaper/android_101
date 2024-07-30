package com.example.neardroid.model

import android.os.Parcel
import android.os.Parcelable

data class SetValue(
    val name: String?= "",
    val value: String?= ""
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(value)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SetValue> {
        override fun createFromParcel(parcel: Parcel): SetValue {
            return SetValue(parcel)
        }

        override fun newArray(size: Int): Array<SetValue?> {
            return arrayOfNulls(size)
        }
    }
}
