package com.example.neardroid.di_test

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp // for use Hilt + Dagger2
// Removed HasAndroidInjector: The HasAndroidInjector interface and its associated androidInjector() method are no longer needed with Hilt.
class AwesomeApplication : Application() {

//    @Inject
//    lateinit var mInjector: DispatchingAndroidInjector<Any>
//
//    override fun androidInjector(): AndroidInjector<Any> {
//        return mInjector
//    }

    override fun onCreate() {
        super.onCreate()
        // Add Dependency Injection from Dagger to Application
//        DaggerAppComponent.builder().appModule(AppModule()).build().inject(this)
    }
}

