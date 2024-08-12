package com.example.neardroid.testdi.application

import android.app.Application
import com.example.neardroid.testdi.injector.AppInjector

class AwesomeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // เดี๋ยวจะใส่คำสั่งของ Dagger 2 ไว้ที่นี่
        AppInjector.init(this)
    }
}