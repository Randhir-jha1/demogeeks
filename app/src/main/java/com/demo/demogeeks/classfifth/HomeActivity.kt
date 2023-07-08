package com.demo.demogeeks.classfifth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.demogeeks.R
import com.demo.demogeeks.databinding.ActivityHomeBinding
import com.demo.demogeeks.databinding.ActivityListBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var preferences: AppPreferences
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferences= AppPreferences(this)

        binding.tvUserName.text=preferences.getUsername()

        binding.Logout.setOnClickListener{
            preferences.clearData()
            startActivity(Intent(this,SplashActivity::class.java))
            finish()
        }

    }
}