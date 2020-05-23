package com.example.movieassignment.utilities

import android.util.Log

object Logger {

    fun LogResult(TAG : String, methodName : String, msg : String ){
        Log.v(TAG, methodName + "() -> "+ msg)
    }
}