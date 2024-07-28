package com.example.neardroid.api

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class ErrorCollection(): Parcelable {
    @SerializedName("codeType")
    var codeType: String? = null

    @SerializedName("code")
    var statusCode: String? = null

    @SerializedName("desc")
    var description: String? = null

    @SerializedName("responseDateTime")
    var responseDateTime: String? = null

    @SerializedName("systemMessage")
    var systemMessage: String? = null

    var username: String? = null

    constructor(parcel: Parcel) : this() {
        codeType = parcel.readString()
        statusCode = parcel.readString()
        description = parcel.readString()
        responseDateTime = parcel.readString()
        systemMessage = parcel.readString()
        username = parcel.readString()
    }

    constructor(code: String, desc: String) : this() {
        statusCode = code
        description = desc
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(codeType)
        parcel.writeString(statusCode)
        parcel.writeString(description)
        parcel.writeString(responseDateTime)
        parcel.writeString(systemMessage)
        parcel.writeString(username)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ErrorCollection> {
        override fun createFromParcel(parcel: Parcel): ErrorCollection {
            return ErrorCollection(parcel)
        }

        override fun newArray(size: Int): Array<ErrorCollection?> {
            return arrayOfNulls(size)
        }
    }

}
