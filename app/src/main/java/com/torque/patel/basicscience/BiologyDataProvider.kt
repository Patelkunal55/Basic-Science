package com.torque.patel.basicscience

import android.content.Context
import com.torque.patel.basicscience.DataItems.DataItem

// BiologyDataProvider.kt
class BiologyDataProvider(private val context: Context) {

    fun getBiologyData(chapterNumber: Int): MutableList<DataItem> {
        return mutableListOf<DataItem>().apply {
            when (chapterNumber) {
                0 -> addIntroductionChapter()
                1 -> addClassificationChapter()
                2 -> addCellStudyChapter()
                4 -> addGeneticsChapter()
                5 -> addSexDeterminationChapter()
                6 -> addOrganicEvolutionChapter()
                7 -> addBiologyOverviewChapter()
                8 -> addPlantClassificationChapter()
                9 -> addPlantMorphologyChapter()
                10 -> addPlantTissueChapter()
                12 -> addPhotosynthesisChapter()
                13 -> addPlantHormonesChapter()
                14 -> addPlantDiseaseChapter()
                15 -> addEcologyChapter()
                16 -> addNitrogenCycleChapter()
                17 -> addPollutionChapter()
                19 -> addZoologyOverviewChapter()
                20 -> addAnimalClassificationChapter()
                21 -> addAnimalTissueChapter()
                22 -> addHumanBloodChapter()
                24 -> addHumanBodySystemChapter()
                25 -> addNutrientsChapter()
                26 -> addHumanDiseasesChapter()
                else -> add(DataItem.TextItem("No data found", "No data found"))
            }
        }
    }

    // Chapter 0: Introduction to Biology
    private fun MutableList<DataItem>.addIntroductionChapter() {
        add(DataItem.TextItem("1. Introduction to Biology", context.getString(R.string.bio1)))
        add(DataItem.NativeAdItem)
    }

