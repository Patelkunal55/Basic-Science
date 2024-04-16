package com.torque.patel.basicscience

import androidx.recyclerview.widget.RecyclerView
import com.torque.patel.basicscience.databinding.ItemView3Binding
import com.torque.patel.basicscience.databinding.ThirdBioViewBinding

class ThirdBioViewHolder(private val binding:ThirdBioViewBinding):RecyclerView.ViewHolder(binding.root) {


    fun bind(dataBio: DataBioModel) {

        val imageView = dataBio.imageBio


        binding.imageActionBio.setImageResource(imageView)

    }




}