package com.example.neardroid.login.repository

import com.example.neardroid.api.WebserviceAPI
import com.example.neardroid.di_test.UserPreference
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val userPreference: UserPreference,
    private val apiService: WebserviceAPI
){
    fun testCallAPI() = apiService.test()
}