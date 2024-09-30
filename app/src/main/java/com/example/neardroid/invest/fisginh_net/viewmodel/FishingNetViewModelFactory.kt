package com.example.neardroid.invest.fisginh_net.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.neardroid.invest.fisginh_net.repository.FishingNetRepository
import javax.inject.Inject

class FishingNetViewModelFactory @Inject constructor(
    private val repository: FishingNetRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FishingNetViewModel::class.java)){
            return FishingNetViewModel(repository) as T
        }else{
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}