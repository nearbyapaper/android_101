package com.example.neardroid.login.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.neardroid.api.ServerErrorException
import com.example.neardroid.login.model.response.LoginResponse
import com.example.neardroid.login.repository.LoginRepository
import com.example.neardroid.model.TestAPIResponse
import com.example.neardroid.util.AppToast
import com.example.neardroid.util.BaseViewModel
import com.example.neardroid.util.Resource
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

class LoginViewModel @Inject constructor (private val repository: LoginRepository): BaseViewModel() {

    val disposable = CompositeDisposable()

    private val _testState = MutableLiveData<Resource<TestAPIResponse>>()
    val testState:LiveData<Resource<TestAPIResponse>> = _testState

    @SuppressLint("CheckResult")
    fun callTestAPI(){
        repository.testCallAPI().subscribeBy(
            onSuccess = {
                Log.d("1995","onSuccess it :: $it")
                _testState.postValue(Resource.success(it))
                // postValue is operator of MutableLiveData for synchronus change
            },
            onError = {
                Log.d("1995","onError it :: $it")
            }
        ).addTo(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}