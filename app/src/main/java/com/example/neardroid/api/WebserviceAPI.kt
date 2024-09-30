package com.example.neardroid.api

import com.example.neardroid.login.model.request.LoginRequest
import com.example.neardroid.login.model.response.LoginResponse
import com.example.neardroid.model.TestAPIResponse
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface WebserviceAPI {
    @POST("/user/login")
    fun login(@Body request: LoginRequest): Observable<LoginResponse>

    @GET("https://mocki.io/v1/dfa60445-9ad6-421c-b03b-9fccc1573f69")
    fun test(): Single<TestAPIResponse>
}