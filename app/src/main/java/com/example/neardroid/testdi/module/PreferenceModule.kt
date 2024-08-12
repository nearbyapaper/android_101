package com.example.neardroid.testdi.module

import com.example.neardroid.testdi.UserPreference
import com.example.neardroid.testdi.application.AwesomeApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Singleton

@Module
//@DisableInstallInCheck
class PreferenceModule {
    @Singleton
    @Provides
    fun provideUserPreference(application: AwesomeApplication) =
        UserPreference(application.applicationContext)
}