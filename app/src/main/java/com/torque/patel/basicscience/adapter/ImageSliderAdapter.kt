package com.torque.patel.basicscience.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.torque.patel.basicscience.R

class ImageSliderAdapter(private val images: List<Int>, private val texts: List<String>) :
    RecyclerView.Adapter<ImageSliderAdapter.SliderViewHolder>() {

    class SliderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageSlide)
        val textView: TextView = view.findViewById(R.id.textSlide)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.slide_item, parent, false)
        return SliderViewHolder(view)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int
    ) {
        holder.imageView.setImageResource(images[position])
        holder.textView.text = texts[position]
    }

    override fun getItemCount() = images.size


}
