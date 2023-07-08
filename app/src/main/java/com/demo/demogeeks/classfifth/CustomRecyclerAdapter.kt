package com.demo.demogeeks.classfifth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.demo.demogeeks.R

class CustomRecyclerAdapter(private val itemList:List<GeeksUser>,private val onItemClick:OnItemClickListener):RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder>() {


    interface OnItemClickListener{
        fun onItemClick(item:GeeksUser)
        fun onItemImageClick(item:String)
    }
    //Initailizing all the items of list item layout
   inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
       val itemTextView: TextView = itemView.findViewById(R.id.itemTextView)
       val itemTextView1: TextView = itemView.findViewById(R.id.itemTextView1)
       val ivItem: ImageView = itemView.findViewById(R.id.ivItem)

        init {
            itemView.setOnClickListener{
                val position =adapterPosition
                if (position!=RecyclerView.NO_POSITION){
                    val item= itemList[position]
                    onItemClick.onItemClick(item)
                }
            }
            ivItem.setOnClickListener{
                val position =adapterPosition
                if (position!=RecyclerView.NO_POSITION){
                    val item= itemList[position]
                    onItemClick.onItemImageClick(item.image.toString())
                }
            }
        }
   }

    // Inflate the item layout
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomRecyclerAdapter.ViewHolder {
       val  view =LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
       return ViewHolder(view)
    }

    //Set Data to the list items
    override fun onBindViewHolder(holder: CustomRecyclerAdapter.ViewHolder, position: Int) {
       val item=itemList[position]
        holder.itemTextView.text=item.name
        holder.itemTextView1.text=item.age.toString()
        holder.ivItem.setImageResource(item.image)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}