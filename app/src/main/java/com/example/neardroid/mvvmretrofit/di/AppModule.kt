package com.example.neardroid.mvvmretrofit.di

import com.example.neardroid.mvvmretrofit.api.NewsWebservice
import com.example.neardroid.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(ActivityComponent::class)
object AppModule {
    // scope for ActivityComponent
    @ActivityScoped
    // Create Components that can use for inject
    @Provides
    // make NewsWebservice can inject
    fun provideNewsApiService(): NewsWebservice {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constant.NEWS_API_URL).build().create()
    }
}