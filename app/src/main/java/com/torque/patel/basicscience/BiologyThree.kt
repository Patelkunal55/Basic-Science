package com.torque.patel.basicscience

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BiologyThree : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biology_three)

        val recyclerView: RecyclerView = findViewById(R.id.biothree_recyclerView)

        val items = mutableListOf<DataItem>().apply {
            val number:Int = intent.getIntExtra("biology",0)

            when(number){

                0-> {
                    add(DataItem.TextItem("1. Introduction to Biology", resources.getString(R.string.bio1)))
                    add(DataItem.NativeAdItem)
                }

                1-> {
                    add(DataItem.TextItem("2. Classification of Organism", resources.getString(R.string.bio2)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.bio3)))
                }

                2-> {
                    add(DataItem.TextItem("3. Study of Cell", resources.getString(R.string.bio4)))
                    add(DataItem.TextItem("", resources.getString(R.string.bio5)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.WebItem(resources.getString(R.string.table1)))
                    add(DataItem.TextItem("", resources.getString(R.string.bio6)))
                    add(DataItem.WebItem(resources.getString(R.string.table2)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.WebItem(resources.getString(R.string.table3)))
                }

                3 -> {
                    add(DataItem.TextItem("4. Genetics", resources.getString(R.string.bio7)))
                    add(DataItem.ImageItem(R.drawable.monohybrid_cross))
                    add(DataItem.TextItem("", resources.getString(R.string.bio8)))
                    add(DataItem.ImageItem(R.drawable.description))
                    add(DataItem.TextItem("", resources.getString(R.string.bio9)))
                }

                5 -> {
                    add(DataItem.TextItem("5. Sex Determination in Human", resources.getString(R.string.bio10)))
                    add(DataItem.ImageItem(R.drawable.sex_determination_in_human))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.bio11)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.WebItem(resources.getString(R.string.table4)))
                }

                6 -> {
                    add(DataItem.TextItem("6. Organic Evolution", resources.getString(R.string.bio12)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.bio8)))
                    add(DataItem.TextItem("", resources.getString(R.string.bio9)))
                    add(DataItem.NativeAdItem)
                }

                7 -> {
                    add(DataItem.TextItem("Biology", resources.getString(R.string.bio63)))
                    add(DataItem.NativeAdItem)

                }

                8 -> {
                    add(DataItem.TextItem("1. Classification of Plantae", resources.getString(R.string.bio13)))
                    add(DataItem.ImageItem(R.drawable.plant_kingdoms))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.bio14)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.WebItem(resources.getString(R.string.table5)))
                    add(DataItem.TextItem("", resources.getString(R.string.bio15)))
                    add(DataItem.WebItem(resources.getString(R.string.table6)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.bio16)))
                    add(DataItem.TextItem("", resources.getString(R.string.bio17)))
                    add(DataItem.NativeAdItem)
                }

                10 -> {
                    add(DataItem.TextItem("2. Plant Morphology", resources.getString(R.string.bio18)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.WebItem(resources.getString(R.string.table7)))
                    add(DataItem.TextItem("", resources.getString(R.string.bio19)))
                    add(DataItem.NativeAdItem)
                }

                11 -> {
                    add(DataItem.TextItem("3. Plant Tissue", resources.getString(R.string.bio20)))
                    add(DataItem.ImageItem(R.drawable.plant_kingdoms))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.bio21)))
                    add(DataItem.NativeAdItem)

                }

                12 -> {
                    add(DataItem.TextItem("4. Photosynthesis", resources.getString(R.string.bio22)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.ImageItem(R.drawable.reaction))
                }

                13 -> {
                    add(DataItem.TextItem("5. Plant Hormones", resources.getString(R.string.bio23)))
                    add(DataItem.NativeAdItem)

                }

                15 -> {
                    add(DataItem.TextItem("6. Plant Disease", resources.getString(R.string.bio24)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.WebItem(resources.getString(R.string.table8)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.WebItem(resources.getString(R.string.table9)))
                }

                16 -> {
                    add(DataItem.TextItem("7. Ecology", resources.getString(R.string.bio25)))
                    add(DataItem.NativeAdItem)
                }

                17 -> {
                    add(DataItem.TextItem("8. Nitrogen cycle", resources.getString(R.string.bio26)))
                    add(DataItem.NativeAdItem)
                }

                18 -> {
                    add(DataItem.TextItem("9. Pollution", resources.getString(R.string.bio27)))
                    add(DataItem.NativeAdItem)
                }

                20 -> {
                    add(DataItem.TextItem("ZOOLOGY", resources.getString(R.string.bio28)))
                    add(DataItem.NativeAdItem)
                }

                21 -> {
                    add(DataItem.TextItem("1. Classification of Animal Kingdom", resources.getString(R.string.bio29)))
                    add(DataItem.NativeAdItem)


                }

                22 -> {
                    add(DataItem.TextItem("2. Animal Tissue", resources.getString(R.string.bio30)))
                    add(DataItem.NativeAdItem)


                }

                23 -> {
                    add(DataItem.TextItem("3. Human Blood", resources.getString(R.string.bio31)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.bio32)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.WebItem(resources.getString(R.string.table10)))
                    add(DataItem.TextItem("", resources.getString(R.string.bio33)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.WebItem(resources.getString(R.string.table11)))


                }

                25 -> {
                    add(DataItem.TextItem("4. System of the Human Body", resources.getString(R.string.bio34)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.WebItem(resources.getString(R.string.table12)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.bio35)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.WebItem(resources.getString(R.string.table13)))
                    add(DataItem.TextItem("", resources.getString(R.string.bio36)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.ImageItem(R.drawable.brain))
                    add(DataItem.TextItem("", resources.getString(R.string.bio37)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.WebItem(resources.getString(R.string.table14)))
                    add(DataItem.TextItem("", resources.getString(R.string.bio38)))
                    add(DataItem.NativeAdItem)


                }

                26 -> {

                    add(DataItem.TextItem("5. Nutrients", resources.getString(R.string.bio39)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.WebItem(resources.getString(R.string.table15)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.bio40)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.WebItem(resources.getString(R.string.table16)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.bio41)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.WebItem(resources.getString(R.string.table17)))
                    add(DataItem.WebItem(resources.getString(R.string.table18)))
                }

                27 -> {

                    add(DataItem.TextItem("6. Human Diseases", resources.getString(R.string.bio42)))
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("", resources.getString(R.string.bio43)))

                }

                28 -> {
                    add(DataItem.NativeAdItem)
                    add(DataItem.TextItem("7. Plant Hormones", resources.getString(R.string.bio23)))
                }


                else -> {
                    add(DataItem.TextItem("No data found", "No data found"))
                }







            }
        }

        recyclerView.adapter = BioAdapter(this,items)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}