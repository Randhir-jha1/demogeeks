package com.demo.demogeeks.classsix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.demogeeks.R
import com.demo.demogeeks.databinding.ActivitySqlviewBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SQLViewActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySqlviewBinding
    private lateinit var studentList:ArrayList<Student>
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var adapter: RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySqlviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        studentList = ArrayList()
        databaseHelper = DatabaseHelper(this)

        adapter= RecyclerViewAdapter(studentList)
        binding.fbAdd.setOnClickListener(){
            val intent = Intent(this, SqlAddActivity::class.java)
            startActivity(intent)

        }
        binding.rvMain.adapter=adapter
        binding.rvMain.layoutManager= LinearLayoutManager(this)

        studentList.addAll(databaseHelper.getAllStudents())
        adapter.notifyDataSetChanged()
    }
}