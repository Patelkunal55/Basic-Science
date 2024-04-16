package com.torque.patel.basicscience

import androidx.recyclerview.widget.RecyclerView
import com.torque.patel.basicscience.databinding.SecondBioViewBinding

class SecondBioViewHolder(private val binding: SecondBioViewBinding):RecyclerView.ViewHolder(binding.root) {

    fun bind(dataBio: DataBioTable){
        //binding.Bio2TextItemView1.text = dataBio.title
        //binding.Bio2Description.text = Html.fromHtml(dataBio.description,Html.FROM_HTML_MODE_LEGACY)

        val htmltable = dataBio.table
        binding.webView.loadDataWithBaseURL(null,htmltable,"text/html", "UTF-8", null)
    }
}