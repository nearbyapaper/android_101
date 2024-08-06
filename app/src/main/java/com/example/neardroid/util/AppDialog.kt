package com.example.neardroid.util

import android.app.AlertDialog
import android.content.Context

class AppDialog{

}

//class AppDialog(val context: Context, private val action: OnDialogButtonListener) : AlertDialog(context) {
//    fun create(context: Context, message: String): AlertDialog {
//        return AlertDialog.Builder(context).setMessage(message)
//            .setPositiveButton("OK") { dialog, id ->
//                action.handlePositiveButton()
//            }
//            .setNegativeButton("Cancel") { dialog, id ->
//                action.handleNegativeButton()
//            }.create() ?: throw IllegalStateException("Activity cannot be null")
//    }
//}