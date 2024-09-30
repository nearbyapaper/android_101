package com.example.neardroid.invest.fisginh_net.model

import com.example.neardroid.invest.fisginh_net.model.response.FocusBusinessListResponse

data class FishingNetModel(
    var business: FishingNetBusiness ?= null,
    var focusBusinessList: FocusBusinessListResponse ?= null
)
