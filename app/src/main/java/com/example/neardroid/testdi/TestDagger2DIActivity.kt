package com.example.neardroid.testdi

import android.os.Bundle
import android.util.Log
import com.example.neardroid.R
import com.example.neardroid.basecomp.BaseActivity
import dagger.android.DispatchingAndroidInjector
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Inject

class TestDagger2DIActivity : BaseActivity() {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var  userPreference: UserPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_dagger2_diactivity)

        Log.d("1995","androidInjector :: $androidInjector")
        Log.d("1995","userPreference :: $userPreference")
    }
}