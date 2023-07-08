package com.demo.demogeeks.classfifth

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.demo.demogeeks.R
import com.demo.demogeeks.databinding.ActivityCalculatorBinding
import com.demo.demogeeks.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // val itemList = listOf("Item 1", "Item 2", "Item 3","Item 4")//Sample Data

        val itemList= listOf(
            GeeksUser("Randhir",28,R.drawable.avatar),
            GeeksUser("Vishal",23,R.drawable.avatar),
            GeeksUser("Anuj",25,R.drawable.avatar),
            GeeksUser("Shubham",24,R.drawable.avatar)

        )

        //Simple Way using ArrayAdapter
//        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_activated_1,itemList)
//        binding.listView.adapter= adapter
//
//        binding.listView.setOnItemClickListener{parent,view,position,id->
//            val selectedItem= itemList[position]
//            Toast.makeText(this,"Clicked: $selectedItem",Toast.LENGTH_LONG).show()
//        }

        //CustomAdapter for ListView

        val adapter= CustomArrayAdapter(this,R.layout.list_item,itemList)
        binding.listView.adapter= adapter
        binding.listView.setOnItemClickListener{parent,view,position,id->
            val selectedItem= itemList[position]
            Toast.makeText(this,"Clicked: $selectedItem",Toast.LENGTH_LONG).show()
        }
    }

    class CustomArrayAdapter(
        context: Context,
        private val resourceId: Int,
        private val itemList: List<GeeksUser>
    ) :
        ArrayAdapter<GeeksUser>(context, resourceId, itemList) {
        private val inflater: LayoutInflater = LayoutInflater.from(context)

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view: View = convertView ?: inflater.inflate(resourceId, parent, false)
            val itemTextView: TextView = view.findViewById(R.id.itemTextView)
            val itemTextView1: TextView = view.findViewById(R.id.itemTextView1)
            val ivItem: ImageView = view.findViewById(R.id.ivItem)
            itemTextView.text = itemList[position].name
            itemTextView1.text = itemList[position].age.toString()
            ivItem.setImageResource(itemList[position].image)

            return view

        }
    }

}