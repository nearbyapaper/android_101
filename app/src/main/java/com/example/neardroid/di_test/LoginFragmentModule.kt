package com.example.neardroid.di_test

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
class LoginFragmentModule {
    // You don't need any methods here for simple fragment injection with Hilt
}