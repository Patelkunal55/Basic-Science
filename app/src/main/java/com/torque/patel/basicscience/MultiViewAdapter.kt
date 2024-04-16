package com.torque.patel.basicscience

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.torque.patel.basicscience.databinding.ItemView1Binding
import com.torque.patel.basicscience.databinding.ItemView2Binding
import com.torque.patel.basicscience.databinding.ItemView3Binding

class MultiViewAdapter(private val list:ArrayList<Any>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        const val FIRST_VIEW = 1
        const val SECOND_VIEW = 2
        const val THIRD_VIEW = 3
    }
   /* override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            FIRST_VIEW -> FirstViewHolder(ItemView1Binding.inflate(LayoutInflater.from(parent.context),parent,false))
            SECOND_VIEW -> SecondViewHolder(ItemView2Binding.inflate(LayoutInflater.from(parent.context),parent,false))
            THIRD_VIEW -> ThirdViewHolder(ItemView3Binding.inflate(LayoutInflater.from(parent.context),parent,false))
            else -> throw IllegalArgumentException("Invalid type")

        }
    }*/

    override fun getItemCount(): Int {
        return list.size
    }

    /*override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return when (list[position].theViewType){
            FIRST_VIEW -> (holder as FirstViewHolder).bind(list[position])
            SECOND_VIEW -> (holder as SecondViewHolder).bind(list[position])
            THIRD_VIEW -> (holder as ThirdViewHolder).bind(list[position])
            else -> throw IllegalArgumentException("Invalid type")


        }
    }*/

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            FIRST_VIEW -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemView1Binding.inflate(inflater, parent, false)
                FirstViewHolder(binding)
            }
            SECOND_VIEW -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemView2Binding.inflate(inflater, parent, false)
                SecondViewHolder(binding)
            }
            THIRD_VIEW -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemView3Binding.inflate(inflater, parent, false)
                ThirdViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }


   override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is FirstViewHolder -> {
                val dataModel1 = list[position] as DataModel
                holder.bind(dataModel1)
            }
            is SecondViewHolder -> {
                val dataModel2 = list[position] as DataPhyTable
                holder.bind(dataModel2)
            }

            is ThirdViewHolder -> {
                val imageData = list[position] as imageData
                holder.bind(imageData)
            }
        }
    }


    /*override fun getItemViewType(position: Int): Int {
        return list[position].theViewType
    }*/

    override fun getItemViewType(position: Int): Int {
        return when(list[position]) {
            is DataModel -> FIRST_VIEW
            is DataPhyTable -> SECOND_VIEW
            is imageData -> THIRD_VIEW
            else -> throw IllegalArgumentException("Invalid data model type")
        }
    }
}