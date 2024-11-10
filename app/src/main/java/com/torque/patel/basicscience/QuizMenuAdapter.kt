package com.torque.patel.basicscience

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdView

class QuizMenuAdapter(private val list:MutableList<QuizItem>, private val itemClickListener: OnItemClickListner,private val context: Context):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    companion object {
            const val VIEW_TYPE_TEXT = 0
            const val VIEW_TYPE_AD = 3
        }

    override fun getItemViewType(position: Int): Int {
        return when(list[position]){

            is QuizItem.ListItem -> VIEW_TYPE_TEXT
            is QuizItem.NativeAdItem -> VIEW_TYPE_AD

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
        return when (viewType){

            VIEW_TYPE_TEXT -> QuizMenuViewHolder(inflater.inflate(R.layout.quiz_card_view,parent,false))
            VIEW_TYPE_AD -> AdViewHolder(inflater.inflate(R.layout.item_native_ad, parent, false))
            else -> throw IllegalArgumentException("Invalid view type")

        }
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val lists = list[position]){

            is QuizItem.ListItem -> (holder as QuizMenuViewHolder).bind(
                lists,
                chapterNam = lists

            )

            QuizItem.NativeAdItem -> (holder as AdViewHolder).bind()
        }
    }

    override fun getItemCount(): Int = list.size


    inner class QuizMenuViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    ,View.OnClickListener{
        private val chapterNumber : TextView = itemView.findViewById(R.id.list_number)
        private val chapterName : TextView = itemView.findViewById(R.id.chapter_name)
        fun bind(chapterNum:QuizItem.ListItem,chapterNam:QuizItem.ListItem){
            chapterNumber.text = chapterNum.chapNumber
            chapterName.text = chapterNam.chapName
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = bindingAdapterPosition

            if (position !=RecyclerView.NO_POSITION){
                itemClickListener.onItemClick(position)
            }
        }

    }
    inner class AdViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val adView: NativeAdView = view.findViewById(R.id.phy_nativeAdView)
        fun bind() {
            adView.visibility = View.GONE
            val adLoader = AdLoader.Builder(context, context.getString(R.string.phys_admob_adunit_id))
                .forNativeAd { nativeAd: NativeAd ->
                    populateNativeAdView(nativeAd, adView)
                    // Make the adView visible after loading
                    adView.visibility = View.VISIBLE
                }
                .build()
            adLoader.loadAd(AdRequest.Builder().build())
        }

        private fun populateNativeAdView(nativeAd: NativeAd, adView: NativeAdView) {

            // Headline
            adView.findViewById<TextView>(R.id.ad_headline)?.let {
                if (nativeAd.headline !== null){
                    it.text = nativeAd.headline
                    it.visibility = View.VISIBLE
                    adView.headlineView = it
                }else{
                    it.visibility = View.GONE
                }

            }

            // Body
            adView.findViewById<TextView>(R.id.ad_body)?.let {
                if (nativeAd.body !== null){
                    it.text = nativeAd.body
                    it.visibility = View.VISIBLE
                    adView.bodyView = it
                }else {
                    it.visibility = View.GONE
                }

            }

            // Call to action
            adView.findViewById<Button>(R.id.ad_call_to_action)?.let {
                if (nativeAd.callToAction !== null) {
                    it.text = nativeAd.callToAction
                    it.visibility = View.VISIBLE
                    adView.callToActionView = it
                } else {
                    it.visibility = View.GONE
                }

            }

            // Icon
            adView.findViewById<ImageView>(R.id.ad_icon)?.let {
                if (nativeAd.icon != null) {
                    it.setImageDrawable(nativeAd.icon?.drawable)
                    it.visibility = View.VISIBLE
                    adView.iconView = it
                } else {
                    it.visibility = View.GONE
                }
            }



            // Advertiser
            adView.findViewById<TextView>(R.id.ad_advertiser)?.let {
                if (nativeAd.advertiser != null) {
                    it.text = nativeAd.advertiser
                    it.visibility = View.VISIBLE
                    adView.advertiserView = it
                } else {
                    it.visibility = View.GONE
                }
            }

            adView.setNativeAd(nativeAd)
            // Implement this function to populate adView with nativeAd data.
        }


    }

    interface OnItemClickListner {
        fun onItemClick(position: Int)
    }
}