    // Chapter 1: Classification of Organism
    private fun MutableList<DataItem>.addClassificationChapter() {
        add(DataItem.TextItem("2. Classification of Organism", context.getString(R.string.bio2)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.bio3)))
    }

    // Chapter 2: Study of Cell
    private fun MutableList<DataItem>.addCellStudyChapter() {
        add(DataItem.TextItem("3. Study of Cell", context.getString(R.string.bio4)))
        add(DataItem.TextItem("", context.getString(R.string.bio5)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.getString(R.string.table1)))
        add(DataItem.TextItem("", context.getString(R.string.bio6)))
        add(DataItem.WebItem(context.getString(R.string.table2)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.getString(R.string.table3)))
    }

    // Chapter 4: Genetics
    private fun MutableList<DataItem>.addGeneticsChapter() {
        add(DataItem.TextItem("4. Genetics", context.getString(R.string.bio7)))
        add(DataItem.ImageItem(R.drawable.monohybrid_cross))
        add(DataItem.TextItem("", context.getString(R.string.bio8)))
        add(DataItem.ImageItem(R.drawable.description))
        add(DataItem.TextItem("", context.getString(R.string.bio9)))
    }

    // Chapter 5: Sex Determination in Human
    private fun MutableList<DataItem>.addSexDeterminationChapter() {
        add(DataItem.TextItem("5. Sex Determination in Human", context.getString(R.string.bio10)))
        add(DataItem.ImageItem(R.drawable.sex_determination_in_human))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.bio11)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.getString(R.string.table4)))
    }

    // Chapter 6: Organic Evolution
    private fun MutableList<DataItem>.addOrganicEvolutionChapter() {
        add(DataItem.TextItem("6. Organic Evolution", context.getString(R.string.bio12)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.bio8)))
        add(DataItem.TextItem("", context.getString(R.string.bio9)))
        add(DataItem.NativeAdItem)
    }

    // Chapter 7: Biology Overview
    private fun MutableList<DataItem>.addBiologyOverviewChapter() {
        add(DataItem.TextItem("Biology", context.getString(R.string.bio63)))
        add(DataItem.NativeAdItem)
    }

    // Chapter 8: Classification of Plantae
    private fun MutableList<DataItem>.addPlantClassificationChapter() {
        add(DataItem.TextItem("1. Classification of Plantae", context.getString(R.string.bio13)))
        add(DataItem.ImageItem(R.drawable.plant_kingdoms))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.bio14)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.getString(R.string.table5)))
        add(DataItem.TextItem("", context.getString(R.string.bio15)))
        add(DataItem.WebItem(context.getString(R.string.table6)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.bio16)))
        add(DataItem.TextItem("", context.getString(R.string.bio17)))
        add(DataItem.NativeAdItem)
    }

    // Chapter 9: Plant Morphology
    private fun MutableList<DataItem>.addPlantMorphologyChapter() {
        add(DataItem.TextItem("2. Plant Morphology", context.getString(R.string.bio18)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.getString(R.string.table7)))
        add(DataItem.TextItem("", context.getString(R.string.bio19)))
        add(DataItem.NativeAdItem)
    }

    // Chapter 10: Plant Tissue
    private fun MutableList<DataItem>.addPlantTissueChapter() {
        add(DataItem.TextItem("3. Plant Tissue", context.getString(R.string.bio20)))
        add(DataItem.ImageItem(R.drawable.plant_kingdoms))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.bio21)))
        add(DataItem.NativeAdItem)
    }

    // Chapter 12: Photosynthesis
    private fun MutableList<DataItem>.addPhotosynthesisChapter() {
        add(DataItem.TextItem("4. Photosynthesis", context.getString(R.string.bio22)))
        add(DataItem.NativeAdItem)
        add(DataItem.ImageItem(R.drawable.reaction))
    }

    // Chapter 13: Plant Hormones
    private fun MutableList<DataItem>.addPlantHormonesChapter() {
        add(DataItem.TextItem("5. Plant Hormones", context.getString(R.string.bio23)))
        add(DataItem.NativeAdItem)
    }

    // Chapter 14: Plant Disease
    private fun MutableList<DataItem>.addPlantDiseaseChapter() {
        add(DataItem.TextItem("6. Plant Disease", context.getString(R.string.bio24)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.getString(R.string.table8)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.getString(R.string.table9)))
    }

    // Chapter 15: Ecology
    private fun MutableList<DataItem>.addEcologyChapter() {
        add(DataItem.TextItem("7. Ecology", context.getString(R.string.bio25)))
        add(DataItem.NativeAdItem)
    }

    // Chapter 16: Nitrogen Cycle
    private fun MutableList<DataItem>.addNitrogenCycleChapter() {
        add(DataItem.TextItem("8. Nitrogen cycle", context.getString(R.string.bio26)))
        add(DataItem.NativeAdItem)
    }

    // Chapter 17: Pollution
    private fun MutableList<DataItem>.addPollutionChapter() {
        add(DataItem.TextItem("9. Pollution", context.getString(R.string.bio27)))
        add(DataItem.NativeAdItem)
    }

    // Chapter 19: Zoology Overview
    private fun MutableList<DataItem>.addZoologyOverviewChapter() {
        add(DataItem.TextItem("ZOOLOGY", context.getString(R.string.bio28)))
        add(DataItem.NativeAdItem)
    }

    // Chapter 20: Classification of Animal Kingdom
    private fun MutableList<DataItem>.addAnimalClassificationChapter() {
        add(DataItem.TextItem("1. Classification of Animal Kingdom", context.getString(R.string.bio29)))
        add(DataItem.NativeAdItem)
    }

    // Chapter 21: Animal Tissue
    private fun MutableList<DataItem>.addAnimalTissueChapter() {
        add(DataItem.TextItem("2. Animal Tissue", context.getString(R.string.bio30)))
        add(DataItem.NativeAdItem)
    }

    // Chapter 22: Human Blood
    private fun MutableList<DataItem>.addHumanBloodChapter() {
        add(DataItem.TextItem("3. Human Blood", context.getString(R.string.bio31)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.bio32)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.getString(R.string.table10)))
        add(DataItem.TextItem("", context.getString(R.string.bio33)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.getString(R.string.table11)))
    }

    // Chapter 24: System of the Human Body
    private fun MutableList<DataItem>.addHumanBodySystemChapter() {
        add(DataItem.TextItem("4. System of the Human Body", context.getString(R.string.bio34)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.getString(R.string.table12)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.bio35)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.getString(R.string.table13)))
        add(DataItem.TextItem("", context.getString(R.string.bio36)))
        add(DataItem.NativeAdItem)
        add(DataItem.ImageItem(R.drawable.brain))
        add(DataItem.TextItem("", context.getString(R.string.bio37)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.getString(R.string.table14)))
        add(DataItem.TextItem("", context.getString(R.string.bio38)))
        add(DataItem.NativeAdItem)
    }

    // Chapter 25: Nutrients
    private fun MutableList<DataItem>.addNutrientsChapter() {
        add(DataItem.TextItem("5. Nutrients", context.getString(R.string.bio39)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.getString(R.string.table15)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.bio40)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.getString(R.string.table16)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.bio41)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.getString(R.string.table17)))
        add(DataItem.WebItem(context.getString(R.string.table18)))
    }

    // Chapter 26: Human Diseases
    private fun MutableList<DataItem>.addHumanDiseasesChapter() {
        add(DataItem.TextItem("6. Human Diseases", context.getString(R.string.bio42)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.getString(R.string.bio43)))
    }

    // Chapter 27: Plant Hormones (Alternative)

}