package com.torque.patel.basicscience.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.torque.patel.basicscience.DataInline
import com.torque.patel.basicscience.R

class ChapterAdapter(
    private val context: Context,
    private val recyclerViewItems: List<DataInline>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_MENU = 1
        private const val TYPE_AD = 2
    }


    override fun getItemViewType(position: Int): Int {

        return when (recyclerViewItems[position]) {
            is DataInline.HeaderItem -> TYPE_HEADER
            is DataInline.MenuItem -> TYPE_MENU
            is DataInline.Ad -> TYPE_AD
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)

        return when (viewType) {
            TYPE_HEADER -> HeaderViewHolder(
                LayoutInflater.from(context).inflate(R.layout.card_header, parent, false)
            )

            TYPE_MENU -> MenuItemViewHolder(
                LayoutInflater.from(context).inflate(R.layout.quiz_card_view, parent, false)
            )

            TYPE_AD -> AdViewHolder(
                LayoutInflater.from(context).inflate(R.layout.banner_ad_container, parent, false)
            )

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = recyclerViewItems[position]) {
            is DataInline.HeaderItem -> bindHeader(holder as HeaderViewHolder, item)
            is DataInline.MenuItem -> bindMenu(holder as MenuItemViewHolder, item)
            is DataInline.Ad -> {
                bindAd(holder as AdViewHolder, item)
            }
        }
    }

    override fun getItemCount(): Int = recyclerViewItems.size

    private fun bindHeader(holder: HeaderViewHolder, item: DataInline.HeaderItem) {
        with(holder) {
            titleView.text = item.title
            subtitleView.text = item.subtitle
        }
    }

    private fun bindMenu(holder: MenuItemViewHolder, item: DataInline.MenuItem) {
        with(holder) {
            nameView.text = item.chapterNum
            priceView.text = item.chapterName
            // ... bind other views
        }
    }

    private fun bindAd(holder: AdViewHolder, item: DataInline.Ad) {
        with(holder.container) {
            removeAllViews()
            (item.adView.parent as? ViewGroup)?.removeView(item.adView)
            addView(item.adView)
        }
    }


    // ViewHolders
    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.tvTitle)
        val subtitleView: TextView = view.findViewById(R.id.tvSubtitle)
    }

    class MenuItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameView: TextView = view.findViewById(R.id.list_number)
        val priceView: TextView = view.findViewById(R.id.chapter_name)
        // ... other views
    }

    class AdViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val container: ViewGroup = view.findViewById(R.id.native_ad_view)
    }


}


