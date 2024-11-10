package com.torque.patel.basicscience

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(private val exampleList: Array<ExampleItem>,
                  private val listner: OnItemClickListner): RecyclerView.Adapter<MenuAdapter.ExampleViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_item,parent,false)
        return ExampleViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]

        holder.image_View.setImageResource(currentItem.imageResource)
        holder.textView.text = currentItem.text1

    }


    override fun getItemCount() = exampleList.size




    inner class ExampleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    ,View.OnClickListener{

        val image_View = itemView.findViewById<ImageView>(R.id.image_view)
        val textView = itemView.findViewById<TextView>(R.id.text_view_1)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = bindingAdapterPosition

            if (position !=RecyclerView.NO_POSITION){
                listner.onItemClick(position)
            }
        }





    }

    interface OnItemClickListner {
        fun onItemClick(position: Int)
    }
}