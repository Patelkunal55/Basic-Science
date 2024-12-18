package com.torque.patel.basicscience

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.torque.patel.basicscience.ChemViewAdapter.Companion.FIRST_VIEW
import com.torque.patel.basicscience.ChemViewAdapter.Companion.SECOND_VIEW
import com.torque.patel.basicscience.ChemViewAdapter.Companion.THIRD_VIEW
import com.torque.patel.basicscience.databinding.ActivityChemistryBinding
import com.torque.patel.basicscience.databinding.ActivityMainBinding



private lateinit var binding:ActivityChemistryBinding

class Chemistry: AppCompatActivity(), OnItemClickListners {
    private lateinit var adView: AdView
    private lateinit var adRequest: AdRequest

    private var mInterstitialAd: InterstitialAd? = null
    private final val TAG = "MainActivity"


    //val adId : String = "ca-app-pub-3940256099942544/2247696110"  // this a tes Ads
    //val adId : String = "ca-app-pub-8093216699203818/2833873200"

    //val adId = context.applicationContext.getString(R.string.chem_admob_adunit_id)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChemistryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

       // bannerAds()





    }


   /* private fun bannerAds(){
        MobileAds.initialize(this)
        adView = findViewById(R.id.chem_adView)
        adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }*/






    private fun initView(){
        binding.chemRecyclerView.layoutManager = LinearLayoutManager(this@Chemistry)
        binding.chemRecyclerView.adapter = ChemViewAdapter(getList(),this)
    }

    private fun getList():ArrayList<Any>{
        val adId = getString(R.string.chem_admob_adunit_id)

        //val no:Int = 0
        val number:Int = intent.getIntExtra("number",0)

        when(number){
            0 -> return arrayListOf(
                DataChem(FIRST_VIEW,"1.State of Matter",resources.getString(R.string.Che1)),
                DataCheModel(THIRD_VIEW,R.drawable.matter),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che3)),
                DataCheModel(THIRD_VIEW,R.drawable.state2),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che4)),
                DataChemTable(SECOND_VIEW,resources.getString(R.string.tableche1)),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che5)),
            )

            1 -> return arrayListOf(
                DataChem(FIRST_VIEW,"2.Atomic Structure",resources.getString(R.string.che6)),
                DataCheModel(THIRD_VIEW,R.drawable.atomic_mass),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che7)),
                DataCheModel(THIRD_VIEW,R.drawable.alpha_particle),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che8)),
                DataCheModel(THIRD_VIEW,R.drawable.wave),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che9)),
                DataCheModel(THIRD_VIEW,R.drawable.wave_number),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che10)),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che11)),
                DataCheModel(THIRD_VIEW,R.drawable.prism),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che11A)),
                AD_ID_DATA(adId),
                DataChemTable(SECOND_VIEW,resources.getString(R.string.tableche2)),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che12)),
                DataChemTable(SECOND_VIEW,resources.getString(R.string.tableche3)),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che13)),
                AD_ID_DATA(adId),
                DataChemTable(SECOND_VIEW,resources.getString(R.string.tableche4)),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che14)),
                DataCheModel(THIRD_VIEW,R.drawable.hund_rule),
                DataChem(FIRST_VIEW,"", resources.getString(R.string.che15)),
                AD_ID_DATA(adId),
            )

            2 -> return arrayListOf(
                DataChem(FIRST_VIEW,"3.Periodic classification of Element",resources.getString(R.string.che16)),
                DataChemTable(SECOND_VIEW,resources.getString(R.string.tableche5)),
                DataCheModel(THIRD_VIEW,R.drawable.atomic_mass_sodium),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che17)),
                DataChemTable(SECOND_VIEW,resources.getString(R.string.tableche6)),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che18)),
                AD_ID_DATA(adId),
                DataCheModel(THIRD_VIEW,R.drawable.i_p),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che19)),
                DataCheModel(THIRD_VIEW,R.drawable.e_a),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che20)),
                DataCheModel(THIRD_VIEW,R.drawable.e_a),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che20A)),
                AD_ID_DATA(adId),
                DataCheModel(THIRD_VIEW,R.drawable.electronegativity),
            )

            3 -> return arrayListOf(
                DataChem(FIRST_VIEW,"4.Chemical Bonding",resources.getString(R.string.che21)),
                DataCheModel(THIRD_VIEW,R.drawable.mechanizm),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che22)),
                DataCheModel(THIRD_VIEW,R.drawable.covalent_bond),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che23)),
                DataCheModel(THIRD_VIEW,R.drawable.lone_pair_of_electron),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che24)),
                DataCheModel(THIRD_VIEW,R.drawable.co_ordinate_bond),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che25)),
                DataCheModel(THIRD_VIEW,R.drawable.pi_bond),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che26)),
                DataChemTable(SECOND_VIEW,resources.getString(R.string.tableche7)),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che27)),
                DataCheModel(THIRD_VIEW,R.drawable.hydrogen_bond),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che28)),
                AD_ID_DATA(adId),
                DataCheModel(THIRD_VIEW,R.drawable.intermolecule),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che29)),
                DataCheModel(THIRD_VIEW,R.drawable.benzene_bonding),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che30)),
                DataCheModel(THIRD_VIEW,R.drawable.methyl_alcohol),
            )

            5 -> return arrayListOf(
                DataChem(FIRST_VIEW,"5.Oxidation & Reduction",resources.getString(R.string.che31)),
                DataCheModel(THIRD_VIEW,R.drawable.oxidation),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che32)),
                DataCheModel(THIRD_VIEW,R.drawable.reduction_reaction),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che33)),
                DataCheModel(THIRD_VIEW,R.drawable.concept_of_oxidation_and_reduction),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che34)),
                DataCheModel(THIRD_VIEW,R.drawable.oxidising_agent),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che35)),
                DataCheModel(THIRD_VIEW,R.drawable.reducing_agent),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che36)),
                DataCheModel(THIRD_VIEW,R.drawable.redox_reaction),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che37)),
                DataCheModel(THIRD_VIEW,R.drawable.oxidation_no_of_hydrogen_and_oxygen),
                //DataChem(FIRST_VIEW,"",resources.getString(R.string.che38)),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che39)),
                DataCheModel(THIRD_VIEW,R.drawable.decomposition_reactions),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che40)),
                DataCheModel(THIRD_VIEW,R.drawable.combination_reactions),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che41)),
                DataCheModel(THIRD_VIEW,R.drawable.displacement_reactions),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che42)),
                DataCheModel(THIRD_VIEW,R.drawable.disproportionation_reactions),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che43)),
                DataCheModel(THIRD_VIEW,R.drawable.substitution_reaction),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che44)),
                DataCheModel(THIRD_VIEW,R.drawable.neutralisation_reaction),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che45)),
                AD_ID_DATA(adId),
                DataCheModel(THIRD_VIEW,R.drawable.reversible_reaction),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che46)),
                DataCheModel(THIRD_VIEW,R.drawable.combination_reactions),

            )

             6-> return arrayListOf(
                DataChem(FIRST_VIEW,"6.Solution",resources.getString(R.string.che47)),
                 AD_ID_DATA(adId),
                DataChemTable(SECOND_VIEW,resources.getString(R.string.tableche8)),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che48)),
                DataCheModel(THIRD_VIEW,R.drawable.solubility),
                 AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che49)),
                 AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che50)),
                DataCheModel(THIRD_VIEW,R.drawable.sodium_solubility),
                 AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che51)),

            )

            7 -> return arrayListOf(
                DataChem(FIRST_VIEW,"7.Acid,Bases & Salt",resources.getString(R.string.che52)),
                AD_ID_DATA(adId),
                DataCheModel(THIRD_VIEW,R.drawable.strength_of_acids),
                DataCheModel(THIRD_VIEW,R.drawable.classification_of_acids),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che53)),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che54)),
                DataCheModel(THIRD_VIEW,R.drawable.strength_of_bases),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che55)),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che56)),
                AD_ID_DATA(adId),
                DataChemTable(SECOND_VIEW,resources.getString(R.string.tableche9)),

                )

            8 -> return arrayListOf(
                DataChem(FIRST_VIEW,"8.Behaviour of Gases",resources.getString(R.string.che57)),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che58)),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che59)),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che60)),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che61)),
                DataCheModel(THIRD_VIEW,R.drawable.grahams_law),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che62)),


                )

            10 -> return arrayListOf(
                DataChem(FIRST_VIEW,"9.Electrolysis",resources.getString(R.string.che63)),
                AD_ID_DATA(adId),
                DataCheModel(THIRD_VIEW,R.drawable.cathode),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che64)),
                )

            11 -> return arrayListOf(
                DataChem(FIRST_VIEW,"10.Carbon and its compounds",resources.getString(R.string.che65)),
                AD_ID_DATA(adId),
                DataChemTable(SECOND_VIEW,resources.getString(R.string.tableche10)),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che66)),
                DataCheModel(THIRD_VIEW,R.drawable.alkane),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che67)),
                DataCheModel(THIRD_VIEW,R.drawable.unsaturated_hydrocarbons),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che68)),
                DataCheModel(THIRD_VIEW,R.drawable.aromatic_hydrocarbons),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che69)),
                DataChemTable(SECOND_VIEW,resources.getString(R.string.tableche11)),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che70)),
                AD_ID_DATA(adId),
                DataCheModel(THIRD_VIEW,R.drawable.polymerisation),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che71)),
                DataCheModel(THIRD_VIEW,R.drawable.natural_rubber),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che72)),
                DataCheModel(THIRD_VIEW,R.drawable.neoprene),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che72A)),
                DataCheModel(THIRD_VIEW,R.drawable.thiokol_rubber),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che73)),
            )

            12 -> return arrayListOf(
                DataChem(FIRST_VIEW,"11.Fuels",resources.getString(R.string.che74)),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che75)),
                DataCheModel(THIRD_VIEW,R.drawable.water_gas),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che76)),
                AD_ID_DATA(adId),
                DataCheModel(THIRD_VIEW,R.drawable.lpg_and_cng),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che77)),
                AD_ID_DATA(adId),
                DataCheModel(THIRD_VIEW,R.drawable.octane_number),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che78)),
                AD_ID_DATA(adId),
                DataChemTable(SECOND_VIEW,resources.getString(R.string.tableche12)),

            )

            13 -> return arrayListOf(
                DataChem(FIRST_VIEW,"12.Metallurgy",resources.getString(R.string.che79)),
                DataCheModel(THIRD_VIEW,R.drawable.acidic_flux),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che80)),
                DataCheModel(THIRD_VIEW,R.drawable.basic_flux),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che81)),
                DataCheModel(THIRD_VIEW,R.drawable.slag),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che82)),
                AD_ID_DATA(adId),
                DataCheModel(THIRD_VIEW,R.drawable.calcination),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che83)),
                DataCheModel(THIRD_VIEW,R.drawable.roasting),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che84)),
                DataCheModel(THIRD_VIEW,R.drawable.smelting),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che85)),
                DataChemTable(SECOND_VIEW,resources.getString(R.string.tableche13)),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che86)),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che87)),
                DataChemTable(SECOND_VIEW,resources.getString(R.string.tableche14)),
                AD_ID_DATA(adId),
                DataChem(FIRST_VIEW,"",resources.getString(R.string.che88)),


                )


            else -> return arrayListOf(
                DataChem(FIRST_VIEW,"Not data Found","Not data found")
            )
        }




    }

    override fun OnItemClicks(position: Int) {

    }
}