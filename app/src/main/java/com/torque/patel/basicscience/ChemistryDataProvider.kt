package com.torque.patel.basicscience

import android.content.Context
import com.torque.patel.basicscience.DataItems.DataItem

// ChemistryDataProvider.kt
class ChemistryDataProvider(private val context: Context) {

    fun getChemistryData(chapterNumber: Int): MutableList<DataItem> {
        return mutableListOf<DataItem>().apply {
            when (chapterNumber) {
                0 -> addStateOfMatterChapter()
                1 -> addAtomicStructureChapter()
                2 -> addPeriodicClassificationChapter()
                4 -> addChemicalBondingChapter()
                5 -> addOxidationReductionChapter()
                6 -> addSolutionChapter()
                7 -> addAcidBaseSaltChapter()
                8 -> addBehaviourOfGasesChapter()
                9 -> addElectrolysisChapter()
                10 -> addCarbonCompoundsChapter()
                12 -> addFuelsChapter()
                13 -> addMetallurgyChapter()
                else -> add(DataItem.TextItem("No data found", "No data found"))
            }
        }
    }

    // Chapter 0: State of Matter
    private fun MutableList<DataItem>.addStateOfMatterChapter() {
        add(DataItem.TextItem("1.State of Matter", context.getString(R.string.Che1)))
        add(DataItem.ImageItem(R.drawable.matter))
        add(DataItem.TextItem("", context.getString(R.string.che3)))
        add(DataItem.ImageItem(R.drawable.state2))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che4)))
        add(DataItem.WebItem(context.getString(R.string.tableche1)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che5)))
    }

    // Chapter 1: Atomic Structure
    private fun MutableList<DataItem>.addAtomicStructureChapter() {
        add(DataItem.TextItem("2.Atomic Structure", context.getString(R.string.che6)))
        add(DataItem.ImageItem(R.drawable.atomic_mass))
        add(DataItem.TextItem("", context.getString(R.string.che7)))
        add(DataItem.ImageItem(R.drawable.alpha_particle))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che8)))
        add(DataItem.ImageItem(R.drawable.wave))
        add(DataItem.TextItem("", context.getString(R.string.che9)))
        add(DataItem.ImageItem(R.drawable.wave_number))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che10)))
        add(DataItem.TextItem("", context.getString(R.string.che11)))
        add(DataItem.ImageItem(R.drawable.prism))
        add(DataItem.TextItem("", context.getString(R.string.che11A)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.getString(R.string.tableche2)))
        add(DataItem.TextItem("", context.getString(R.string.che12)))
        add(DataItem.WebItem(context.getString(R.string.tableche3)))
        add(DataItem.TextItem("", context.getString(R.string.che13)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.getString(R.string.tableche4)))
        add(DataItem.TextItem("", context.getString(R.string.che14)))
        add(DataItem.ImageItem(R.drawable.hund_rule))
        add(DataItem.TextItem("", context.getString(R.string.che15)))
        add(DataItem.NativeAdItem)
    }

    // Chapter 2: Periodic Classification of Element
    private fun MutableList<DataItem>.addPeriodicClassificationChapter() {
        add(DataItem.TextItem("3.Periodic classification of Element", context.getString(R.string.che16)))
        add(DataItem.WebItem(context.getString(R.string.tableche5)))
        add(DataItem.ImageItem(R.drawable.atomic_mass_sodium))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che17)))
        add(DataItem.WebItem(context.getString(R.string.tableche6)))
        add(DataItem.TextItem("", context.getString(R.string.che18)))
        add(DataItem.NativeAdItem)
        add(DataItem.ImageItem(R.drawable.i_p))
        add(DataItem.TextItem("", context.getString(R.string.che19)))
        add(DataItem.ImageItem(R.drawable.e_a))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che20)))
        add(DataItem.ImageItem(R.drawable.e_a))
        add(DataItem.TextItem("", context.getString(R.string.che20A)))
        add(DataItem.NativeAdItem)
        add(DataItem.ImageItem(R.drawable.electronegativity))
    }

    // Chapter 4: Chemical Bonding
    private fun MutableList<DataItem>.addChemicalBondingChapter() {
        add(DataItem.TextItem("4.Chemical Bonding", context.getString(R.string.che21)))
        add(DataItem.ImageItem(R.drawable.mechanizm))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che22)))
        add(DataItem.ImageItem(R.drawable.covalent_bond))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che23)))
        add(DataItem.ImageItem(R.drawable.lone_pair_of_electron))
        add(DataItem.TextItem("", context.getString(R.string.che24)))
        add(DataItem.ImageItem(R.drawable.co_ordinate_bond))
        add(DataItem.TextItem("", context.getString(R.string.che25)))
        add(DataItem.ImageItem(R.drawable.pi_bond))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che26)))
        add(DataItem.WebItem(context.getString(R.string.tableche7)))
        add(DataItem.TextItem("", context.getString(R.string.che27)))
        add(DataItem.ImageItem(R.drawable.hydrogen_bond))
        add(DataItem.TextItem("", context.getString(R.string.che28)))
        add(DataItem.NativeAdItem)
        add(DataItem.ImageItem(R.drawable.intermolecule))
        add(DataItem.TextItem("", context.getString(R.string.che29)))
        add(DataItem.ImageItem(R.drawable.benzene_bonding))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che30)))
        add(DataItem.ImageItem(R.drawable.methyl_alcohol))
    }

    // Chapter 5: Oxidation & Reduction
    private fun MutableList<DataItem>.addOxidationReductionChapter() {
        add(DataItem.TextItem("5.Oxidation & Reduction", context.getString(R.string.che31)))
        add(DataItem.ImageItem(R.drawable.oxidation))
        add(DataItem.TextItem("", context.getString(R.string.che32)))
        add(DataItem.ImageItem(R.drawable.reduction_reaction))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che33)))
        add(DataItem.ImageItem(R.drawable.concept_of_oxidation_and_reduction))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che34)))
        add(DataItem.ImageItem(R.drawable.oxidising_agent))
        add(DataItem.TextItem("", context.getString(R.string.che35)))
        add(DataItem.ImageItem(R.drawable.reducing_agent))
        add(DataItem.TextItem("", context.getString(R.string.che36)))
        add(DataItem.ImageItem(R.drawable.redox_reaction))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che37)))
        add(DataItem.ImageItem(R.drawable.oxidation_no_of_hydrogen_and_oxygen))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che39)))
        add(DataItem.ImageItem(R.drawable.decomposition_reactions))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che40)))
        add(DataItem.ImageItem(R.drawable.combination_reactions))
        add(DataItem.TextItem("", context.getString(R.string.che41)))
        add(DataItem.ImageItem(R.drawable.displacement_reactions))
        add(DataItem.TextItem("", context.getString(R.string.che42)))
        add(DataItem.ImageItem(R.drawable.disproportionation_reactions))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che43)))
        add(DataItem.ImageItem(R.drawable.substitution_reaction))
        add(DataItem.TextItem("", context.getString(R.string.che44)))
        add(DataItem.ImageItem(R.drawable.neutralisation_reaction))
        add(DataItem.TextItem("", context.getString(R.string.che45)))
        add(DataItem.NativeAdItem)
        add(DataItem.ImageItem(R.drawable.reversible_reaction))
        add(DataItem.TextItem("", context.getString(R.string.che46)))
        add(DataItem.ImageItem(R.drawable.combination_reactions))
    }

    // Chapter 6: Solution
    private fun MutableList<DataItem>.addSolutionChapter() {
        add(DataItem.TextItem("6.Solution", context.getString(R.string.che47)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.getString(R.string.tableche8)))
        add(DataItem.TextItem("", context.getString(R.string.che48)))
        add(DataItem.ImageItem(R.drawable.solubility))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che49)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che50)))
        add(DataItem.ImageItem(R.drawable.sodium_solubility))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che51)))
    }

    // Chapter 7: Acid, Bases & Salt
    private fun MutableList<DataItem>.addAcidBaseSaltChapter() {
        add(DataItem.TextItem("7. Acid,Bases & Salt", context.getString(R.string.che52)))
        add(DataItem.NativeAdItem)
        add(DataItem.ImageItem(R.drawable.strength_of_acids))
        add(DataItem.ImageItem(R.drawable.classification_of_acids))
        add(DataItem.TextItem("", context.getString(R.string.che53)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che54)))
        add(DataItem.ImageItem(R.drawable.strength_of_bases))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che55)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che56)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.getString(R.string.table9)))
    }

    // Chapter 8: Behaviour of Gases
    private fun MutableList<DataItem>.addBehaviourOfGasesChapter() {
        add(DataItem.TextItem("8.Behaviour of Gases", context.getString(R.string.che57)))
        add(DataItem.TextItem("", context.getString(R.string.che58)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che59)))
        add(DataItem.TextItem("", context.getString(R.string.che60)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che61)))
        add(DataItem.ImageItem(R.drawable.grahams_law))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che62)))
    }

    // Chapter 9: Electrolysis
    private fun MutableList<DataItem>.addElectrolysisChapter() {
        add(DataItem.TextItem("9.Electrolysis", context.getString(R.string.che63)))
        add(DataItem.NativeAdItem)
        add(DataItem.ImageItem(R.drawable.cathode))
        add(DataItem.TextItem("", context.getString(R.string.che64)))
    }

    // Chapter 10: Carbon and its compounds
    private fun MutableList<DataItem>.addCarbonCompoundsChapter() {
        add(DataItem.TextItem("10.Carbon and its compounds", context.getString(R.string.che65)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.getString(R.string.tableche10)))
        add(DataItem.TextItem("", context.getString(R.string.che66)))
        add(DataItem.ImageItem(R.drawable.alkane))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che67)))
        add(DataItem.ImageItem(R.drawable.unsaturated_hydrocarbons))
        add(DataItem.TextItem("", context.getString(R.string.che68)))
        add(DataItem.ImageItem(R.drawable.aromatic_hydrocarbons))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che69)))
        add(DataItem.WebItem(context.getString(R.string.tableche11)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che70)))
        add(DataItem.NativeAdItem)
        add(DataItem.ImageItem(R.drawable.polymerisation))
        add(DataItem.TextItem("", context.getString(R.string.che71)))
        add(DataItem.ImageItem(R.drawable.natural_rubber))
        add(DataItem.TextItem("", context.getString(R.string.che72)))
        add(DataItem.NativeAdItem)
        add(DataItem.ImageItem(R.drawable.neoprene))
        add(DataItem.TextItem("", context.getString(R.string.che72A)))
        add(DataItem.ImageItem(R.drawable.thiokol_rubber))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che73)))
    }

    // Chapter 12: Fuels
    private fun MutableList<DataItem>.addFuelsChapter() {
        add(DataItem.TextItem("11.Fuels", context.getString(R.string.che74)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che75)))
        add(DataItem.ImageItem(R.drawable.water_gas))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che76)))
        add(DataItem.NativeAdItem)
        add(DataItem.ImageItem(R.drawable.lpg_and_cng))
        add(DataItem.TextItem("", context.getString(R.string.che77)))
        add(DataItem.NativeAdItem)
        add(DataItem.ImageItem(R.drawable.octane_number))
        add(DataItem.TextItem("", context.getString(R.string.che78)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.getString(R.string.table12)))
    }

    // Chapter 13: Metallurgy
    private fun MutableList<DataItem>.addMetallurgyChapter() {
        add(DataItem.TextItem("12.Metallurgy", context.getString(R.string.che79)))
        add(DataItem.ImageItem(R.drawable.acidic_flux))
        add(DataItem.TextItem("", context.getString(R.string.che80)))
        add(DataItem.ImageItem(R.drawable.basic_flux))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che81)))
        add(DataItem.ImageItem(R.drawable.slag))
        add(DataItem.TextItem("", context.getString(R.string.che82)))
        add(DataItem.NativeAdItem)
        add(DataItem.ImageItem(R.drawable.calcination))
        add(DataItem.TextItem("", context.getString(R.string.che83)))
        add(DataItem.ImageItem(R.drawable.roasting))
        add(DataItem.TextItem("", context.getString(R.string.che84)))
        add(DataItem.ImageItem(R.drawable.smelting))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che85)))
        add(DataItem.WebItem(context.getString(R.string.tableche13)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che86)))
        add(DataItem.TextItem("", context.getString(R.string.che87)))
        add(DataItem.WebItem(context.getString(R.string.tableche14)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.che88)))
    }
}