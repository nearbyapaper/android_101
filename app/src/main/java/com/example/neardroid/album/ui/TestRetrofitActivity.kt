package com.example.neardroid.album.ui

import android.os.Bundle
import android.util.Log
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import com.example.neardroid.R
import com.example.neardroid.album.api.ApiService
import com.example.neardroid.album.model.AlbumResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TestRetrofitActivity : AppCompatActivity() {
    var resText: TextView? = null
    var resFixText: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_retrofit)

        // bind widget
        resText = findViewById(R.id.responseTextView)
        resFixText = findViewById(R.id.responseFixPosTextView)

        getAlbumList()

        getAlbum(3)

        getAlbummByUserId(2)

        getAlbumsUseQueryMap(23.toString(), 3.toString())
    }

    private fun getAlbumsUseQueryMap(id: String, userId: String) {
        val apiService = ApiService()
        val hashMap = hashMapOf<String,String>()
        hashMap.put("id",id)
        hashMap.put("userId",userId)

        val callGetAlbumsByUserId = apiService.getAlbumsByHashmap(hashMap)

        callGetAlbumsByUserId.enqueue(object : Callback<List<AlbumResponse>>
        {
            override fun onResponse(
                call: Call<List<AlbumResponse>>,
                response: Response<List<AlbumResponse>>
            ) {
                if(response.isSuccessful){
                    val list = response.body()
                    Log.d("1995","getAlbumsUseQueryMap Success :: $list")
                    if (list != null) {
                        resText?.text  = ""
                        for (i in 0 until list.size){
                            val msg = "title : ${list[i].titleName}\n"
                            resText?.append(msg)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<AlbumResponse>>, t: Throwable) {
                Log.d("1995", "error :: ${t.message}")
            }

        })
    }

    private fun getAlbummByUserId(i: Int) {
        val apiService = ApiService()
        val callGetAlbumsByUserId = apiService.getAlbumsByUserID(i)

        callGetAlbumsByUserId.enqueue(object : Callback<List<AlbumResponse>>
        {
            override fun onResponse(
                call: Call<List<AlbumResponse>>,
                response: Response<List<AlbumResponse>>
            ) {
                if(response.isSuccessful){
                    val list = response.body()
                    Log.d("1995","getAlbummByUserId Success :: $list")
                    if (list != null) {
                        for (i in 0 until list.size){
                            val msg = "title : ${list[i].titleName}\n"
                            resText?.append(msg)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<AlbumResponse>>, t: Throwable) {
                Log.d("1995", "error :: ${t.message}")
            }

        })
    }

    private fun getAlbum(no: Int) {
        val apiService =
            ApiService() // call invoke method on companion onject so not neccessary call  method on ApiService
        val callGetAlbum = apiService.getAlbum(no)

        callGetAlbum.enqueue(object : Callback<AlbumResponse> {
            override fun onResponse(call: Call<AlbumResponse>, response: Response<AlbumResponse>) {
                if(response.isSuccessful){
                    val data = response.body()
                    if (data != null) {
                        resFixText?.text = data.titleName
                    }
                }
            }

            override fun onFailure(call: Call<AlbumResponse>, t: Throwable) {
                Log.d("1995", "error :: ${t.message}")
            }
        }
        )
    }

    private fun getAlbumList() {
        // call API
        val apiService = ApiService()
        val callGetAlbums = apiService.getAlbums()

        // check res API
        callGetAlbums.enqueue(object : Callback<List<AlbumResponse>> {
            override fun onResponse(
                call: Call<List<AlbumResponse>>,
                response: Response<List<AlbumResponse>>
            ) {
                if (response.isSuccessful) {
                    val list = response.body()
                    if (list != null) {
                        Log.d("1995", "onResponse :: ${list.size}")
                        for (i in 0 until list.size) {
                            val msg =
                                "id: ${list[i].id} ,userId: ${list[i].userId}. title : ${list[i].titleName}\n"
                            resText?.append(msg)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<AlbumResponse>>, t: Throwable) {
                Log.d("1995", "onFailure :: ${t.message}")
            }

        })
    }


}