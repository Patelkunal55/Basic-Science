package com.torque.patel.basicscience

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.torque.patel.basicscience.databinding.FirstBioViewBinding
import com.torque.patel.basicscience.databinding.SecondBioViewBinding
import com.torque.patel.basicscience.databinding.ThirdBioViewBinding

class BioViewAdapter(private val list: ArrayList<Any>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val FIRST_VIEW = 1
        const val SECOND_VIEW = 2
        const val THIRD_VIEW = 3
        const val AD_VIEW = 4

    }
   /* override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            FIRST_VIEW -> FirstBioViewHolder(FirstBioViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            SECOND_VIEW -> SecondBioViewHolder(SecondBioViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            else -> throw IllegalArgumentException("Invalid type")
        }
    }*/

    override fun getItemCount(): Int {
        return list.size
    }// this is a list of item

    /*override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return when(list[position].theViewType){
            FIRST_VIEW -> (holder as FirstBioViewHolder).bind(list[position])
            SECOND_VIEW -> (holder as SecondBioViewHolder).bind(list[position])
            else -> throw IllegalArgumentException("Invaild type")
        }
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            FIRST_VIEW -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = FirstBioViewBinding.inflate(inflater, parent, false)
                FirstBioViewHolder(binding)
            }
            SECOND_VIEW -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = SecondBioViewBinding.inflate(inflater, parent, false)
                SecondBioViewHolder(binding)
            }
            THIRD_VIEW -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ThirdBioViewBinding.inflate(inflater, parent, false)
                ThirdBioViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is FirstBioViewHolder -> {
                val dataModel1 = list[position] as DataBio
                holder.bind(dataModel1)
            }
            is SecondBioViewHolder -> {
                val dataModel2 = list[position] as DataBioTable
                holder.bind(dataModel2)
            }

            is ThirdBioViewHolder -> {
                val imageData = list[position] as DataBioModel
                holder.bind(imageData)
            }
        }
    }

    /*override fun getItemViewType(position: Int): Int {
        return list[position].theViewType
    }*/

    override fun getItemViewType(position: Int): Int {
        return when(list[position]) {
            is DataBio -> FIRST_VIEW
            is DataBioTable -> SECOND_VIEW
            is DataBioModel -> THIRD_VIEW
            else -> throw IllegalArgumentException("Invalid data model type")
        }
    }




}