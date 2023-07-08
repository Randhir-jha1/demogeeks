package com.demo.demogeeks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class IntentDemoActivity : AppCompatActivity() {
    lateinit var tvEmail: TextView
    lateinit var tvPassword: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_demo)
        tvEmail= findViewById(R.id.tvEmail)
        tvPassword= findViewById(R.id.tvPassword)
        //To get the value from other activity
//        val strEmail = intent.getStringExtra("Email")
//        val strPassword = intent.getStringExtra("Password")


        //To get data class value from other Activity
        val students = intent.getSerializableExtra("studentData") as? Students
        if (students!=null){
            val strEmail = students.name
            val strPassword = students.age

            tvEmail.text= strEmail
            tvPassword.text= strPassword.toString()
        }

    }
}