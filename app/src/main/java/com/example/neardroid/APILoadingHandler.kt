package com.example.neardroid

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

abstract class APILoadingHandler : Fragment(), IAPILoading {
    private var progressBar: ProgressBar? = null
    private val _progressStatus = MutableLiveData<Int>()
    val progressStatus: LiveData<Int> get() = _progressStatus
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("APILoadingHandler", "onCreateView")
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_api_loading, container, false)
        // Attach the ProgressBar to the layout
        progressBar = view.findViewById(R.id.progressBar)
        Log.d("APILoadingHandler", "ProgressBar initialized in onCreateView: $progressBar")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("APILoadingHandler", "onViewCreated")
        Log.d("APILoadingHandler", "View ID: ${view.id}")
        Log.d("APILoadingHandler", "ProgressBar in onViewCreated: $progressBar")
    }

    private val updateProgressRunnable = object : Runnable {
        override fun run() {
            _progressStatus.value = (_progressStatus.value ?: 0) + 1
            handler.postDelayed(this, 100)
        }
    }

    override fun loadingAPI() {
        Log.d("APILoadingHandler", "loadingAPI called")
        progressBar?.visibility = View.VISIBLE
        Log.d("APILoadingHandler", "ProgressBar visibility: ${progressBar?.visibility}")
        _progressStatus.value = 0
        handler.post(updateProgressRunnable)
    }

    override fun closeLoadingAPI() {
        Log.d("APILoadingHandler", "closeLoadingAPI called")
        handler.removeCallbacks(updateProgressRunnable)
        progressBar?.visibility = View.INVISIBLE
        Log.d("APILoadingHandler", "ProgressBar visibility: ${progressBar?.visibility}")
    }

    override fun onDetach() {
        super.onDetach()
        handler.removeCallbacks(updateProgressRunnable)
    }
}
