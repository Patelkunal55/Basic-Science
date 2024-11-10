package com.torque.patel.basicscience

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions
import com.google.android.gms.ads.nativead.NativeAdView
import com.torque.patel.basicscience.ChapViewAdapter.Companion.FIRST_VIEW
import com.torque.patel.basicscience.ChapViewAdapter.Companion.SECOND_VIEW
import com.torque.patel.basicscience.databinding.ActivityChapterBinding

class ChapterActivity : AppCompatActivity(), OnItemClickListener, OnItemClickListner {

    //val no = 1



    private lateinit var binding:ActivityChapterBinding

    private lateinit var frameLayout: FrameLayout
    private lateinit var adLoader: AdLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MobileAds.initialize(this) {}



        binding = ActivityChapterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initView()
        ToolBar()

    }


    private fun ToolBar(){
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val sub:Int = intent.getIntExtra("subject",0)
        // Use ContextCompat for better compatibility
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorWhite))
        toolbar.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorPrimary))
        when(sub){
            0-> toolbar.title = "Physics"
            1-> toolbar.title = "Chemistry"
            2-> toolbar.title = "Biology"

        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                this.finish()
                true

            }
            else -> super.onOptionsItemSelected(item)

        }
    }

    private fun initView() {


        binding.chapRecyclerView.layoutManager = LinearLayoutManager(this@ChapterActivity)
        binding.chapRecyclerView.adapter = ChapViewAdapter(getList(),this)
    }






    private fun getList():ArrayList<DataChap>{




        val sub:Int = intent.getIntExtra("subject",0)


        when(sub){
            0 ->return arrayListOf(



                DataChap(FIRST_VIEW,"Unit",1,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Motion",2,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Work,Energy and Power",3,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Gravitation",4,R.drawable.rectangle),
                DataChap(SECOND_VIEW,"Momentum",3,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Pressure",5,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Floatation",6,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Surface Tension",7,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Viscosity",8,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Elasticity",9,R.drawable.rectangle),
                DataChap(SECOND_VIEW,"Momentum",3,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Simple Harmonic Motion",10,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Wave",11,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Sound Wave",12,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Heat",13,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Light",14,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Static Electricity",15,R.drawable.rectangle),
                DataChap(SECOND_VIEW,"Momentum",3,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Current Electricity",16,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Magnetism",17,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Atomic & Nuclear Physics",18,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Electronics",19,R.drawable.rectangle),
            )

            1 ->return arrayListOf(

                DataChap(FIRST_VIEW,"State of Matter",1,R.drawable.rectangle_2),
                DataChap(FIRST_VIEW,"Atomic Structure",2,R.drawable.rectangle_2),
                DataChap(FIRST_VIEW,"Periodic Classification of Elements",3,R.drawable.rectangle_2),
                DataChap(FIRST_VIEW,"Chemical Bonding",4,R.drawable.rectangle_2),
                DataChap(SECOND_VIEW,"Momentum",3,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Oxidation & Reduction",5,R.drawable.rectangle_2),
                DataChap(FIRST_VIEW,"Solution",6,R.drawable.rectangle_2),
                DataChap(FIRST_VIEW,"Acids,Bases & Salts",7,R.drawable.rectangle_2),
                DataChap(FIRST_VIEW,"Behaviour of Gases",8,R.drawable.rectangle_2),
                DataChap(SECOND_VIEW,"Momentum",3,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Electrolysis",9,R.drawable.rectangle_2),
                DataChap(FIRST_VIEW,"Carbon and its Compounds",10,R.drawable.rectangle_2),
                DataChap(FIRST_VIEW,"Fuel",11,R.drawable.rectangle_2),
                DataChap(FIRST_VIEW,"Metallurgy",12,R.drawable.rectangle_2),
                DataChap(SECOND_VIEW,"Momentum",3,R.drawable.rectangle),
            )

            2 ->return arrayListOf(

                DataChap(FIRST_VIEW,"Introduction Biology",1,R.drawable.rectangle_3),
                DataChap(FIRST_VIEW,"Classification of Organism",2,R.drawable.rectangle_3),
                DataChap(FIRST_VIEW,"Study of Cell -Cytology",3,R.drawable.rectangle_3),
                DataChap(FIRST_VIEW,"Genetics",4,R.drawable.rectangle_3),
                DataChap(SECOND_VIEW,"Momentum",3,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Sex Determination in Human",5,R.drawable.rectangle_3),
                DataChap(FIRST_VIEW,"Organic Evolution",6,R.drawable.rectangle_3),
                DataChap(FIRST_VIEW,"Biology",0,R.drawable.rectangle_3),
                DataChap(FIRST_VIEW,"Classification of Plantae",1,R.drawable.rectangle_3),
                DataChap(SECOND_VIEW,"Momentum",3,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Plant Morphology",2,R.drawable.rectangle_3),
                DataChap(FIRST_VIEW,"Plant Tissue",3,R.drawable.rectangle_3),
                DataChap(FIRST_VIEW,"Photosynthesis",4,R.drawable.rectangle_3),
                DataChap(FIRST_VIEW,"Plant Hormones",5,R.drawable.rectangle_3),
                DataChap(SECOND_VIEW,"Momentum",3,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Plant Disease",6,R.drawable.rectangle_3),
                DataChap(FIRST_VIEW,"Ecology",7,R.drawable.rectangle_3),
                DataChap(FIRST_VIEW,"Nitrogen Cycle",8,R.drawable.rectangle_3),
                DataChap(FIRST_VIEW,"Pollution",9,R.drawable.rectangle_3),
                DataChap(SECOND_VIEW,"Momentum",3,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"Zoology",0,R.drawable.rectangle_3),
                DataChap(FIRST_VIEW,"Classification of Animal Kingdom",1,R.drawable.rectangle_3),
                DataChap(FIRST_VIEW,"Animal Tissue",2,R.drawable.rectangle_3),
                DataChap(FIRST_VIEW,"Human Blood",3,R.drawable.rectangle_3),
                DataChap(SECOND_VIEW,"Momentum",3,R.drawable.rectangle),
                DataChap(FIRST_VIEW,"System of the Human Body",4,R.drawable.rectangle_3),
                DataChap(FIRST_VIEW,"Nutrients",5,R.drawable.rectangle_3),
                DataChap(FIRST_VIEW,"Human Disease",6,R.drawable.rectangle_3),
                DataChap(FIRST_VIEW,"Plant Hormones",6,R.drawable.rectangle_3),
            )

            else -> return arrayListOf(
                DataChap(FIRST_VIEW,"No Data Found",0,R.drawable.rectangle),
            )

        }



    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onItemClick(position: Int) {
        val sub:Int = intent.getIntExtra("subject",0)
        when(sub){
            0 -> {
                val intent = Intent(this, PhysicsOne::class.java)
                intent.putExtra("number", position)
                startActivity(intent)
                //Toast.makeText(this, "Item clicked at position $position", Toast.LENGTH_SHORT).show()
            }

            1 -> {
                val intent = Intent(this, ChemistryTwo::class.java)
                intent.putExtra("number", position)
                startActivity(intent)
                //Toast.makeText(this, "Item clicked at position $position", Toast.LENGTH_SHORT).show()
            }

            2 -> {
                val intent = Intent(this, BiologyThree::class.java)
                intent.putExtra("biology", position)
                startActivity(intent)
                //Toast.makeText(this, "Item clicked at position $position", Toast.LENGTH_SHORT).show()
            }


        }



    }


}