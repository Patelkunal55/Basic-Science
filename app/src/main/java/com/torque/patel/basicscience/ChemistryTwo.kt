package com.torque.patel.basicscience

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.add
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChemistryTwo : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chemistry_two)

        val recyclerView:RecyclerView = findViewById(R.id.chemtwo_recyclerView)

        val items = mutableListOf<DataItem>().apply {
            val number:Int = intent.getIntExtra("number",0)
            val nu:Int = 1

            when(number){

                    0 -> {
                        add(DataItem.TextItem("1.State of Matter",resources.getString(R.string.Che1)))
                        add(DataItem.ImageItem(R.drawable.matter))
                        add(DataItem.TextItem("",resources.getString(R.string.che3)))
                        add(DataItem.ImageItem(R.drawable.state2))
                        add(DataItem.NativeAdItem)
                        add(DataItem.TextItem("",resources.getString(R.string.che4)))
                        add(DataItem.WebItem(resources.getString(R.string.tableche1)))
                        add(DataItem.NativeAdItem)
                        add(DataItem.TextItem("",resources.getString(R.string.che5)))
                    }

                1 -> {
                    add(DataItem.TextItem("2.Atomic Structure",resources.getString(R.string.che6)))
                    add(DataItem.ImageItem(R.drawable.atomic_mass))
                    add(DataItem.TextItem("",resources.getString(R.string.che7)))
                    add(DataItem.ImageItem(R.drawable.alpha_particle))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("",resources.getString(R.string.che8)))
                    add(DataItem.ImageItem(R.drawable.wave))
                    add(DataItem.TextItem("",resources.getString(R.string.che9)))
                    add(DataItem.ImageItem(R.drawable.wave_number))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("",resources.getString(R.string.che10)))
                    add(DataItem.TextItem("",resources.getString(R.string.che11)))
                    add(DataItem.ImageItem(R.drawable.prism))
                    add(DataItem.TextItem("", resources.getString(R.string.che11A)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.WebItem(resources.getString(R.string.tableche2)))
                    add(DataItem.TextItem("",resources.getString(R.string.che12)))
                    add(DataItem.WebItem(resources.getString(R.string.tableche3)))
                    add(DataItem.TextItem("",resources.getString(R.string.che13)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.WebItem(resources.getString(R.string.tableche4)))
                    add(DataItem.TextItem("",resources.getString(R.string.che14)))
                    add(DataItem.ImageItem(R.drawable.hund_rule))
                    add(DataItem.TextItem("", resources.getString(R.string.che15)))
                    add(DataItem.NativeAdItem)
                }

                2 -> {

                    add(DataItem.TextItem("3.Periodic classification of Element",resources.getString(R.string.che16)))
                    add(DataItem.WebItem(resources.getString(R.string.tableche5)))
                    add(DataItem.ImageItem(R.drawable.atomic_mass_sodium))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("",resources.getString(R.string.che17)))
                    add(DataItem.WebItem(resources.getString(R.string.tableche6)))
                    add(DataItem.TextItem("",resources.getString(R.string.che18)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.ImageItem(R.drawable.i_p))
                    add(DataItem.TextItem("",resources.getString(R.string.che19)))
                    add(DataItem.ImageItem(R.drawable.e_a))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("",resources.getString(R.string.che20)))
                    add(DataItem.ImageItem(R.drawable.e_a))
                    add(DataItem.TextItem("",resources.getString(R.string.che20A)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.ImageItem(R.drawable.electronegativity))

                }

                3 -> {
                    add(DataItem.TextItem("4.Chemical Bonding",resources.getString(R.string.che21)))
                    add(DataItem.ImageItem(R.drawable.mechanizm))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("",resources.getString(R.string.che22)))
                    add(DataItem.ImageItem(R.drawable.covalent_bond))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("",resources.getString(R.string.che23)))
                    add(DataItem.ImageItem(R.drawable.lone_pair_of_electron))
                    add(DataItem.TextItem("",resources.getString(R.string.che24)))
                    add(DataItem.ImageItem(R.drawable.co_ordinate_bond))
                    add(DataItem.TextItem("",resources.getString(R.string.che25)))
                    add(DataItem.ImageItem(R.drawable.pi_bond))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("",resources.getString(R.string.che26)))
                    add(DataItem.WebItem(resources.getString(R.string.tableche7)))
                    add(DataItem.TextItem("",resources.getString(R.string.che27)))
                    add(DataItem.ImageItem(R.drawable.hydrogen_bond))
                    add(DataItem.TextItem("",resources.getString(R.string.che28)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.ImageItem(R.drawable.intermolecule))
                    add(DataItem.TextItem("",resources.getString(R.string.che29)))
                    add(DataItem.ImageItem(R.drawable.benzene_bonding))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("",resources.getString(R.string.che30)))
                    add(DataItem.ImageItem(R.drawable.methyl_alcohol))



                }

                5 -> {
                    add(DataItem.TextItem("5.Oxidation & Reduction",resources.getString(R.string.che31)))
                    add(DataItem.ImageItem(R.drawable.oxidation))
                    add(DataItem.TextItem("",resources.getString(R.string.che32)))
                    add(DataItem.ImageItem(R.drawable.reduction_reaction))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("",resources.getString(R.string.che33)))
                    add(DataItem.ImageItem(R.drawable.concept_of_oxidation_and_reduction))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("",resources.getString(R.string.che34)))
                    add(DataItem.ImageItem(R.drawable.oxidising_agent))
                    add(DataItem.TextItem("",resources.getString(R.string.che35)))
                    add(DataItem.ImageItem(R.drawable.reducing_agent))
                    add(DataItem.TextItem("",resources.getString(R.string.che36)))
                    add(DataItem.ImageItem(R.drawable.redox_reaction))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("",resources.getString(R.string.che37)))
                    add(DataItem.ImageItem(R.drawable.oxidation_no_of_hydrogen_and_oxygen))
                    //add(DataItem.TextItem("",resources.getString(R.string.che38)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("",resources.getString(R.string.che39)))
                    add(DataItem.ImageItem(R.drawable.decomposition_reactions))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("",resources.getString(R.string.che40)))
                    add(DataItem.ImageItem(R.drawable.combination_reactions))
                    add(DataItem.TextItem("",resources.getString(R.string.che41)))
                    add(DataItem.ImageItem(R.drawable.displacement_reactions))
                    add(DataItem.TextItem("",resources.getString(R.string.che42)))
                    add(DataItem.ImageItem(R.drawable.disproportionation_reactions))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("",resources.getString(R.string.che43)))
                    add(DataItem.ImageItem(R.drawable.substitution_reaction))
                    add(DataItem.TextItem("",resources.getString(R.string.che44)))
                    add(DataItem.ImageItem(R.drawable.neutralisation_reaction))
                    add(DataItem.TextItem("",resources.getString(R.string.che45)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.ImageItem(R.drawable.reversible_reaction))
                    add(DataItem.TextItem("",resources.getString(R.string.che46)))
                    add(DataItem.ImageItem(R.drawable.combination_reactions))
                }

                6 -> {
                    add(DataItem.TextItem("6 Solution",resources.getString(R.string.che47)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.WebItem(resources.getString(R.string.tableche8)))
                    add(DataItem.TextItem("",resources.getString(R.string.che48)))
                    add(DataItem.ImageItem(R.drawable.solubility))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("",resources.getString(R.string.che49)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("",resources.getString(R.string.che50)))
                    add(DataItem.ImageItem(R.drawable.sodium_solubility))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("",resources.getString(R.string.che51)))


                }

                7 -> {
                    add(DataItem.TextItem("7. Acid,Bases & Salt",resources.getString(R.string.che52)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.ImageItem(R.drawable.strength_of_acids))
                    add(DataItem.ImageItem(R.drawable.classification_of_acids))
                    add(DataItem.TextItem("",resources.getString(R.string.che53)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("",resources.getString(R.string.che54)))
                    add(DataItem.ImageItem(R.drawable.strength_of_bases))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("",resources.getString(R.string.che55)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("",resources.getString(R.string.che56)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.WebItem(resources.getString(R.string.table9)))

                }

                8-> {
                    add(DataItem.TextItem("8.Behaviour of Gases", resources.getString(R.string.che57)))
                    add(DataItem.TextItem("", resources.getString(R.string.che58))) // Handle empty title
                    add(DataItem.NativeAdItem) // Assuming you have DataItem.AdItem
                    add(DataItem.TextItem("", resources.getString(R.string.che59)))
                    add(DataItem.TextItem("", resources.getString(R.string.che60)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.che61)))
                    add(DataItem.ImageItem(R.drawable.grahams_law))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.che62)))
                }

                10-> {
                    add(DataItem.TextItem("9.Electrolysis", resources.getString(R.string.che63)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.ImageItem( R.drawable.cathode))
                    add(DataItem.TextItem("", resources.getString(R.string.che64)))

                }

                11 -> {
                    add(DataItem.TextItem("10.Carbon and its compounds", resources.getString(R.string.che65)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.WebItem( resources.getString(R.string.tableche10)))
                    add(DataItem.TextItem("", resources.getString(R.string.che66)))
                    add(DataItem.ImageItem(R.drawable.alkane))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.che67)))
                    add(DataItem.ImageItem(R.drawable.unsaturated_hydrocarbons))
                    add(DataItem.TextItem("", resources.getString(R.string.che68)))
                    add(DataItem.ImageItem(R.drawable.aromatic_hydrocarbons))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.che69)))
                    add(DataItem.WebItem(resources.getString(R.string.tableche11)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.che70)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.ImageItem(R.drawable.polymerisation))
                    add(DataItem.TextItem("", resources.getString(R.string.che71)))
                    add(DataItem.ImageItem(R.drawable.natural_rubber))
                    add(DataItem.TextItem("", resources.getString(R.string.che72)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.ImageItem(R.drawable.neoprene))
                    add(DataItem.TextItem("", resources.getString(R.string.che72A)))
                    add(DataItem.ImageItem(R.drawable.thiokol_rubber))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.che73)))

                }

                12 -> {
                    add(DataItem.TextItem("11.Fuels", resources.getString(R.string.che74)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.che75)))
                    add(DataItem.ImageItem(R.drawable.water_gas))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.che76)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.ImageItem(R.drawable.lpg_and_cng))
                    add(DataItem.TextItem("", resources.getString(R.string.che77)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.ImageItem(R.drawable.octane_number))
                    add(DataItem.TextItem("", resources.getString(R.string.che78)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.WebItem(resources.getString(R.string.table12)))


                }

                13 -> {
                    add(DataItem.TextItem("12.Metallurgy", resources.getString(R.string.che79)))
                    add(DataItem.ImageItem(R.drawable.acidic_flux))
                    add(DataItem.TextItem("", resources.getString(R.string.che80)))
                    add(DataItem.ImageItem(R.drawable.basic_flux))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.che81)))
                    add(DataItem.ImageItem(R.drawable.slag))
                    add(DataItem.TextItem("", resources.getString(R.string.che82)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.ImageItem(R.drawable.calcination))
                    add(DataItem.TextItem("", resources.getString(R.string.che83)))
                    add(DataItem.ImageItem(R.drawable.roasting))
                    add(DataItem.TextItem("", resources.getString(R.string.che84)))
                    add(DataItem.ImageItem(R.drawable.smelting))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.che85)))
                    add(DataItem.WebItem(resources.getString(R.string.tableche13)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.che86)))
                    add(DataItem.TextItem("", resources.getString(R.string.che87)))
                    add(DataItem.WebItem(resources.getString(R.string.tableche14)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.che88)))


                }


            }


            repeat(20) { index ->
                //add(DataItem.TextItem("Text $index",resources.getString(R.string.phy1)))

                //if (index % 5 == 0) add(0,DataItem.NativeAdItem)
            }




        }

        recyclerView.adapter = ChemAdapter(this,items)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}