package com.example.neardroid.mvvmretrofit.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

val BASE_URL = "https://newsapi.org/v2/"

interface NewsWebservice {
    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country: String ?= "th",
        @Query("apiKey") apiKey: String ?= "c914619ecb3245f7a1fc8d9ef7df409c"
    )

    companion object {
        operator fun invoke(): NewsWebservice {
            return Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(NewsWebservice::class.java)
        }
    }
}