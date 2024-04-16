package com.torque.patel.basicscience

import android.text.Html
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.torque.patel.basicscience.databinding.FirstChemViewBinding

class FirstChemViewHolder(private val binding: FirstChemViewBinding,private val clickListners: OnItemClickListners) : RecyclerView.ViewHolder(binding.root) {

    init {

        binding.root.setOnClickListener {
            val position = bindingAdapterPosition
            if (position != RecyclerView.NO_POSITION){
                clickListners.OnItemClicks(position)
            }
        }
    }


    fun bind(cheDataChem: DataChem) {
        binding.Chem1TextItemView1.text = cheDataChem.title
        binding.chemDescription.text = Html.fromHtml(cheDataChem.description)






    }
}

interface OnItemClickListners{
    fun OnItemClicks(position:Int)
}

