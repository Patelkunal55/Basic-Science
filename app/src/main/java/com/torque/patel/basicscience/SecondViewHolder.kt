package com.torque.patel.basicscience

import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.torque.patel.basicscience.databinding.ItemView2Binding

class SecondViewHolder(private val binding: ItemView2Binding):RecyclerView.ViewHolder(binding.root) {

    fun bind(dataTable: DataPhyTable){




        val htmltable = dataTable.table

        //binding.webViewphys.loadData(htmltable,"text/html", "UTF-8")
        binding.webViewphys.loadDataWithBaseURL(null,htmltable,"text/html", "UTF-8",null)


    }
}