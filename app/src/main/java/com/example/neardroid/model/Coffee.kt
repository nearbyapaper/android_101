package com.example.neardroid.model

import com.google.gson.annotations.SerializedName

class Coffee (
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("content") val content: String
)