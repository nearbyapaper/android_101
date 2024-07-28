package com.example.neardroid.login.model.request

import com.google.gson.annotations.SerializedName

data class LoginRequest(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("userName")
	val userName: String? = null
)
