package com.demo.demogeeks.classfifth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.demo.demogeeks.R

class SplashActivity : AppCompatActivity() {

    private lateinit var appPreferences: AppPreferences
    private val SPLASH_DELAY:Long =2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        appPreferences = AppPreferences(this)
        Handler().postDelayed({
          if (appPreferences.getIsLogin()){
              startActivity(Intent(this,HomeActivity::class.java))
          }
            else{
              startActivity(Intent(this,LoginUserActivity::class.java))
          }
        },SPLASH_DELAY)
    }
}