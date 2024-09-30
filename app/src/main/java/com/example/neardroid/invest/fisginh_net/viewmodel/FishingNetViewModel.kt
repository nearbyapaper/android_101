package com.example.neardroid.invest.fisginh_net.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.neardroid.invest.fisginh_net.model.FishingNetBusiness
import com.example.neardroid.invest.fisginh_net.model.response.FocusBusinessListResponse
import com.example.neardroid.invest.fisginh_net.repository.FishingNetRepository
import com.example.neardroid.model.TestAPIResponse
import com.example.neardroid.util.Resource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class FishingNetViewModel @Inject constructor(
    val repository: FishingNetRepository
) : ViewModel() {

    private val disposable = CompositeDisposable()

    // LiveData + MutableLiveData
    private val _saveBusinessResp by lazy { MutableLiveData<Resource<FishingNetBusiness>>() }
    val saveBusinessResp: LiveData<Resource<FishingNetBusiness>> = _saveBusinessResp

    private val _businessListResp by lazy { MutableLiveData<Resource<FocusBusinessListResponse>>() }
    val businessListResp: LiveData<Resource<FocusBusinessListResponse>> = _businessListResp

    // Share Data in Repository
    var business: FishingNetBusiness?
        get() = repository.business
        set(value) {
            repository.business = value
        }

    var focusBusinessList: FocusBusinessListResponse?
        get() = repository.focusBusinessList
        set(value) {
            repository.focusBusinessList = value
        }

    // call API method
    @SuppressLint("CheckResult")
    fun callTest() {
        Log.d("1995", "callTest")
        repository.testAPI()
            .subscribeOn(Schedulers.io()) // Executes on the IO thread (for network calls)
            .observeOn(AndroidSchedulers.mainThread()) // Observes on the main thread (for UI updates)
            .doOnSubscribe {
                Log.d("1995", "doOnSubscribe")
            }
            .subscribeBy(
                onSuccess = {
                    if (it.message != null) {
                        Log.d("1995", "onSuccess it.message :: ${it.message}")
                    }
                },
                onError = {
                    Log.d("1995", "onError it :: ${it}")
                }
            ).addTo(disposable)
    }

    @SuppressLint("CheckResult")
    fun saveBusiness(req: FishingNetBusiness) {
        repository.saveBusiness(req).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).doOnSubscribe {
                Log.d("1995", "saveBusiness doOnSubscribe")
            }.subscribeBy(
                onSuccess = {
                    if (it.name != null) {
                        _saveBusinessResp.postValue(Resource.success(it))
                    }
                },
                onError = {
                    Log.d("1995", "onError it :: ${it}")
                })
    }

    @SuppressLint("CheckResult")
    fun getFocusBusinessList() {
        repository.getBusinessList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeBy(
            onSuccess = {
                if (it.data != null) {
                    focusBusinessList = it
                    _businessListResp.postValue(Resource.success(it))
                }
            },
            onError = {
            }
        )
    }
}