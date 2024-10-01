package com.example.neardroid.login.model.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserLogin (
    var userName:String? = "",
    var password:String? = ""
): Parcelable