package com.torque.patel.basicscience.adapter

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdView
import com.torque.patel.basicscience.DataItems.DataItem
import com.torque.patel.basicscience.R

class PhyAdapter (private val context: Context,
                  private val items: List<DataItem>
):RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object {
        const val VIEW_TYPE_TEXT = 0
        const val VIEW_TYPE_IMAGE = 1
        const val VIEW_TYPE_WEB = 2
        const val VIEW_TYPE_AD = 3
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is DataItem.TextItem -> VIEW_TYPE_TEXT
            is DataItem.ImageItem -> VIEW_TYPE_IMAGE
            is DataItem.WebItem -> VIEW_TYPE_WEB
            is DataItem.NativeAdItem -> VIEW_TYPE_AD
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
        return when (viewType) {
            VIEW_TYPE_TEXT -> TextViewHolder(inflater.inflate(R.layout.item_phy, parent, false))
                VIEW_TYPE_IMAGE -> ImageViewHolder(inflater.inflate(R.layout.item_phy_image, parent, false))
                VIEW_TYPE_WEB -> WebViewHolder(inflater.inflate(R.layout.item_phy_webview, parent, false))
                VIEW_TYPE_AD -> AdViewHolder(inflater.inflate(R.layout.item_native_ad, parent, false))
                else -> throw IllegalArgumentException("Invalid view type")
        }
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is DataItem.TextItem -> (holder as TextViewHolder).bind(
                item,
                itemTitle = item
            )
            is DataItem.ImageItem -> (holder as ImageViewHolder).bind(item)
            is DataItem.WebItem -> (holder as WebViewHolder).bind(item)
            is DataItem.NativeAdItem -> (holder as AdViewHolder).bind()
        }
    }

    override fun getItemCount(): Int = items.size


    // ViewHolder for TextView
    inner class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textViewTitle : TextView = view.findViewById(R.id.phy_title)
        private val textView: TextView = view.findViewById(R.id.phy_description)
        fun bind(item: DataItem.TextItem, itemTitle: DataItem.TextItem) {
            textViewTitle.text = itemTitle.textTitle
            textView.text = Html.fromHtml(item.text)
        }
    }

    // ViewHolder for ImageView
    inner class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView: ImageView = view.findViewById(R.id.phy_image)
        fun bind(item: DataItem.ImageItem) {
            imageView.setImageResource(item.imageResId)
        }
    }

    // ViewHolder for WebView
    inner class WebViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val webView: WebView = view.findViewById(R.id.webViewphys)
        fun bind(item: DataItem.WebItem) {
            webView.webViewClient = WebViewClient()
            webView.loadDataWithBaseURL(null,item.url,"text/html","UTF-8",null)
            //webView.loadUrl(item.url)
        }
    }

    // ViewHolder for Native Ads
    inner class AdViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val adView: NativeAdView = view.findViewById(R.id.phy_nativeAdView)
        private val adLinearLayout: LinearLayout = view.findViewById(R.id.ad_linear_layout)
        fun bind() {
            adView.visibility = View.GONE
            val adLoader = AdLoader.Builder(context, context.getString(R.string.phys_admob_adunit_id))
                .forNativeAd { nativeAd: NativeAd ->
                    populateNativeAdView(nativeAd, adView)
                    // Make the adView visible after loading
                    adLinearLayout.visibility = View.VISIBLE
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


}