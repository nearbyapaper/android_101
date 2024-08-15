package com.example.neardroid.di_test

import com.example.neardroid.INetworkAPI
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

    private const val BASE_URL = "https://antchatbot.firebaseio.com/" // Replace with your actual base URL

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
    fun provideCoffeeAPI(retrofit: Retrofit): INetworkAPI {
        return retrofit.create(INetworkAPI::class.java)
    }
}