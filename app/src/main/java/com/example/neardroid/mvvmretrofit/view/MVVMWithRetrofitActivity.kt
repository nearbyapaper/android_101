package com.example.neardroid.mvvmretrofit.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.neardroid.R
import dagger.hilt.android.AndroidEntryPoint

class MVVMWithRetrofitActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var mainFrameLayout: FrameLayout
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvmwith_retrofit)

//        mainFrameLayout = findViewById(R.id.simple_retrofit_frame)
//        progressBar = AppProgressLoading().create(this)
    }
}