package com.example.neardroid

//import io.reactivex.Single
import com.example.neardroid.model.Coffee
import com.example.neardroid.model.ListCoffeeResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface INetworkAPI {
    @GET("coffee.json")
    fun getAllData(): Single<List<Coffee>>
}
