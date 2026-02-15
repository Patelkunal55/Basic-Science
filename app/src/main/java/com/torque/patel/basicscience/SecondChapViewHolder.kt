package com.torque.patel.basicscience

import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions
import com.google.android.gms.ads.nativead.NativeAdView
import com.torque.patel.basicscience.databinding.SecondChap2Binding
import com.torque.patel.basicscience.DataItems.DataChap

class SecondChapViewHolder(private val binding: SecondChap2Binding):RecyclerView.ViewHolder(binding.root) {
    //private lateinit var adLoader: AdLoader

    val appId = itemView.context.getString(R.string.chap_admob_adunit_id)

    val adUnitId = itemView.context.getString(R.string.chap_admob_adunit_id)


    fun bind(dataChap: DataChap){
        val frameLayout: FrameLayout = itemView.findViewById(R.id.small_templates_frame)


        val nativeAdOptions = NativeAdOptions.Builder()
            .setAdChoicesPlacement(NativeAdOptions.ADCHOICES_BOTTOM_RIGHT)
            .build()

        //var adLoader = AdLoader.Builder(itemView.context, "ca-app-pub-3940256099942544~3347511713")//this is test app Id
        var adLoader = AdLoader.Builder(itemView.context,appId)
            .withNativeAdOptions(nativeAdOptions)
            .build()


        //adLoader = AdLoader.Builder(itemView.context,"ca-app-pub-3940256099942544/2247696110")//this is test Ad unit
        adLoader = AdLoader.Builder(itemView.context,adUnitId)
            .forNativeAd { ad: NativeAd ->





                if (adLoader.isLoading) {


                    // The AdLoader is still loading ads.
                    // Expect more adLoaded or onAdFailedToLoad callbacks.
                } else {
                    // The AdLoader has finished loading ads.

                    //val inflater = parent.applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

                    //val adView = inflater.inflate(R.layout.ad_unified,null) as NativeAdView
                    val adView = LayoutInflater.from(itemView.context).inflate(R.layout.small_templates,null) as NativeAdView

                    //val adView = layoutInflater.inflate(R.layout.small_template,null) as NativeAdView

                    frameLayout.removeAllViews()
                    frameLayout.addView(adView)
                    populateNativeAdView(ad,adView)



                }





            }
            .withAdListener(object : AdListener(){
                override fun onAdFailedToLoad(p0: LoadAdError) {


                }

            })
            .withNativeAdOptions(NativeAdOptions.Builder().build())

            .build()


        adLoader.loadAds(AdRequest.Builder().build(),3)




    }


    private fun populateNativeAdView(nativeAd: NativeAd, nativeAdView: NativeAdView) {
        val adHeadline = nativeAdView.findViewById<TextView>(R.id.primary)
        val adIcon = nativeAdView.findViewById<ImageView>(R.id.icon)
        val adNotification = nativeAdView.findViewById<TextView>(R.id.ad_notification_view)
        val adStar = nativeAdView.findViewById<RatingBar>(R.id.rating_bar)
        val callToAction = nativeAdView.findViewById<Button>(R.id.cta)


        nativeAdView.headlineView = adHeadline
        nativeAdView.iconView = adIcon
        nativeAdView.starRatingView = adStar
        nativeAdView.callToActionView = callToAction


        adHeadline.text = nativeAd.headline


        if (nativeAd.icon == null){
            adIcon.visibility = View.GONE
        }else {
            adIcon.setImageDrawable(nativeAd.icon?.drawable)
            adIcon.visibility = View.VISIBLE
        }

        if (nativeAd.starRating == null){
            adStar.visibility = View.INVISIBLE
        }else {
            adStar.rating = nativeAd.starRating!!.toFloat()
            adStar.visibility = View.VISIBLE
        }


        if (nativeAd.callToAction == null){
            callToAction.visibility = View.INVISIBLE

        }else {
            callToAction.visibility = View.VISIBLE
            callToAction.text = nativeAd.callToAction
        }


        nativeAdView.setNativeAd(nativeAd)






    }



}