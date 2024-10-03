package com.example.neardroid.invest.fisginh_net.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.neardroid.invest.fisginh_net.model.BusinessItem

@Dao
interface BusinessDAO {
    @Query("SELECT * FROM business_item")
    fun getAllFishingNetBusiness() : LiveData<List<BusinessItem>>

    @Query("SELECT * FROM business_item WHERE name = :name")
    fun getFishingNetBusinessByName(name : String) : LiveData<BusinessItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBusiness(businessItem: BusinessItem)
    @Delete
    suspend fun deleteBusiness(businessItem: BusinessItem)


}