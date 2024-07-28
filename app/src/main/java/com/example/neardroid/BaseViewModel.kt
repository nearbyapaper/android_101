package com.example.neardroid

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.neardroid.model.StatusAPI

open class BaseViewModel: ViewModel() {
    val liveDataState = MutableLiveData<StatusAPI>()

    protected fun startLoading() {
        liveDataState.value = StatusAPI.LOADING
    }

    protected fun dismissLoading() {
        liveDataState.value = StatusAPI.DISMISS
    }

    override fun onCleared() {
        liveDataState.value = StatusAPI.DISMISS
    }
}