package com.torque.patel.basicscience

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.torque.patel.basicscience.DataItems.DataChapter
import com.torque.patel.basicscience.adapter.QuizMenuAdapter
import com.torque.patel.basicscience.DataItems.QuizItem

class QuizMenu : AppCompatActivity(), QuizMenuAdapter.OnItemClickListner {


    lateinit var mainViewModel: MainViewModel
    //val number:Int = 2

    private var mInterstitialAd: InterstitialAd? = null
    private final var TAG = "MainActivity"

    private var interstitialAd:String = R.string.menu_quiz_interital_ads.toString()

    private lateinit var appOpenAdManager: AppOpenAdManager




    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_menu)

        //Initialize AdMob
        //MobileAds.initialize(this)

        // Initialize App Open Ad Manager
        //appOpenAdManager = AppOpenAdManager(application)
        //appOpenAdManager.loadAd()


        val number:Int = intent.getIntExtra("number",0)


        val back_button = findViewById<ImageView>(R.id.btn_back)

        back_button.setOnClickListener {
            onBackPresseds(number)

        }






        mainViewModel = ViewModelProvider(this).get(MainViewModel::class)


        val items = mutableListOf<QuizItem>()


        // Load string arrays from resources
        val physicsTopics = resources.getStringArray(R.array.physics_topics).toList()
        val chemistryTopics = resources.getStringArray(R.array.chemistry_topics).toList()
        val biologyTopics = resources.getStringArray(R.array.biology_topics).toList()
        val botanyTopics = resources.getStringArray(R.array.botany_topics).toList()
        val zoologyTopics = resources.getStringArray(R.array.zoology_topics).toList()


        when(number){


            0 -> {
                // Physics Topics
                for (i in physicsTopics.indices) {
                    items.add(QuizItem.ListItem("${i + 1}.", physicsTopics[i]))
                    // Add ad after every 3rd, 11th, and 15th item
                    if (i == 2 || i == 10 || i == 14) {
                        items.add(QuizItem.NativeAdItem)
                    }
                }
            }

            1 -> {
                // Chemistry Topics
                for (i in chemistryTopics.indices) {
                    items.add(QuizItem.ListItem("${i + 1}.", chemistryTopics[i]))
                    // Add ad after 3rd and 10th item
                    if (i == 2 || i == 9) {
                        items.add(QuizItem.NativeAdItem)
                    }
                }
            }

            2 -> {

                // Biology Topics - General
                for (i in biologyTopics.indices) {
                    items.add(QuizItem.ListItem("${i + 1}.", biologyTopics[i]))
                    if (i == 2) {
                        items.add(QuizItem.NativeAdItem)
                    }
                }

                // Botany Section Header
                items.add(
                    QuizItem.ListItem(
                        "I.",
                        resources.getString(R.string.biology_section)
                    )
                )

                // Botany Topics
                for (i in botanyTopics.indices) {
                    items.add(QuizItem.ListItem("${i + 1}.", botanyTopics[i]))
                    if (i == 2 || i == 8) {
                        items.add(QuizItem.NativeAdItem)
                    }
                }

                // Zoology Section Header
                items.add(
                    QuizItem.ListItem(
                        "II.",
                        resources.getString(R.string.zoology_section)
                    )
                )

                // Zoology Topics
                for (i in zoologyTopics.indices) {
                    items.add(QuizItem.ListItem("${i + 1}.", zoologyTopics[i]))
                    if (i == 2) {
                        items.add(QuizItem.NativeAdItem)
                    }
                }
            }

            else -> {
                items.apply {
                    add(QuizItem.ListItem("00.","No list is Added"))
                }
            }




        }


        val recyclerView: RecyclerView = findViewById(R.id.quiz_menu_recyclerView)
        recyclerView.adapter = QuizMenuAdapter( items,this,this,number )
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        toolBar(number)

        val callback2 = object : OnBackPressedCallback(true) { // 'true' means the callback is enabled initially
            override fun handleOnBackPressed() {
                // Your custom logic to handle the back event
                // If you want the system's default behavior, disable this callback
                // and call onBackPressedDispatcher.onBackPressed()

                onBackPresseds(number)
            }
        }
        onBackPressedDispatcher.addCallback(this, callback2)

    }


    private fun onBackPresseds(num:Int){
        val intent = Intent(this, QuizDashboard::class.java)
        intent.putExtra("number", num)
        startActivity(intent)
    }


    private fun loadInterstitialAd() {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            this,
            interstitialAd, // Replace with your ad unit ID
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d(TAG, adError.toString())
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.d(TAG, "Ad was loaded.")
                    mInterstitialAd = interstitialAd
                    setFullScreenContentCallback()
                }
            }
        )
    }

    private fun setFullScreenContentCallback() {
        mInterstitialAd?.fullScreenContentCallback = object :
            FullScreenContentCallback() {
            override fun onAdDismissedFullScreenContent() {
                Log.d(TAG, "Ad was dismissed.")
                // Called when ad is dismissed.
                // Set the ad reference to null so you don't show the ad a second time.
                mInterstitialAd = null
                // Load the next ad
                loadInterstitialAd()
            }

            override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                Log.e(TAG, "Ad failed to show.")
                // Called when ad fails to show.
                mInterstitialAd = null
            }

            override fun onAdShowedFullScreenContent() {
                Log.d(TAG, "Ad showed fullscreen content.")
                // Called when ad is shown.
            }
        }
    }


    //Open Ads method
    override fun onResume() {
        super.onResume()
        //appOpenAdManager.showAdIfAvailable(this)
    }

    private fun toolBar(pos:Int){

        when(pos) {
            0 -> configureToolbar("Physics Quiz", R.drawable.ic_physics_logo, R.color.colorPrimary)
            1 -> configureToolbar("Chemistry Quiz", R.drawable.ic_chemistry_logo, R.color.colorYello)
            2 -> configureToolbar("Biology Quiz", R.drawable.ic_biology_logo, R.color.colorGreenLight)
        }

    }


    fun configureToolbar(title: String, logoRes: Int, colorRes: Int) {

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.quiz_menu_toolbar)
        //toolbar.setTitleTextColor(resources.getColor(R.color.colorWhite)) // set Title text color
        val toolbar_txt = findViewById<TextView>(R.id.toolbar_textView)
        val toolbar_img = findViewById<ImageView>(R.id.toolbar_logo_image)

        toolbar_txt.text = title
        toolbar_img.setImageResource(logoRes)
        toolbar.backgroundTintList = ContextCompat.getColorStateList(this, colorRes)
        window.statusBarColor = ContextCompat.getColor(this, colorRes)
    }



    override fun onItemClick(position: Int) {

        val number:Int = intent.getIntExtra("number",0)

        when {
            position < 21 && number == 0 -> startQuizActivity(position,number)
            position < 15 && number == 1 -> startQuizActivity(position,number)
            position < 25 && number == 2 -> startQuizActivity(position,number)
        }

    }

    fun startQuizActivity(pos:Int,num: Int){
        val intent = Intent(this, Quiz::class.java)
        intent.putExtra("question", pos)
        intent.putExtra("testSet", num)
        startActivity(intent)
        finish()
    }








}