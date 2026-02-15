package com.torque.patel.basicscience.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdView
import com.torque.patel.basicscience.DataItems.DataChapter
import com.torque.patel.basicscience.DataItems.ExampleItem
import com.torque.patel.basicscience.R

class MainAdapter(private val context: Context,
                  private var lists: MutableList<DataChapter>,
                  private val itemClickListner: OnItemClickListner,
                  val number:Int

): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_TEXT = 0
        const val VIEW_TYPE_AD = 1
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
        return when(viewType){
            VIEW_TYPE_TEXT -> MainViewHolder(inflater.inflate(R.layout.card_main_chapter,parent,false))
            VIEW_TYPE_AD -> AdViewHolder(inflater.inflate(R.layout.item_native_ad, parent, false))
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }


    override fun getItemViewType(position: Int): Int {
        return when(lists[position]){
            is DataChapter.ChapterItem -> VIEW_TYPE_TEXT
            is DataChapter.NativeItems -> VIEW_TYPE_AD

            else -> throw IllegalArgumentException("Invalid item type")

        }
    }

    fun filterList(filteredList: ArrayList<DataChapter>) {
        this.lists = filteredList
        notifyDataSetChanged() // Ye list ko refresh kar dega
    }




    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(val lists = lists[position]){

            is DataChapter.ChapterItem -> (holder as MainViewHolder).bind(
                lists,
                chapterNam = lists

            )
            DataChapter.NativeItems -> (holder as AdViewHolder).bind()
        }
    }

    override fun getItemCount(): Int = lists.size


    inner class MainViewHolder(itemView: View):RecyclerView.ViewHolder(itemView),View.OnClickListener{

        fun bind(chapterNum: DataChapter.ChapterItem, chapterNam: DataChapter.ChapterItem){
            val mNumberText = itemView.findViewById<TextView>(R.id.numberText)
            val mChapterText = itemView.findViewById<TextView>(R.id.chapterText)

            val mFrameLayout = itemView.findViewById<FrameLayout>(R.id.mFrameLayout)

            when(number){
                0 -> mFrameLayout.setBackgroundResource(R.color.colorBlue)
                1 -> mFrameLayout.setBackgroundResource(R.color.colorYello)
                2 -> mFrameLayout.setBackgroundResource(R.color.colorGreenLight)
            }

            mNumberText.text = chapterNum.chapterNumber
            mChapterText.text = chapterNam.chapterName
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = bindingAdapterPosition

            if (position !=RecyclerView.NO_POSITION){
                itemClickListner.onItemClick(position)
            }
        }


    }


    inner class AdViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        private val adView: NativeAdView = view.findViewById(R.id.phy_nativeAdView)
        private val adLinearLayout: LinearLayout = view.findViewById(R.id.ad_linear_layout)

        fun bind() {
            //adView.visibility = View.GONE
            //adLinearLayout.visibility = View.GONE
            val adLoader = AdLoader.Builder(context, context.getString(R.string.chap_admob_adunit_id))
                .forNativeAd { nativeAd: NativeAd ->
                    populateNativeAdView(nativeAd, adView)
                    // Make the adView visible after loading
                    adView.visibility = View.VISIBLE
                    adLinearLayout.visibility = View.VISIBLE
                }

                .build()
            adLoader.loadAd(AdRequest.Builder().build())
        }

        private fun populateNativeAdView(nativeAd: NativeAd, adView: NativeAdView) {



            // Headline
            adView.findViewById<TextView>(R.id.ad_headline)?.let {
                if (nativeAd.headline !== null){
                    it.text = nativeAd.headline
                    //it.visibility = View.VISIBLE
                    adView.headlineView = it
                }else{
                    //it.visibility = View.GONE
                }

            }

            // Body
            adView.findViewById<TextView>(R.id.ad_body)?.let {
                if (nativeAd.body !== null){
                    it.text = nativeAd.body
                    //it.visibility = View.VISIBLE
                    adView.bodyView = it
                }else {
                    //it.visibility = View.GONE
                }

            }

            // Call to action
            adView.findViewById<Button>(R.id.ad_call_to_action)?.let {
                if (nativeAd.callToAction !== null) {
                    it.text = nativeAd.callToAction
                    //it.visibility = View.VISIBLE
                    adView.callToActionView = it
                } else {
                    // it.visibility = View.GONE
                }

            }

            // Icon
            adView.findViewById<ImageView>(R.id.ad_icon)?.let {
                if (nativeAd.icon != null) {
                    it.setImageDrawable(nativeAd.icon?.drawable)
                    //it.visibility = View.VISIBLE
                    adView.iconView = it
                } else {
                    //it.visibility = View.GONE
                }
            }



            // Advertiser
            adView.findViewById<TextView>(R.id.ad_advertiser)?.let {
                if (nativeAd.advertiser != null) {
                    it.text = nativeAd.advertiser
                    //it.visibility = View.VISIBLE
                    adView.advertiserView = it
                } else {
                    //it.visibility = View.GONE
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