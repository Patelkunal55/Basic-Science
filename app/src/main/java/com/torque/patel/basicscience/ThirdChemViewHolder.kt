package com.torque.patel.basicscience

import androidx.recyclerview.widget.RecyclerView
import com.torque.patel.basicscience.databinding.ThirdChemViewBinding

class ThirdChemViewHolder(private val binding: ThirdChemViewBinding):RecyclerView.ViewHolder(binding.root) {

    fun bind(dataChem: DataCheModel){
        val imageView = dataChem.imageChem


        binding.imageActionChe.setImageResource(imageView)

    }
}