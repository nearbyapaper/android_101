package com.example.neardroid.util

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    val liveDataState = MutableLiveData<StatusResource?>()

    protected fun startLoading() {
        liveDataState.value = StatusResource.LOADING
    }

    protected fun dismissLoading() {
        liveDataState.value = StatusResource.DISMISS
    }

    override fun onCleared() {
        liveDataState.value = null
    }
}