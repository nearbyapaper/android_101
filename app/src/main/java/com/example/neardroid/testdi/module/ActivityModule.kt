//package com.example.neardroid.testdi.module
//
//import com.example.neardroid.testdi.TestDagger2DIActivity
//import dagger.Module
//import dagger.android.ContributesAndroidInjector
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import dagger.hilt.migration.DisableInstallInCheck
//
//@Module
//@InstallIn(SingletonComponent::class)
//abstract class ActivityModule {
//    // add every Activity that can be Dependency
//    @ContributesAndroidInjector
//    abstract fun contributeTestDagger2DIActivity(): TestDagger2DIActivity
//}