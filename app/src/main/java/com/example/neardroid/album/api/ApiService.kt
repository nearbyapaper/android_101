package com.example.neardroid.album.api

import com.example.neardroid.album.model.AlbumResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

val BASE_URL = "https://jsonplaceholder.typicode.com/"

interface ApiService {
    @GET("albums")
    fun getAlbums(): Call<List<AlbumResponse>>

    @GET("albums/{no}")
    // Annotation Path will get by position of list
    fun getAlbum(@Path("no") no:Int): Call<AlbumResponse>

    @GET("albums/")
    // Annotation Query will query by params name @Query
    fun getAlbumsByUserID(@Query("userId") userId:Int): Call<List<AlbumResponse>>

    @GET("albums/")
    // Use @QueryMap with Hashmap for more on params in query
    fun getAlbumsByHashmap(@QueryMap map : HashMap<String,String>): Call<List<AlbumResponse>>

    companion object {
        operator fun invoke(): ApiService {
            return Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build().create(ApiService::class.java)
        }
    }
}