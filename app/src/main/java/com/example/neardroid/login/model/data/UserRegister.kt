package com.example.neardroid.login.model.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserRegister(
    val name: String,
    val email: String,
    val password: String,
    val passwordConfirmation: String
): Parcelable
