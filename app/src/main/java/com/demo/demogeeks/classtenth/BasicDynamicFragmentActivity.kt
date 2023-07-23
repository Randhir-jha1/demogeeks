package com.demo.demogeeks.classtenth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.demo.demogeeks.R

class BasicDynamicFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_dynamic_fragment)

        val button = findViewById<Button>(R.id.btDynamic)
        button.setOnClickListener(){
            val fragment = DashBoardFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer,fragment)
                .addToBackStack(null)
                .commit()
        }
    }
}