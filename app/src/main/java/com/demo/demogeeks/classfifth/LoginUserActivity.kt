package com.demo.demogeeks.classfifth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.demo.demogeeks.R

class LoginUserActivity : AppCompatActivity() {

    lateinit var edtEmail:EditText
    lateinit var edtPass:EditText
    lateinit var SignIn:Button
    lateinit var strEmail:String
    lateinit var strPassword:String

    private lateinit var preferences: AppPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initUi()
        onClick()
        preferences= AppPreferences(this)

    }
    private fun initUi(){
        edtEmail= findViewById(R.id.edtEmail)
        edtPass= findViewById(R.id.edtPassword)
        SignIn= findViewById(R.id.SignIn)
    }

    private fun onClick(){


        SignIn.setOnClickListener(){
            strEmail= edtEmail.text.toString()
            strPassword= edtPass.text.toString()

            preferences.setIsLogin(true)
            preferences.setUsername(strEmail)
            preferences.setUsertype(1)
            startActivity(Intent(this,SplashActivity::class.java))
            finish()
        }


    }

}