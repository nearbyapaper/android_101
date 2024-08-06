package com.example.neardroid.util

import android.content.Context
import android.widget.Toast

class AppToast(context: Context): Toast(context) {
    fun create (context:Context, message : String):Toast {
        val duration = Toast.LENGTH_SHORT
        return Toast.makeText(context, message, duration)
    }
}