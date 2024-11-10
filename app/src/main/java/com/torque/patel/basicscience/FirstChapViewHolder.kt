package com.torque.patel.basicscience


import androidx.recyclerview.widget.RecyclerView
import com.torque.patel.basicscience.databinding.FirstChap1Binding

class FirstChapViewHolder(private val binding:FirstChap1Binding, private val clickListener: OnItemClickListner):RecyclerView.ViewHolder(binding.root) {


    init {
        // Add OnClickListener to the root view of the item
        binding.root.setOnClickListener {
            // Handle the click event here
            val position = bindingAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                // Call the interface method to notify the activity of the click
                clickListener.onItemClick(position)
            }
        }
    }
    fun bind(dataChap: DataChap){



        binding.numbering.text = dataChap.no.toString()
        binding.nameChapter.text = dataChap.chapterName
        binding.rectangleImgId.setImageResource(dataChap.rectangle_icon)

    }


}

interface OnItemClickListner {
    fun onItemClick(position: Int)
}

