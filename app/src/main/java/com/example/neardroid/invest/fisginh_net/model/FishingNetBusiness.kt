package com.example.neardroid.invest.fisginh_net.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FishingNetBusiness(
    val name: String ?= "",
    val value: String ?= "",
    val otherHaveThisValue: String ?= "",
    val wantToAcceptThisValue: String ?= "",
    val whyYouWantToAcceptThisValue: String ?= "",
    val durableValue: String ?= "",
): Parcelable
