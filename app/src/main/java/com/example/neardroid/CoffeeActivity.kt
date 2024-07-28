package com.example.neardroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.neardroid.model.Coffee
import com.google.gson.GsonBuilder
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.internal.schedulers.IoScheduler
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class CoffeeActivity : AppCompatActivity() {
    // var
    var rcView: RecyclerView? = null

    // end var
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coffee)

        rcView = findViewById(R.id.rcView)
        rcView?.layoutManager = LinearLayoutManager(this)

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
            }
    }
}

