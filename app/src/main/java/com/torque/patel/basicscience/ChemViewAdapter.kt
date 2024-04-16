package com.torque.patel.basicscience

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.torque.patel.basicscience.databinding.FirstChemViewBinding
import com.torque.patel.basicscience.databinding.SecondChemViewBinding
import com.torque.patel.basicscience.databinding.ThirdChemViewBinding

class ChemViewAdapter(private val list:ArrayList<Any>,val onItemClickListners: OnItemClickListners):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        const val FIRST_VIEW = 1
        const val SECOND_VIEW = 2
        const val THIRD_VIEW = 3
    }
    /*override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            FIRST_VIEW -> FirstChemViewHolder(FirstChemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false),onItemClickListners)
            SECOND_VIEW -> SecondChemViewHolder(SecondChemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))


            else -> throw IllegalArgumentException("Invalid type")
        }
    }*/



    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when(viewType){
            FIRST_VIEW -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = FirstChemViewBinding.inflate(inflater, parent, false)
                FirstChemViewHolder(binding,onItemClickListners)
            }
            SECOND_VIEW -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = SecondChemViewBinding.inflate(inflater, parent, false)
                SecondChemViewHolder(binding)
            }
            THIRD_VIEW -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ThirdChemViewBinding.inflate(inflater, parent, false)
                ThirdChemViewHolder(binding)
            }
            else -> throw  IllegalArgumentException("Invalid view type")
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is FirstChemViewHolder -> {
                val dataModel1 = list[position] as DataChem
                holder.bind(dataModel1)
            }
            is SecondChemViewHolder -> {
                val dataModel2 = list[position] as DataChemTable
                holder.bind(dataModel2)
            }

            is ThirdChemViewHolder -> {
                val imageData = list[position] as DataCheModel
                holder.bind(imageData)
            }
        }
    }


    /* override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
         return when(list[position].theViewType){
             FIRST_VIEW -> ( holder as FirstChemViewHolder).bind(list[position])
             SECOND_VIEW -> ( holder as SecondChemViewHolder).bind(list[position])
             THIRD_VIEW -> ( holder as ThirdChemViewHolder).bind(list[position])
             else -> throw IllegalArgumentException("Invaild type")
         }
     }*/


   /* override fun getItemViewType(position: Int): Int {
        return list[position].theViewType
    }*/


    override fun getItemViewType(position: Int): Int {
        return when(list[position]) {
            is DataChem -> FIRST_VIEW
            is DataChemTable -> SECOND_VIEW
            is DataCheModel -> THIRD_VIEW
            else -> throw IllegalArgumentException("Invalid data model type")
        }
    }



}