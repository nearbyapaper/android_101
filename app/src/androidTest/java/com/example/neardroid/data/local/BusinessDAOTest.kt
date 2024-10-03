package com.example.neardroid.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.neardroid.invest.fisginh_net.model.BusinessItem
import com.example.neardroid.invest.fisginh_net.room.BusinessDAO
import com.example.neardroid.invest.fisginh_net.room.FishingNetBussinessDB
import com.example.neardroid.util.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest // make sure on this test no Network, DB, File systems access, Use external systems,
// Multiple Threads, Sleep Statements, System properties
class BusinessDAOTest {
    @get:Rule
//    var taskExecutorRule = TaskExecutorWithIdlingResourceRule()
    var instantExecutorRule = InstantTaskExecutorRule()

    lateinit var db: FishingNetBussinessDB
    lateinit var dao: BusinessDAO

    @Before
    fun setUp() { // this function will compile on every after test case
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            FishingNetBussinessDB::class.java
        ).allowMainThreadQueries().build()
        dao = db.businessDAO()
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun insertBusinessSuccess() = runBlocking {
        val businessItem = BusinessItem("KFC", "Fried Chicken", true, true, "Delicious", true,1)
        dao.insertBusiness(businessItem)
        val allBusiness = dao.getAllFishingNetBusiness().getOrAwaitValue()

        assert(allBusiness.contains(businessItem))
    }

    @Test
    fun deleteBusinessSuccess() = runBlocking {
        val businessItem = BusinessItem("KFC", "Fried Chicken", true, true, "Delicious", true,1)
        dao.insertBusiness(businessItem)
        dao.deleteBusiness(businessItem)
        val allBusiness = dao.getAllFishingNetBusiness().getOrAwaitValue()

        assert(allBusiness.isEmpty())
    }

    @Test
    fun getAllBusinessSuccess() = runBlocking {
        val businessItem = BusinessItem("KFC", "Fried Chicken", true, true, "Delicious", true,1)
        val businessItem2 = BusinessItem("FCK", "Fried Chicken", true, true, "Delicious", true,2)
        val businessItem3 = BusinessItem("CFK", "Fried Chicken", true, true, "Delicious", true,3)
        dao.insertBusiness(businessItem)
        dao.insertBusiness(businessItem2)
        dao.insertBusiness(businessItem3)
        val allBusiness = dao.getAllFishingNetBusiness().getOrAwaitValue()

        assert(allBusiness.size == 3)
    }

    @Test
    fun getBusinessByNameSuccess() = runBlocking {
        val businessItem = BusinessItem("KFC", "Fried Chicken", true, true, "Delicious", true,1)
        val businessItem2 = BusinessItem("FCK", "Fried Chicken", true, true, "Delicious", true,2)
        val businessItem3 = BusinessItem("CFK", "Fried Chicken", true, true, "Delicious", true,3)
        dao.insertBusiness(businessItem)
        dao.insertBusiness(businessItem2)
        dao.insertBusiness(businessItem3)
        val searchedBusiness = dao.getFishingNetBusinessByName("KFC").getOrAwaitValue()

        assert(searchedBusiness.name == "KFC")
    }
}