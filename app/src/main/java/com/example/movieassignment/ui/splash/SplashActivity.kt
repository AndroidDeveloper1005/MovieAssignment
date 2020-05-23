package com.example.movieassignment.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.movieassignment.R
import com.example.movieassignment.databinding.ActivitySplashBinding
import com.example.movieassignment.ui.home_page.HomePageActivity

class SplashActivity : AppCompatActivity() {

    lateinit var mBinding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val handler = Handler();
        handler.postDelayed(Runnable {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
            finish()
        }, 500)
    }
}
