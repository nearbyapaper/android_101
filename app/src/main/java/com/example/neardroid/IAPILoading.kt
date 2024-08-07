package com.example.neardroid

import android.widget.FrameLayout

interface IAPILoading {
    fun closeLoadingAPI()
    fun loadingAPI(parentView: FrameLayout)
}