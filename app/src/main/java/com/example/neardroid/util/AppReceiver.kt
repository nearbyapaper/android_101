package com.example.neardroid.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.neardroid.model.AlarmMessage

class AppReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        TODO("AppReceiver.onReceive() is not implemented")

        // get bundle from manager
        val bundle = intent.getBundleExtra("bundle")
//        val msg = bundle?.getParcelable("alarmMsg",AlarmMessage::class.java)
//        val msg = bundle?.getParcelable("alarmMsg")
        // create noti model
//        val notificationModel = NotificationModel(C)
    }
}