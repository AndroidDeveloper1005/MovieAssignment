package com.example.movieassignment.utilities

import android.text.TextUtils

fun isUrlValid(url : String?) : Boolean{

    if (!TextUtils.isEmpty(url)){
        return true
    }
    return false
}