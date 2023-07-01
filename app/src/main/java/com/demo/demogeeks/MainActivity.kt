package com.demo.demogeeks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("LifeCycle","onCreate")
        //This method is called fist when an activity created
    }

    override fun onStart() {
        super.onStart()
        Log.i("LifeCycle","onStart")
        //This method when activity when activity is visible to user
    }

    override fun onResume() {
        super.onResume()
        Log.i("LifeCycle","onResume")
        //This method call when user interaction is ready
    }

    override fun onPause() {
        super.onPause()
        Log.i("LifeCycle","onPause")
        //Activity is partially visible
    }

    override fun onStop() {
        super.onStop()
        Log.i("LifeCycle","onStop")
        //Activity no longer visible
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LifeCycle","onStop")
        //Not in memory removed or destroyed
    }
}