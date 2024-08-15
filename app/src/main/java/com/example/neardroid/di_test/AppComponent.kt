package com.example.neardroid.di_test

import com.example.neardroid.testdi.application.AwesomeApplication
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        LoginFragmentModule::class
    ]
)
interface AppComponent {
    fun inject(application: AwesomeApplication)
}