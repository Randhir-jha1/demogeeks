package com.demo.demogeeks.classfifth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.demogeeks.R
import com.demo.demogeeks.databinding.ActivityListBinding
import com.demo.demogeeks.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity(),CustomRecyclerAdapter.OnItemClickListener {
    private lateinit var binding: ActivityRecyclerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemList= listOf(
            GeeksUser("Randhir",28,R.drawable.avatar),
            GeeksUser("Vishal",23,R.drawable.avatar),
            GeeksUser("Anuj",25,R.drawable.avatar),
            GeeksUser("Shubham",24,R.drawable.avatar),
            GeeksUser("Shubham",24,R.drawable.avatar),
            GeeksUser("Shubham",24,R.drawable.avatar),
            GeeksUser("Shubham",24,R.drawable.avatar),
            GeeksUser("Shubham",24,R.drawable.avatar),
            GeeksUser("Shubham",24,R.drawable.avatar),
            GeeksUser("Shubham",24,R.drawable.avatar),
            GeeksUser("Shubham",24,R.drawable.avatar),
            GeeksUser("Shubham",24,R.drawable.avatar),
            GeeksUser("Shubham",24,R.drawable.avatar),
            GeeksUser("Shubham",24,R.drawable.avatar),
            GeeksUser("Shubham",24,R.drawable.avatar),
            GeeksUser("Shubham",24,R.drawable.avatar),
            GeeksUser("Shubham",24,R.drawable.avatar),
            GeeksUser("Shubham",24,R.drawable.avatar),
            GeeksUser("Shubham",24,R.drawable.avatar),
            GeeksUser("Shubham",24,R.drawable.avatar),
            GeeksUser("Shubham",24,R.drawable.avatar),
            GeeksUser("Shubham",24,R.drawable.avatar),
            GeeksUser("Shubham",24,R.drawable.avatar)

        )
        val adapter  = CustomRecyclerAdapter(itemList,this)
        //Default
       // val layoutManager=LinearLayoutManager(this)

        //Other Layout Managers
        //val layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        //Grid Layout Manager
        val layoutManager =GridLayoutManager(this,2)
        binding.rvMain.layoutManager= layoutManager
        binding.rvMain.adapter= adapter

    }

    override fun onItemClick(item: GeeksUser) {
     Toast.makeText(this,"Clicked: ${item}",Toast.LENGTH_LONG).show()
    }

    override fun onItemImageClick(item: String) {
        Toast.makeText(this,"Clicked: ${item}",Toast.LENGTH_LONG).show()
    }
}