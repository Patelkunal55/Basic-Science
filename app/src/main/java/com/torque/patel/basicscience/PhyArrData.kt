package com.torque.patel.basicscience

import androidx.appcompat.app.AppCompatActivity

class PhyArrData(private val context: AppCompatActivity) {

    fun getPhysicsData(chapterNumber: Int): MutableList<DataItem> {
        return mutableListOf<DataItem>().apply {
            when (chapterNumber) {
                0 -> addUnitsChapter()
                1 -> addMotionChapter()
                2 -> addWorkEnergyChapter()
                3 -> addGravitationChapter()
                5 -> addPressureChapter()
                6 -> addFloatationChapter()
                7 -> addSurfaceTensionChapter()
                8 -> addViscosityChapter()
                9 -> addElasticityChapter()
                11 -> addHarmonicMotionChapter()
                12 -> addWaveChapter()
                13 -> addSoundWaveChapter()
                14 -> addHeatChapter()
                15 -> addLightChapter()
                16 -> addStaticElectricityChapter()
                18 -> addCurrentElectricityChapter()
                19 -> addMagnetismChapter()
                20 -> addAtomicPhysicsChapter()
                21 -> addElectromagnetismChapter()
                else -> add(DataItem.TextItem("Data Not Found", context.resources.getString(R.string.phy2)))
            }
        }
    }

