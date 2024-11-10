package com.torque.patel.basicscience

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.torque.patel.basicscience.BioViewAdapter.Companion.FIRST_VIEW
import com.torque.patel.basicscience.BioViewAdapter.Companion.SECOND_VIEW
import com.torque.patel.basicscience.BioViewAdapter.Companion.THIRD_VIEW
import com.torque.patel.basicscience.databinding.ActivityBiologyBinding

class Biology : AppCompatActivity() {


    private lateinit var adView: AdView
    private lateinit var adRequest: AdRequest

    private var mInterstitialAd: InterstitialAd? = null
    private final val TAG = "MainActivity"

    //val adId : String = "ca-app-pub-3940256099942544/2247696110"  // this a tes Ads
    //val adId : String = "ca-app-pub-8093216699203818/5369403488"

    private lateinit var binding: ActivityBiologyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBiologyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

        //bannerAds()




    }

    private fun initView(){
        binding.bioRecyclerView.layoutManager = LinearLayoutManager(this@Biology)
        binding.bioRecyclerView.adapter = BioViewAdapter(getList())
    }


   /* private fun bannerAds(){
        MobileAds.initialize(this)
        adView = findViewById(R.id.bio_adView)
        adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }*/







    private fun getList(): ArrayList<Any> {

        val adId = getString(R.string.bio_admob_adunit_id)

        //val no:Int = 1
        val number:Int = intent.getIntExtra("biology",0)
        //Toast.makeText(this,"Get Number $number",Toast.LENGTH_SHORT).show()

        when(number){

            0 -> return arrayListOf(
                DataBio(FIRST_VIEW,"1. Introduction to Biology ",resources.getString(R.string.bio1)),
                AD_ID_DATA(adId),
                )

            1 -> return arrayListOf(
                DataBio(FIRST_VIEW,"2. Classification of Organism",resources.getString(R.string.bio2)),
                AD_ID_DATA(adId),
                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio3)),

                )

            2 -> return arrayListOf(//3.Study of Cell Cytology
                DataBio(FIRST_VIEW,"3. Study of Cell",resources.getString(R.string.bio4)),
                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio5)),
                AD_ID_DATA(adId),
                DataBioTable(SECOND_VIEW,resources.getString(R.string.table1)),
                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio6)),///entre remain data
                DataBioTable(SECOND_VIEW,resources.getString(R.string.table2)),
                AD_ID_DATA(adId),
                DataBioTable(SECOND_VIEW,resources.getString(R.string.table3)),


                )

            3 -> return arrayListOf(//4.Genetics
                DataBio(FIRST_VIEW,"4.Genetics",resources.getString(R.string.bio7)),
                DataBioModel(THIRD_VIEW,R.drawable.monohybrid_cross),
                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio8)),
                DataBioModel(THIRD_VIEW,R.drawable.description),
                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio9)),

                )

            5 -> return arrayListOf(//5.Sex Determination in Human
                DataBio(FIRST_VIEW,"5.Sex Determination in Human",resources.getString(R.string.bio10)),
                DataBioModel(THIRD_VIEW,R.drawable.sex_determination_in_human),
                AD_ID_DATA(adId),
                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio11)),
                AD_ID_DATA(adId),
                DataBioTable(SECOND_VIEW,resources.getString(R.string.table4)),

                )
            6 -> return arrayListOf(//6.Organic Evolution
                DataBio(FIRST_VIEW,"6.Organic Evolution",resources.getString(R.string.bio12)),
                AD_ID_DATA(adId),
                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio8)),

                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio9)),
                AD_ID_DATA(adId),
                )
            7 -> return arrayListOf(//Biology
                DataBio(FIRST_VIEW,"Biology",resources.getString(R.string.bio63)),
                AD_ID_DATA(adId),




                )
            8 -> return arrayListOf(//1.Classification of Plantae
                DataBio(FIRST_VIEW,"1.Classification of Plantae",resources.getString(R.string.bio13)),
                DataBioModel(THIRD_VIEW,R.drawable.plant_kingdoms),
                AD_ID_DATA(adId),
                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio14)),
                AD_ID_DATA(adId),
                DataBioTable(SECOND_VIEW,resources.getString(R.string.table5)),
                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio15)),
                DataBioTable(SECOND_VIEW,resources.getString(R.string.table6)),
                AD_ID_DATA(adId),
                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio16)),
                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio17)),
                AD_ID_DATA(adId),

                )
            10 -> return arrayListOf(//2.Plant Morphology
                DataBio(FIRST_VIEW,"2.Plant Morphology",resources.getString(R.string.bio18)),
                AD_ID_DATA(adId),
                DataBioTable(SECOND_VIEW,resources.getString(R.string.table7)),
                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio19)),
                        AD_ID_DATA(adId),

                )

            11 -> return arrayListOf(//3.Plant Tissue
                DataBio(FIRST_VIEW,"3.Plant Tissue",resources.getString(R.string.bio20)),
                DataBioModel(THIRD_VIEW,R.drawable.plant_kingdoms),
                AD_ID_DATA(adId),
                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio21)),
                AD_ID_DATA(adId),


            )
            12 -> return arrayListOf(//4.Photosynthesis
                DataBio(FIRST_VIEW,"4.Photosynthesis",resources.getString(R.string.bio22)),
                AD_ID_DATA(adId),
                DataBioModel(THIRD_VIEW,R.drawable.reaction),


        )
            13 -> return arrayListOf(//5. Plant Hormones
                DataBio(FIRST_VIEW,"5. Plant Hormones",resources.getString(R.string.bio23)),
                AD_ID_DATA(adId),

                )
            15 -> return arrayListOf(//6. Plant Diseases
                DataBio(FIRST_VIEW,"6. Plant Diseases",resources.getString(R.string.bio24)),
                AD_ID_DATA(adId),
                DataBioTable(SECOND_VIEW,resources.getString(R.string.table8)),
                AD_ID_DATA(adId),
                DataBioTable(SECOND_VIEW,resources.getString(R.string.table9)),


                )

            16 -> return arrayListOf(//7. Ecology
                DataBio(FIRST_VIEW,"7. Ecology",resources.getString(R.string.bio25)),
                AD_ID_DATA(adId),

                )
            17 -> return arrayListOf(//8. Nitrogen cycle
            DataBio(FIRST_VIEW,"8. Nitrogen cycle",resources.getString(R.string.bio26)),
                AD_ID_DATA(adId),

            )
            18 -> return arrayListOf(//9. Pollution
            DataBio(FIRST_VIEW,"9. Pollution",resources.getString(R.string.bio27)),
                AD_ID_DATA(adId),

            )
            20 -> return arrayListOf(//ZOOLOGY
            DataBio(FIRST_VIEW,"ZOOLOGY",resources.getString(R.string.bio28)),
                AD_ID_DATA(adId),

            )

            21 -> return arrayListOf(//1. Classification of Animal Kingdom
                DataBio(FIRST_VIEW,"1. Classification of Animal Kingdom",resources.getString(R.string.bio29)),
                AD_ID_DATA(adId),

                )
            22 -> return arrayListOf(//2. Animal Tissue
                DataBio(FIRST_VIEW,"2.Animal Tissue",resources.getString(R.string.bio30)),
                AD_ID_DATA(adId),

                )
            23 -> return arrayListOf(//3. Human Blood
                DataBio(FIRST_VIEW,"3.Human Blood",resources.getString(R.string.bio31)),
                AD_ID_DATA(adId),
                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio32)),
                AD_ID_DATA(adId),
                DataBioTable(SECOND_VIEW,resources.getString(R.string.table10)),
                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio33)),
                AD_ID_DATA(adId),
                DataBioTable(SECOND_VIEW,resources.getString(R.string.table11)),

                )
            25 -> return arrayListOf(//4. System of the Human Body
                DataBio(FIRST_VIEW,"4. System of the Human Body",resources.getString(R.string.bio34)),
                AD_ID_DATA(adId),
                DataBioTable(SECOND_VIEW,resources.getString(R.string.table12)),
                AD_ID_DATA(adId),
                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio35)),
                AD_ID_DATA(adId),
                DataBioTable(SECOND_VIEW,resources.getString(R.string.table13)),
                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio36)),
                AD_ID_DATA(adId),
                DataBioModel(THIRD_VIEW,R.drawable.brain),
                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio37)),
                AD_ID_DATA(adId),
                DataBioTable(SECOND_VIEW,resources.getString(R.string.table14)),
                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio38)),
                AD_ID_DATA(adId),

                )
            26 -> return arrayListOf(//5. Nutrients
                DataBio(FIRST_VIEW,"5. Nutrients",resources.getString(R.string.bio39)),
                AD_ID_DATA(adId),
                DataBioTable(SECOND_VIEW,resources.getString(R.string.table15)),
                AD_ID_DATA(adId),
                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio40)),
                AD_ID_DATA(adId),
                DataBioTable(SECOND_VIEW,resources.getString(R.string.table16)),
                AD_ID_DATA(adId),
                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio41)),
                AD_ID_DATA(adId),
                DataBioTable(SECOND_VIEW,resources.getString(R.string.table17)),
                DataBioTable(SECOND_VIEW,resources.getString(R.string.table18)),

                )
            27 -> return arrayListOf(//6. Human Diseases
                DataBio(FIRST_VIEW,"6. Human Diseases",resources.getString(R.string.bio42)),
                AD_ID_DATA(adId),
                DataBio(FIRST_VIEW,"",resources.getString(R.string.bio43)),

                )

            28 -> return arrayListOf(//5. Plant Hormones
                AD_ID_DATA(adId),
                DataBio(FIRST_VIEW,"5. Plant Hormones",resources.getString(R.string.bio23)),

                )





            else -> return arrayListOf(
                DataBio(FIRST_VIEW,"No data found","No data found"),
            )

        }


    }
}