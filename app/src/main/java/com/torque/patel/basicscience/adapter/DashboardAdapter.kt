package com.torque.patel.basicscience.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.torque.patel.basicscience.DataItems.DashboardItem
import com.torque.patel.basicscience.R

class DashboardAdapter(
    val currentList: Array<DashboardItem>,
    private val listner: OnItemClickListener
): RecyclerView.Adapter<DashboardAdapter.DashViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_dashboard,parent,false)
        return DashViewHolder(view)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onBindViewHolder(holder: DashViewHolder, position: Int) {
        holder.imageView.setImageResource(currentList[position].imageResource)
        holder.textView.text = currentList[position].subject

    }


    inner class DashViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
        OnClickListener{

        val imageView = itemView.findViewById<ImageView>(R.id.db_imageView)
        val textView = itemView.findViewById<TextView>(R.id.db_textView)


        init {
            itemView.setOnClickListener(this)

        }

        override fun onClick(v: View?) {
            val position = bindingAdapterPosition

            if (position != RecyclerView.NO_POSITION){
                listner.onItemClick(position)
            }
        }

    }


    interface OnItemClickListener{

        fun onItemClick(position: Int)
    }

}