    private fun MutableList<DataItem>.addUnitsChapter() {
        add(DataItem.TextItem("1.Units", context.resources.getString(R.string.phy1)))
        add(DataItem.WebItem(context.resources.getString(R.string.tablephy1)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("", context.resources.getString(R.string.phy2)))
        add(DataItem.WebItem(context.resources.getString(R.string.tablephy2)))
        add(DataItem.WebItem(context.resources.getString(R.string.tablephy3)))
        add(DataItem.WebItem(context.resources.getString(R.string.tablephy4)))
        add(DataItem.NativeAdItem)
    }

    private fun MutableList<DataItem>.addMotionChapter() {
        add(DataItem.TextItem("2.Motion",context.resources.getString(R.string.phy3)))
        add(DataItem.ImageItem(R.drawable.speed))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy4)))
        add(DataItem.ImageItem(R.drawable.velocity))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("",context.resources.getString(R.string.phy5)))
        add(DataItem.ImageItem(R.drawable.acceletation))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy6)))
        add(DataItem.ImageItem(R.drawable.angular_velocity))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("",context.resources.getString(R.string.phy7)))
        add(DataItem.ImageItem(R.drawable.one_revolution_o))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy8)))
        add(DataItem.ImageItem(R.drawable.force))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("",context.resources.getString(R.string.phy9)))
        // ... rest of motion chapter content
    }

    private fun MutableList<DataItem>.addWorkEnergyChapter(){
        add(DataItem.TextItem("3.Work,Energy and Power",context.resources.getString(R.string.phy10)))
        add(DataItem.WebItem(context.resources.getString(R.string.tablephy5)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("",context.resources.getString(R.string.phy11)))
        add(DataItem.ImageItem(R.drawable.kinetic_energy))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("",context.resources.getString(R.string.phy12)))
    }

    private fun MutableList<DataItem>.addGravitationChapter(){
        add(DataItem.TextItem("4.Gravitation",context.resources.getString(R.string.phy13)))
        add(DataItem.ImageItem(R.drawable.gravitation))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("",context.resources.getString(R.string.phy14)))
        add(DataItem.ImageItem(R.drawable.kepler_law))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("",context.resources.getString(R.string.phy15)))
        add(DataItem.ImageItem(R.drawable.period_of_revolution))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("",context.resources.getString(R.string.phy16)))
        add(DataItem.ImageItem(R.drawable.orbital_velocity))
        add(DataItem.NativeAdItem)


    }

    private fun MutableList<DataItem>.addPressureChapter(){
        add(DataItem.TextItem("5.Pressure",context.resources.getString(R.string.phy17)))
        add(DataItem.ImageItem(R.drawable.pressure_p))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("",context.resources.getString(R.string.phy18)))

    }
    private fun MutableList<DataItem>.addFloatationChapter(){
        add(DataItem.TextItem("6.Floatation",context.resources.getString(R.string.phy19)))
        add(DataItem.ImageItem(R.drawable.density))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("",context.resources.getString(R.string.phy20)))

    }
    private fun MutableList<DataItem>.addSurfaceTensionChapter(){
        add(DataItem.TextItem("7.Surface Tension",context.resources.getString(R.string.phy21)))
        add(DataItem.NativeAdItem)


    }
    private fun MutableList<DataItem>.addViscosityChapter(){
        add(DataItem.TextItem("8.Viscosity",context.resources.getString(R.string.phy22)))
        add(DataItem.NativeAdItem)

    }
    private fun MutableList<DataItem>.addElasticityChapter(){
        add(DataItem.TextItem("9.Elasticity",context.resources.getString(R.string.phy23)))
        add(DataItem.ImageItem(R.drawable.hook_law))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("",context.resources.getString(R.string.phy24)))
        add(DataItem.ImageItem(R.drawable.elastic_constant))
        add(DataItem.NativeAdItem)

    }
    private fun MutableList<DataItem>.addHarmonicMotionChapter(){
        add(DataItem.TextItem("10.Simple Harmonic Motion",context.resources.getString(R.string.phy25)))
        add(DataItem.ImageItem(R.drawable.simple_pendulum))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("",context.resources.getString(R.string.phy26)))


    }
    private fun MutableList<DataItem>.addWaveChapter(){
        add(DataItem.TextItem("11.Wave",context.resources.getString(R.string.phy27)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("",context.resources.getString(R.string.phy28)))

    }
    private fun MutableList<DataItem>.addSoundWaveChapter(){
        add(DataItem.TextItem("12.Sound Wave",context.resources.getString(R.string.phy29)))
        add(DataItem.ImageItem(R.drawable.speed_of_sound))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.resources.getString(R.string.tablephy6)))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy30)))
        add(DataItem.NativeAdItem)
        add(DataItem.ImageItem(R.drawable.ampltude))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy31)))

    }
    private fun MutableList<DataItem>.addHeatChapter(){
        add(DataItem.TextItem("13.Heat",context.resources.getString(R.string.phy32)))
        add(DataItem.ImageItem(R.drawable.temperature_scale))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("",context.resources.getString(R.string.phy33)))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy35)))
        add(DataItem.NativeAdItem)
        add(DataItem.ImageItem(R.drawable.e_t_e_p_t))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy36)))
        add(DataItem.NativeAdItem)
        add(DataItem.ImageItem(R.drawable.change_of_states))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy37)))
        add(DataItem.NativeAdItem)
        add(DataItem.ImageItem(R.drawable.carnot_engine))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy38)))


    }

    private fun MutableList<DataItem>.addLightChapter(){
        add(DataItem.TextItem("14.Light",context.resources.getString(R.string.phy39)))
        add(DataItem.ImageItem(R.drawable.refactive_index))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy40)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.resources.getString(R.string.tablephy7)))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy41)))
        add(DataItem.WebItem(context.resources.getString(R.string.tablephy8)))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy42)))
        add(DataItem.NativeAdItem)
        add(DataItem.ImageItem(R.drawable.snells_law))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy43)))
        add(DataItem.ImageItem(R.drawable.absolute_refractive_index))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy43A)))
        add(DataItem.NativeAdItem)
        add(DataItem.ImageItem(R.drawable.convex_and_concave_lens))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy43B)))
        add(DataItem.WebItem(context.resources.getString(R.string.tablephy10)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("",context.resources.getString(R.string.phy44)))
        add(DataItem.ImageItem(R.drawable.magenta))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy45)))
        add(DataItem.ImageItem(R.drawable.primary_color))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("",context.resources.getString(R.string.phy46)))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy47)))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy48)))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy49)))

    }

    private fun MutableList<DataItem>.addStaticElectricityChapter(){
        add(DataItem.TextItem("15.Static Electricity",context.resources.getString(R.string.phy50)))
        add(DataItem.WebItem(context.resources.getString(R.string.tablephy11)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("",context.resources.getString(R.string.phy51)))

    }

    private fun MutableList<DataItem>.addCurrentElectricityChapter(){
        add(DataItem.TextItem("16.Current Electricity",context.resources.getString(R.string.phy53)))
        add(DataItem.TextItem(" ",context.resources.getString(R.string.phy54)))
        add(DataItem.NativeAdItem)
        add(DataItem.ImageItem(R.drawable.conductance))
        add(DataItem.ImageItem(R.drawable.denoted_g))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("",context.resources.getString(R.string.phy55)))
        add(DataItem.ImageItem(R.drawable.resistance))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("",context.resources.getString(R.string.phy56)))
        add(DataItem.ImageItem(R.drawable.paralled_combination))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy57)))
        add(DataItem.NativeAdItem)
        add(DataItem.ImageItem(R.drawable.electric_power))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy58)))

    }

    private fun MutableList<DataItem>.addMagnetismChapter(){

        add(DataItem.TextItem("17.Magnetism",context.resources.getString(R.string.phy59)))
        add(DataItem.NativeAdItem)

    }

    private fun MutableList<DataItem>.addAtomicPhysicsChapter(){
        add(DataItem.TextItem("18.Atomic & Nuclear Physics",context.resources.getString(R.string.phy60)))
        add(DataItem.WebItem(context.resources.getString(R.string.tablephy12)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("",context.resources.getString(R.string.phy69)))
        add(DataItem.WebItem(context.resources.getString(R.string.tablephy13)))
        add(DataItem.NativeAdItem)
        add(DataItem.TextItem("",context.resources.getString(R.string.phy61)))
        add(DataItem.WebItem(context.resources.getString(R.string.tablephy14)))
        add(DataItem.NativeAdItem)
        add(DataItem.WebItem(context.resources.getString(R.string.tablephy15)))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy62)))
        add(DataItem.NativeAdItem)
        add(DataItem.ImageItem(R.drawable.nuclear_fusion))
        add(DataItem.TextItem("",context.resources.getString(R.string.phy63)))

    }

    private fun MutableList<DataItem>.addElectromagnetismChapter(){
        add(DataItem.TextItem("19.Electromagnetism",context.resources.getString(R.string.phy64)))
        add(DataItem.NativeAdItem)

    }




    // Add similar private functions for other chapters


}