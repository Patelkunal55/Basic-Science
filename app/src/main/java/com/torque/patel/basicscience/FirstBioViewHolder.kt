package com.torque.patel.basicscience

import android.text.Html
import androidx.recyclerview.widget.RecyclerView
import com.torque.patel.basicscience.databinding.FirstBioViewBinding

class FirstBioViewHolder(private val binding: FirstBioViewBinding):RecyclerView.ViewHolder(binding.root) {

    fun bind(dataBio: DataBio){
        binding.Bio1TextItemView1.text = dataBio.title
        binding.bioDescription.text = Html.fromHtml(dataBio.description,Html.FROM_HTML_MODE_LEGACY)
    }
}