package com.example.neardroid.testdi.component

import android.app.Application
import com.example.neardroid.testdi.application.AwesomeApplication
//import com.example.neardroid.testdi.module.ActivityModule
import com.example.neardroid.testdi.module.PreferenceModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class, // init module
        PreferenceModule::class,  // manual add module
//        ActivityModule::class // manual add module
    ])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(awesomeApplication: AwesomeApplication)
}