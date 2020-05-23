package com.example.movieassignment.utilities

import android.view.View

fun View.setVisibilityStatus(status: String){
    when{
        status.equals("invisble", ignoreCase = true) -> visibility = View.INVISIBLE
        status.equals("visible", ignoreCase = true) -> visibility = View.VISIBLE
        status.equals("gone", ignoreCase = true) -> visibility = View.GONE
    }
}