package com.example.neardroid.testdi.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp // for use Hilt + Dagger2
class AwesomeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Any other application-level setup can be done here
    }
}
