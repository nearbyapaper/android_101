package com.example.neardroid.di_test

import com.example.neardroid.INetworkAPI
import com.example.neardroid.api.WebserviceAPI
import com.example.neardroid.invest.fisginh_net.network.FishingNetAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "http://0.0.0.0:8080/" // Replace with your actual base URL

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // Add RxJava3 Call Adapter
            .build()
    }

    @Provides
    @Singleton
    fun provideLoginAPI(retrofit: Retrofit): WebserviceAPI {
        return retrofit.create(WebserviceAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideFishingNetAPI(retrofit: Retrofit): FishingNetAPI {
        return retrofit.create(FishingNetAPI::class.java)
    }

}