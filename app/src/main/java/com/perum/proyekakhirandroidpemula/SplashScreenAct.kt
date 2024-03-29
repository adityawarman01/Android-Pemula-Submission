package com.perum.proyekakhirandroidpemula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenAct : AppCompatActivity() {

   private val SPLASH_TIME: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

    Handler().postDelayed({
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }, SPLASH_TIME
    )


    }
}