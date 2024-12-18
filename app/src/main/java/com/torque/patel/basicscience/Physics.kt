package com.torque.patel.basicscience

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.torque.patel.basicscience.MultiViewAdapter.Companion.FIRST_VIEW
import com.torque.patel.basicscience.MultiViewAdapter.Companion.SECOND_VIEW
import com.torque.patel.basicscience.MultiViewAdapter.Companion.THIRD_VIEW
import com.torque.patel.basicscience.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


   // private lateinit var firebaseAnalytics : FirebaseAnalytics

    private lateinit var adView: AdView
    private lateinit var adRequest: AdRequest


    private lateinit var binding:ActivityMainBinding

    private var mInterstitialAd: InterstitialAd? = null
    private val delayMillis = 1 * 60 * 1000L // 5 minutes
    private var hasAdBeenShown = false

    private final val TAG = "MainActivity"

    //val adId : String = "ca-app-pub-3940256099942544/2247696110" //this is test Ads
    //val adId : String = "ca-app-pub-8093216699203818/6642529892"






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        //firebaseAnalytics = Firebase.analytics


        initView()

       // bannerAds()



        screenRecord()

        buttonClicked()




    }



   /* private fun bannerAds(){
        MobileAds.initialize(this)
        adView = findViewById(R.id.adView)
        adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }*/






    private fun initView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.recyclerView.adapter = MultiViewAdapter(getList())

    }

   /* private fun getList(): ArrayList<DataModel> {


        var no = 1
        return when (no) {
            0 -> generateDataModels(FIRST_VIEW, "1.Unit", R.string.phy1, R.string.phy2)
            1 -> generateDataModels(FIRST_VIEW, "2.Motion", R.string.phy3, R.string.phy4, R.string.phy5, R.string.phy6, R.string.phy7, R.string.phy8, R.string.phy9)
            2 -> generateDataModels(SECOND_VIEW, "hello")//ads


            else -> arrayListOf()
        }

    }


    private fun generateDataModels(viewType:Int,title: String, vararg descriptions: Int): ArrayList<DataModel> {
        val dataModels = arrayListOf<DataModel>()

        dataModels.add(DataModel(viewType, title, resources.getString(descriptions[0])))

        for (i in 1 until descriptions.size) {
            dataModels.add(DataModel(viewType, "", resources.getString(descriptions[i])))
        }

        dataModels.add(DataModel(SECOND_VIEW, "",resources.getString(descriptions[0])))

        return dataModels
    }*/











    private fun getList():ArrayList<Any>{

        val adId = getString(R.string.phys_admob_adunit_id)

        val number:Int = intent.getIntExtra("number",0)

         return when(number){

             0 -> {
                 arrayListOf(
//1.Unit
                     DataModel(FIRST_VIEW, "1.Units", resources.getString(R.string.phy1)),
                     DataPhyTable(SECOND_VIEW, resources.getString(R.string.tablephy1)),
                     AD_ID_DATA(adId),
                     DataModel(FIRST_VIEW, "", resources.getString(R.string.phy2)),
                     DataPhyTable(SECOND_VIEW, resources.getString(R.string.tablephy2)),
                     AD_ID_DATA(adId),
                     DataPhyTable(SECOND_VIEW, resources.getString(R.string.tablephy3)),
                     DataPhyTable(SECOND_VIEW, resources.getString(R.string.tablephy4)),
                     AD_ID_DATA(adId),
                 )
             }

            1 -> {
                arrayListOf(
//2.Motion
                    DataModel(FIRST_VIEW, "2.Motion", resources.getString(R.string.phy3)),
                    imageData(THIRD_VIEW, R.drawable.speed),
                    DataModel(FIRST_VIEW, "", resources.getString(R.string.phy4)),
                    imageData(THIRD_VIEW, R.drawable.velocity),
                    AD_ID_DATA(adId),
                    DataModel(FIRST_VIEW, "", resources.getString(R.string.phy5)),
                    imageData(THIRD_VIEW, R.drawable.acceletation),
                    DataModel(FIRST_VIEW, "", resources.getString(R.string.phy6)),
                    imageData(THIRD_VIEW, R.drawable.angular_velocity),
                    AD_ID_DATA(adId),
                    DataModel(FIRST_VIEW, "", resources.getString(R.string.phy7)),
                    imageData(THIRD_VIEW, R.drawable.one_revolution_o),
                    DataModel(FIRST_VIEW, "", resources.getString(R.string.phy8)),
                    imageData(THIRD_VIEW, R.drawable.force),
                    AD_ID_DATA(adId),
                    DataModel(FIRST_VIEW, "", resources.getString(R.string.phy9)),
                )
            }

            2 -> {
                arrayListOf(
//3.Work,Energy and Power
                    DataModel(FIRST_VIEW, "3.Work,Energy and Power", resources.getString(R.string.phy10)),
                    DataPhyTable(SECOND_VIEW, resources.getString(R.string.tablephy5)),
                    AD_ID_DATA(adId),
                    DataModel(FIRST_VIEW, "", resources.getString(R.string.phy11)),
                    imageData(THIRD_VIEW, R.drawable.kinetic_energy),
                    AD_ID_DATA(adId),
                    DataModel(FIRST_VIEW, "", resources.getString(R.string.phy12)),

                    )
            }
            3 -> {
                arrayListOf(
//4.Gravitation
                    DataModel(FIRST_VIEW, "4.Gravitation", resources.getString(R.string.phy13)),
                    imageData(THIRD_VIEW, R.drawable.gravitation),
                    AD_ID_DATA(adId),
                    DataModel(FIRST_VIEW, "", resources.getString(R.string.phy14)),
                    imageData(THIRD_VIEW, R.drawable.kepler_law),
                    AD_ID_DATA(adId),
                    DataModel(FIRST_VIEW, "", resources.getString(R.string.phy15)),
                    imageData(THIRD_VIEW, R.drawable.period_of_revolution),
                    AD_ID_DATA(adId),
                    DataModel(FIRST_VIEW, "", resources.getString(R.string.phy16)),
                    imageData(THIRD_VIEW, R.drawable.orbital_velocity),
                    AD_ID_DATA(adId),


                    )
            }
            5 -> {
                arrayListOf(
//5.Pressure
                    DataModel(FIRST_VIEW, "5.Pressure", resources.getString(R.string.phy17)),
                    imageData(THIRD_VIEW, R.drawable.pressure_p),
                    AD_ID_DATA(adId),
                    DataModel(FIRST_VIEW, "", resources.getString(R.string.phy18)),
                )
            }
            6 -> {
                arrayListOf(
//6.Floatation
                    DataModel(FIRST_VIEW, "6.Floatation", resources.getString(R.string.phy19)),
                    imageData(THIRD_VIEW, R.drawable.density),
                    AD_ID_DATA(adId),
                    DataModel(FIRST_VIEW, "", resources.getString(R.string.phy20)),
                )
            }
            7-> {
                arrayListOf(
                    DataModel(FIRST_VIEW,"7.Surface Tension",resources.getString(R.string.phy21)),
                    AD_ID_DATA(adId),
                )
            }
            8 -> {
                arrayListOf(
                    DataModel(FIRST_VIEW,"8.Viscosity",resources.getString(R.string.phy22)),
                            AD_ID_DATA(adId),
                )
            }
            9 -> {
                arrayListOf(
                    DataModel(FIRST_VIEW,"9.Elasticity",resources.getString(R.string.phy23)),
                    imageData(THIRD_VIEW,R.drawable.hook_law),
                    AD_ID_DATA(adId),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy24)),
                    imageData(THIRD_VIEW,R.drawable.elastic_constant),
                    AD_ID_DATA(adId),
                )
            }
            11 -> {
                arrayListOf(
                    DataModel(FIRST_VIEW,"10.Simple Harmonic Motion",resources.getString(R.string.phy25)),
                    imageData(THIRD_VIEW,R.drawable.simple_pendulum),
                    AD_ID_DATA(adId),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy26)),
                )
            }
            12 -> {
                arrayListOf(
                    DataModel(FIRST_VIEW,"11.Wave",resources.getString(R.string.phy27)),//table not ready
                    AD_ID_DATA(adId),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy28)),

                    )
            }
            13 -> {
                arrayListOf(
                    DataModel(FIRST_VIEW,"12.Sound Wave",resources.getString(R.string.phy29)),
                    imageData(THIRD_VIEW,R.drawable.speed_of_sound),
                    AD_ID_DATA(adId),
                    DataPhyTable(SECOND_VIEW,resources.getString(R.string.tablephy6)),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy30)),
                    AD_ID_DATA(adId),
                    imageData(THIRD_VIEW,R.drawable.ampltude),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy31)),
                )
            }
            14 -> {
                arrayListOf(
                    DataModel(FIRST_VIEW,"13.Heat",resources.getString(R.string.phy32)),
                    imageData(THIRD_VIEW,R.drawable.temperature_scale),
                    AD_ID_DATA(adId),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy33)),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy35)),
                    AD_ID_DATA(adId),
                    imageData(THIRD_VIEW,R.drawable.e_t_e_p_t),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy36)),
                    AD_ID_DATA(adId),
                    imageData(THIRD_VIEW,R.drawable.change_of_states),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy37)),
                    AD_ID_DATA(adId),
                    imageData(THIRD_VIEW,R.drawable.carnot_engine),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy38)),
                )
            }
            15 -> {
                arrayListOf(
                    DataModel(FIRST_VIEW,"14.Light",resources.getString(R.string.phy39)),
                    imageData(THIRD_VIEW,R.drawable.refactive_index),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy40)),
                    AD_ID_DATA(adId),
                    DataPhyTable(SECOND_VIEW,resources.getString(R.string.tablephy7)),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy41)),
                    DataPhyTable(SECOND_VIEW,resources.getString(R.string.tablephy8)),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy42)),
                    AD_ID_DATA(adId),
                    imageData(THIRD_VIEW,R.drawable.snells_law),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy43)),
                    imageData(THIRD_VIEW,R.drawable.absolute_refractive_index),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy43A)),
                    AD_ID_DATA(adId),
                    imageData(THIRD_VIEW,R.drawable.convex_and_concave_lens),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy43B)),
                    DataPhyTable(SECOND_VIEW,resources.getString(R.string.tablephy10)),
                    AD_ID_DATA(adId),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy44)),
                    imageData(THIRD_VIEW,R.drawable.magenta),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy45)),
                    imageData(THIRD_VIEW,R.drawable.primary_color),
                    AD_ID_DATA(adId),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy46)),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy47)),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy48)),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy49)),
                )
            }
            16 -> {
                arrayListOf(
                    DataModel(FIRST_VIEW,"15.Static Electricity",resources.getString(R.string.phy50)),
                    DataPhyTable(SECOND_VIEW,resources.getString(R.string.tablephy11)),
                    AD_ID_DATA(adId),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy51)),
                )
            }
            18 -> {
                arrayListOf(
                    DataModel(FIRST_VIEW,"16.Curent Electricity",resources.getString(R.string.phy53)),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy54)),
                    AD_ID_DATA(adId),
                    imageData(THIRD_VIEW,R.drawable.conductance),
                    imageData(THIRD_VIEW,R.drawable.denoted_g),
                    AD_ID_DATA(adId),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy55)),
                    imageData(THIRD_VIEW,R.drawable.resistance),
                    AD_ID_DATA(adId),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy56)),
                    imageData(THIRD_VIEW,R.drawable.paralled_combination),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy57)),
                    AD_ID_DATA(adId),
                    imageData(THIRD_VIEW,R.drawable.electric_power),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy58)),
                )
            }
            19 -> {
                arrayListOf(
                    DataModel(FIRST_VIEW,"17.Magnetism",resources.getString(R.string.phy59)),
                    AD_ID_DATA(adId),

                    )
            }
            20 -> {
                arrayListOf(
                    DataModel(FIRST_VIEW,"18.Atomic & Nuclear Physics",resources.getString(R.string.phy60)),
                    DataPhyTable(SECOND_VIEW,resources.getString(R.string.tablephy12)),
                    AD_ID_DATA(adId),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy69)),
                    DataPhyTable(SECOND_VIEW,resources.getString(R.string.tablephy13)),
                    AD_ID_DATA(adId),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy61)),
                    DataPhyTable(SECOND_VIEW,resources.getString(R.string.tablephy14)),
                    AD_ID_DATA(adId),
                    DataPhyTable(SECOND_VIEW,resources.getString(R.string.tablephy15)),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy62)),
                    AD_ID_DATA(adId),
                    imageData(THIRD_VIEW,R.drawable.nuclear_fusion),
                    DataModel(FIRST_VIEW,"",resources.getString(R.string.phy63)),
                )
            }
             21 -> {
                 arrayListOf(
                     DataModel(FIRST_VIEW,"19.Electronics",resources.getString(R.string.phy64)),
                     AD_ID_DATA(adId),


                     )



             }



             else -> arrayListOf(
                 DataModel(FIRST_VIEW,"Data Not Found",resources.getString(R.string.phy64)),
            )










                /*else -> return arrayListOf(
                               DataModel(FIRST_VIEW,"Data Not Found",resources.getString(R.string.phy64)),*/







         }











    }

    private fun screenRecord(){

        val screenName = "Physics Screen"

        /*firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW){
            param(FirebaseAnalytics.Param.SCREEN_NAME,screenName)
            param(FirebaseAnalytics.Param.SCREEN_CLASS,"MainActivity")
        }*/
    }

    private fun buttonClicked(){

       /* firebaseAnalytics.logEvent("Clicked Event"){
            param("button_one", "Clicked_one")

        }*/
    }



    


}