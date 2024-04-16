package com.torque.patel.basicscience

import android.text.Html
import androidx.recyclerview.widget.RecyclerView
import com.torque.patel.basicscience.databinding.ItemView1Binding

class FirstViewHolder(private val binding: ItemView1Binding):RecyclerView.ViewHolder(binding.root) {

    fun bind(dataModel: DataModel){

        binding.TextItemView1.text  = dataModel.title.toString()
        //binding.description.text = dataModel.description
        binding.description.text = Html.fromHtml(dataModel.description,Html.FROM_HTML_MODE_LEGACY)


    }

}