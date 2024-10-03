package com.example.neardroid.invest.fisginh_net.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.neardroid.invest.fisginh_net.model.BusinessItem

@Database(
    entities = [
        BusinessItem::class
    ],
    version = 1
)
abstract class FishingNetBussinessDB : RoomDatabase() {

    abstract fun businessDAO(): BusinessDAO
}