package com.example.neardroid.di_test

import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        LoginFragmentModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {
    fun inject(application: AwesomeApplication)
}