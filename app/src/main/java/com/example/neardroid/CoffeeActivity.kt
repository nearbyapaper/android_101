package com.example.neardroid

import AppProgressLoading
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.internal.schedulers.IoScheduler
import javax.inject.Inject

@AndroidEntryPoint
class CoffeeActivity() : AppCompatActivity(), IAPILoading {
    private var rcView: RecyclerView? = null
    private lateinit var progressBar: ProgressBar
    private lateinit var appProgressLoading: AppProgressLoading

    @Inject
    lateinit var coffeeAPI: INetworkAPI

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coffee)

        rcView = findViewById(R.id.rcView)
        rcView?.layoutManager = LinearLayoutManager(this)

        val parentView = findViewById<FrameLayout>(R.id.parent_view)
        appProgressLoading = AppProgressLoading()
        progressBar = appProgressLoading.create(this)

        appProgressLoading.show(progressBar, parentView)

        Log.d("1995", "create appProgressLoading :: $appProgressLoading")
        loadingAPI(parentView)

        val responseAPI = coffeeAPI.getAllData()

        responseAPI.observeOn(AndroidSchedulers.mainThread()).subscribeOn(IoScheduler())
            .subscribe { it ->
                if (it?.isNotEmpty() == true) {
                    rcView?.adapter = CoffeeAdapter(it, this)
                }
                closeLoadingAPI()
            }
    }

    override fun loadingAPI(parentView: FrameLayout) {
        Log.d("1995", "loadingAPI")
        appProgressLoading.show(progressBar, parentView)
    }

    override fun closeLoadingAPI() {
        Log.d("1995", "closeLoadingAPI")
        appProgressLoading.hide(progressBar)
    }
}