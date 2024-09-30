package com.example.neardroid.invest.fisginh_net.network

import com.example.neardroid.invest.fisginh_net.model.FishingNetBusiness
import com.example.neardroid.invest.fisginh_net.model.response.FocusBusinessListResponse
import com.example.neardroid.model.TestAPIResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FishingNetAPI {
    @GET("v1/dfa60445-9ad6-421c-b03b-9fccc1573f69")
    fun testFishingAPI(): Single<TestAPIResponse>

    @POST("saveBusiness")
    fun saveFocusBusiness(@Body request: FishingNetBusiness): Single<FishingNetBusiness>

    @GET("allFocusBusiness")
    fun getAllFocusBusiness(): Single<FocusBusinessListResponse>

    @DELETE("removeBusiness/{businessName}")
    fun removeBusiness(@Path("businessName") businessName: String): Single<FishingNetBusiness>

}