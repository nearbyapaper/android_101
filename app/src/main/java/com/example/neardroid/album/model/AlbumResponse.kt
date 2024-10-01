package com.example.neardroid.album.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AlbumResponse(
    val id: Int,
    val userId: Int,
    @SerializedName("title")
    val titleName: String
): Parcelable
