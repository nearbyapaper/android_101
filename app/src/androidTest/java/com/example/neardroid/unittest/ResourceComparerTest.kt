package com.example.neardroid.unittest

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.neardroid.R
import org.junit.Assert.*
import org.junit.Test

class ResourceComparerTest {

    private val resourceComparer = ResourceComparer()
    private val context = ApplicationProvider.getApplicationContext<Context>()

    @Test
    fun inputGivenResIdSameAsName_ShouldReturnTrue() {
        val result = resourceComparer.isEqual(context, R.string.app_name, "Neardroid")
        assertTrue(result)
    }

    @Test
    fun inputGivenResIdDifferentAsName_ShouldReturnFalse() {
        val result = resourceComparer.isEqual(context, R.string.login_failed, "Neardroid")
        assertFalse(result)
    }
}
