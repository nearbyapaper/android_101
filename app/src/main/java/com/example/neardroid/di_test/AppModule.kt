package com.example.neardroid.di_test

import android.content.Context
import com.example.neardroid.INetworkAPI
import com.example.neardroid.api.WebserviceAPI
import com.example.neardroid.login.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideUserPreference(@ApplicationContext context: Context): UserPreference {
        return UserPreference(context)
    }

    @Singleton
    @Provides
    fun provideLoginRepositoty(userPreference: UserPreference, apiService: WebserviceAPI): LoginRepository {
        return LoginRepository(userPreference, apiService)
    }
}
