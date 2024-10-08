package com.example.neardroid.model

import android.os.Parcel
import android.os.Parcelable

data class AlarmMessage(
    val title:String ?= "",
    val content:String ?= "",
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(content)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AlarmMessage> {
        override fun createFromParcel(parcel: Parcel): AlarmMessage {
            return AlarmMessage(parcel)
        }

        override fun newArray(size: Int): Array<AlarmMessage?> {
            return arrayOfNulls(size)
        }
    }
}
