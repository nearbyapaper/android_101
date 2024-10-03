package com.example.neardroid.invest.fisginh_net.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "business_item")
data class BusinessItem (
    val name: String ?= "",
    val value: String ?= "",
    val otherHaveThisValue: Boolean ?= false,
    val wantToAcceptThisValue: Boolean ?= false,
    val whyYouWantToAcceptThisValue: String ?= "",
    val durableValue: Boolean ?= false,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)