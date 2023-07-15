package com.demo.demogeeks.classsix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.demogeeks.R
import com.demo.demogeeks.databinding.ActivitySqlAddBinding

class SqlAddActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySqlAddBinding
    private lateinit var databaseHelper: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySqlAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)

        binding.addButton.setOnClickListener(){

            val name = binding.edtName.text.toString()
            val className = binding.edtClass.text.toString()
            val rollNo = binding.edtRollNo.text.toString().toInt()

            val student =Student(name,className, rollNo)

            databaseHelper.insertStudent(student)
            startActivity(Intent(this, SQLViewActivity::class.java))
            finish()
        }
    }
}