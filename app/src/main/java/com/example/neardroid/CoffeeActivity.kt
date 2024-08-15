package com.example.neardroid

import AppProgressLoading
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.neardroid.model.Coffee
import com.example.neardroid.testdi.UserPreference
import com.google.gson.GsonBuilder
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.internal.schedulers.IoScheduler
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Inject

class CoffeeActivity @Inject constructor(
    private val coffeeAPI: INetworkAPI,
    private val userPreference: UserPreference
) : AppCompatActivity(),IAPILoading {
    // var
    private var rcView: RecyclerView? = null
    private lateinit var progressBar: ProgressBar
    private lateinit var appProgressLoading: AppProgressLoading
    // end var
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coffee)

        rcView = findViewById(R.id.rcView)
        rcView?.layoutManager = LinearLayoutManager(this)

        val parentView = findViewById<FrameLayout>(R.id.parent_view)
        appProgressLoading = AppProgressLoading()
        progressBar = appProgressLoading.create(this)

        // Add the ProgressBar to the parent view
        appProgressLoading.show(progressBar, parentView)

        Log.d("1995","create appProgressLoading :: $appProgressLoading")
        loadingAPI(parentView)

        var baseURL = "https://antchatbot.firebaseio.com/"

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor(this)).
            build()

        // create retrofit [async]
        val retrofit = Retrofit.Builder().addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().create()
            )
        ).addCallAdapterFactory(RxJava3CallAdapterFactory.create()).baseUrl(baseURL)
            .client(httpClient)
            .build()

        val postCoffeeAPI = retrofit.create(INetworkAPI::class.java)
        val responseAPI = postCoffeeAPI.getAllData()

        responseAPI.observeOn(AndroidSchedulers.mainThread()).subscribeOn(IoScheduler())
            .subscribe { it ->
                if (it?.isNotEmpty() == true) {
                    rcView?.adapter = CoffeeAdapter(it, this)

                }
                closeLoadingAPI()
            }
    }

    override fun loadingAPI(parentView: FrameLayout ) {
        Log.d("1995","loadingAPI")
        appProgressLoading.show(progressBar, parentView)
    }

    override fun closeLoadingAPI() {
        Log.d("1995","closeLoadingAPI")
        appProgressLoading.hide(progressBar)
    }
}

