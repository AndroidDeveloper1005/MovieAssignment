package com.example.movieassignment.utilities

import android.content.Context
import android.widget.Toast
import com.example.movieassignment.R
import com.google.android.material.snackbar.Snackbar

fun Context.toast(msg:String, length:Int = Toast.LENGTH_LONG){
    Toast.makeText(this, msg, length).show()
}