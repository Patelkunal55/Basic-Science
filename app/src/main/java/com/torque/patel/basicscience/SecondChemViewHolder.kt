package com.torque.patel.basicscience

import androidx.recyclerview.widget.RecyclerView
import com.torque.patel.basicscience.databinding.SecondChemViewBinding

class SecondChemViewHolder(private val binding: SecondChemViewBinding):RecyclerView.ViewHolder(binding.root) {

    fun bind(dataChem: DataChemTable){
        val htmltable = dataChem.table
        binding.webViewChem.loadDataWithBaseURL(null,htmltable,"text/html","UTF-8", null)

    }
}