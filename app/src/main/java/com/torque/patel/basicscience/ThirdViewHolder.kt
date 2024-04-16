package com.torque.patel.basicscience

import androidx.recyclerview.widget.RecyclerView
import com.torque.patel.basicscience.databinding.ItemView3Binding
import com.torque.patel.basicscience.databinding.ThirdBioViewBinding

class ThirdViewHolder(private val binding: ItemView3Binding):RecyclerView.ViewHolder(binding.root) {

    fun bind(imageDatav: imageData){

        val imageview = imageDatav.imageView
        //binding.imageAction.setImageResource(imageview)

        //val imageview = imageDatav.theViewType
        binding.imageAction.setImageResource(imageview)
        //binding.imageAction.layoutParams.height = 80



    }
}