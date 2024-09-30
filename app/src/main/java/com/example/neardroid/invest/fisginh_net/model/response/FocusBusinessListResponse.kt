package com.example.neardroid.invest.fisginh_net.model.response

import android.os.Parcelable
import com.example.neardroid.invest.fisginh_net.model.FishingNetBusiness
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FocusBusinessListResponse(

	@field:SerializedName("data")
	val data: List<FishingNetBusiness>? = null,
): Parcelable
