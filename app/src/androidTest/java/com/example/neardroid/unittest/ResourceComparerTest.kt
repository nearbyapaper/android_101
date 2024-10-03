package com.example.neardroid.unittest

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.neardroid.R
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ResourceComparerTest {

    lateinit var resourceComparer :ResourceComparer

    @Before
    fun setup() {
        resourceComparer = ResourceComparer()
    }

    @Test
    fun inputGivenResIdSameAsName_ShouldReturnTrue() {
        var  context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "Neardroid")
        assertTrue(result)
    }

    @Test
    fun inputGivenResIdDifferentAsName_ShouldReturnFalse() {
        var  context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.login_failed, "Neardroid")
        assertFalse(result)
    }
}
