package com.torque.patel.basicscience

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.WindowMetrics
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.torque.patel.basicscience.adapter.ChapterAdapter

class Chapter_Menu : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private val adapterItems = mutableListOf<DataInline>()

    companion object {
        private const val ITEMS_PER_AD = 8
        private const val TEST_AD_UNIT_ID = "ca-app-pub-3940256099942544/6300978111"
        const val TEST_DEVICE_HASHED_ID = "ABCDEF012345"
    }




    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_menu)

        // Set your test devices.
       MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder().setTestDeviceIds(listOf(TEST_DEVICE_HASHED_ID)).build()
        )

        /*CoroutineScope(Dispatchers.IO).launch {
            // Initialize the Google Mobile Ads SDK on a background thread.
            MobileAds.initialize(this@Chapter_Menu) {}
        }*/


        // Initialize Mobile Ads SDK
        MobileAds.initialize(this) {}

        setupRecyclerView()
        loadData()


    }



    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.chapter_menu)
        recyclerView.setHasFixedSize(false)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter: RecyclerView.Adapter<RecyclerView.ViewHolder> = ChapterAdapter(this, adapterItems)
        recyclerView.adapter = adapter

    }

    private fun loadData() {
        // Create sample data
        val items = mutableListOf<DataInline>().apply {
            // Add header
            add(DataInline.HeaderItem("Our Restaurant", "Today's Special Menu"))

            // Add menu items with ads
            for (i in 0..20) {
                if (i % ITEMS_PER_AD == 0 && i != 0) {
                    add(DataInline.Ad(createAdView()))
                }

                add(DataInline.MenuItem("${i}.","Introduction to Physics"))

            }

            // Add footer header
            add(DataInline.HeaderItem("Special Offers", "Check our daily discounts"))
        }

        adapterItems.clear()
        adapterItems.addAll(items)
        recyclerView.adapter?.notifyDataSetChanged()
    }



    // Determine the screen width to use for the ad width.
    private val adWidth: Int
        get() {
            val displayMetrics = resources.displayMetrics
            val adWidthPixels =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    val windowMetrics: WindowMetrics = this.windowManager.currentWindowMetrics
                    windowMetrics.bounds.width()
                } else {
                    displayMetrics.widthPixels
                }
            val density = displayMetrics.density
            return (adWidthPixels / density).toInt()
        }

    private fun createAdView(): AdView {
        return AdView(this).apply {

            setAdSize(AdSize.getCurrentOrientationInlineAdaptiveBannerAdSize(this@Chapter_Menu,adWidth))
            //setAdSize(AdSize.getInlineAdaptiveBannerAdSize(300,250))
            adUnitId = TEST_AD_UNIT_ID
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            adListener = object : AdListener() {
                override fun onAdFailedToLoad(error: LoadAdError) {
                    Toast.makeText(this@Chapter_Menu, "Ad Failed: ${error.message}", Toast.LENGTH_SHORT).show()
                    Log.e("AdError", "Error code: ${error.code}")
                    Log.e("AdError", "Error message: ${error.message}")
                    Log.e("AdError", "Error domain: ${error.domain}")
                    error.cause?.let {
                        Log.e("AdError", "Cause : ${it.message}")
                    }
                }
            }
            loadAd(AdRequest.Builder().build())
        }
    }


    override fun onResume() {
        super.onResume()
        adapterItems.filterIsInstance<DataInline.Ad>().forEach { it.adView.resume() }
    }

    override fun onPause() {
        super.onPause()
        adapterItems.filterIsInstance<DataInline.Ad>().forEach { it.adView.pause() }
    }

    override fun onDestroy() {
        super.onDestroy()
        adapterItems.filterIsInstance<DataInline.Ad>().forEach { it.adView.destroy() }
    }
}