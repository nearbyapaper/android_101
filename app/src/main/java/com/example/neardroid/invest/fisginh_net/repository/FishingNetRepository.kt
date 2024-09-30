package com.example.neardroid.invest.fisginh_net.repository

import com.example.neardroid.invest.fisginh_net.model.FishingNetBusiness
import com.example.neardroid.invest.fisginh_net.model.FishingNetModel
import com.example.neardroid.invest.fisginh_net.model.response.FocusBusinessListResponse
import com.example.neardroid.invest.fisginh_net.network.FishingNetAPI
import javax.inject.Inject

class FishingNetRepository @Inject constructor(
    val api: FishingNetAPI
){
    val model: FishingNetModel = FishingNetModel()

    var business: FishingNetBusiness?
        get() = model.business
        set(value) {
            model.business = value
        }

    var focusBusinessList: FocusBusinessListResponse?
    get() = model.focusBusinessList
        set(value) {
            model.focusBusinessList = value
        }

    fun testAPI() = api.testFishingAPI()
    fun saveBusiness(req: FishingNetBusiness) = api.saveFocusBusiness(req)
    fun getBusinessList() = api.getAllFocusBusiness()

}