package com.example.neardroid.testdi

import android.content.Context
import android.content.SharedPreferences

class UserPreference(context: Context) {
    companion object {
        private const val PREFERENCE_NAME = "user_preference"
        private const val KEY_ID = "key_id"
        private const val KEY_NAME = "key_name"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun saveUserId(id: Long) {
        sharedPreferences.edit().putLong(KEY_ID, id).apply()
    }

    fun saveUserName(name: String) {
        sharedPreferences.edit().putString(KEY_NAME, name).apply()
    }

    fun getUserId(): Long = sharedPreferences.getLong(KEY_ID, -1)

    fun getUserName(): String? = sharedPreferences.getString(KEY_NAME, null)
}
