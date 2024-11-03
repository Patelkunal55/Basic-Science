package com.torque.patel.basicscience

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.torque.patel.basicscience.databinding.FirstChap1Binding
import com.torque.patel.basicscience.databinding.SecondChap2Binding

class ChapViewAdapter(private val list:ArrayList<DataChap>, private val itemClickListener: OnItemClickListner):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
private lateinit var context: Context



    companion object {
        const val FIRST_VIEW = 1
        const val SECOND_VIEW = 2
        const val THIRD_VIEW = 3
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            FIRST_VIEW -> FirstChapViewHolder(FirstChap1Binding.inflate(LayoutInflater.from(parent.context),parent,false),itemClickListener)
            SECOND_VIEW -> SecondChapViewHolder(SecondChap2Binding.inflate(LayoutInflater.from(parent.context),parent,false))
            else -> throw IllegalArgumentException("Invalid type")

        }


    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return when(list[position].theViewType){
            FIRST_VIEW -> (holder as FirstChapViewHolder).bind(list[position])
            SECOND_VIEW -> (holder as SecondChapViewHolder).bind(list[position])
            else -> throw IllegalArgumentException("Invalid type")

        }
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].theViewType
    }


}