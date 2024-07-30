package com.example.neardroid.util

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import com.example.neardroid.model.AlarmMessage

class AlarmManagerCalling(var context: Context,var title: String, var content:String) {
    // create manager by using getSystemService from context
    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    // fun start alarm
    fun startAlarm(sec: Int = 1) {
        // sec to millisec
        val ms = sec * 1000
        // create intent pass to AlarmReceiver
        val intent = Intent(context, AppReceiver::class.java)
        // bundle message
        val bundle = Bundle()
        bundle.putParcelable("alarmMsg", AlarmMessage(title,content))
        intent.putExtra("bundle",bundle)
        // create pending intent using broadcast alert
        val pendingIntent =
            PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        // call alarmmanager take action
        alarmManager.setExact(
            AlarmManager.ELAPSED_REALTIME_WAKEUP,
            SystemClock.elapsedRealtime() + ms,
            pendingIntent
        )
    }
}