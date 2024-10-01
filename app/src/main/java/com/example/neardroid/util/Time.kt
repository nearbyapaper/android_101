package com.example.neardroid.util

class TimeUtil {
    fun checkTime(hour: Int,minute: Int):String {
        var msg: String
        if(hour < 10 && minute<10){
            msg = "0$hour : 0$minute"
        }else if (hour > 10 && minute<10){
            msg = "$hour : 0$minute"
        }else if (hour < 10 && minute>10){
            msg = "0$hour : $minute"
        }else{
            msg = "$hour : $minute"
        }
        return msg
    }
}