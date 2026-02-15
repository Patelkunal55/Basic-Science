package com.torque.patel.basicscience

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.graphics.PorterDuff
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.MobileAds
import com.torque.patel.basicscience.adapter.ChapViewAdapter
import com.torque.patel.basicscience.adapter.ChapViewAdapter.Companion.FIRST_VIEW
import com.torque.patel.basicscience.adapter.ChapViewAdapter.Companion.SECOND_VIEW
import com.torque.patel.basicscience.databinding.ActivityChapterBinding
import com.torque.patel.basicscience.DataItems.DataChap

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


    @SuppressLint("WrongViewCast")
    private fun ToolBar(){
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val sub:Int = intent.getIntExtra("subject",0)
        // Use ContextCompat for better compatibility
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorWhite))
        toolbar.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorPrimary))



        when(sub){



            0-> {
                toolbar.title = "  Physics"
                toolbar.setLogo(R.drawable.ic_physics_logo)
                //relativeLayout.setBackgroundResource(R.drawable.blue_box)
            }

            1-> {toolbar.title = "  Chemistry"
                toolbar.setLogo(R.drawable.ic_chemistry_logo)
                //relativeLayout.setBackgroundResource(R.drawable.yellow_box)
            }

            2-> {
                toolbar.title = "  Biology"
                toolbar.setLogo(R.drawable.ic_biology_logo)
                //relativeLayout.setBackgroundResource(R.drawable.green_box)
            }

        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        // Set the back button color to white
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back_button)
        val upArrow = ContextCompat.getDrawable(this, R.drawable.ic_back_button)
        upArrow?.setColorFilter(ContextCompat.getColor(this, R.color.colorWhite), PorterDuff.Mode.SRC_ATOP)
        supportActionBar?.setHomeAsUpIndicator(upArrow)

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



                DataChap(FIRST_VIEW,"Unit",1,R.drawable.blue_box),
                DataChap(FIRST_VIEW,"Motion",2,R.drawable.blue_box),
                DataChap(FIRST_VIEW,"Work,Energy and Power",3,R.drawable.blue_box),
                DataChap(FIRST_VIEW,"Gravitation",4,R.drawable.blue_box),
                DataChap(SECOND_VIEW,"Momentum",3,R.drawable.blue_box),
                DataChap(FIRST_VIEW,"Pressure",5,R.drawable.blue_box),
                DataChap(FIRST_VIEW,"Floatation",6,R.drawable.blue_box),
                DataChap(FIRST_VIEW,"Surface Tension",7,R.drawable.blue_box),
                DataChap(FIRST_VIEW,"Viscosity",8,R.drawable.blue_box),
                DataChap(FIRST_VIEW,"Elasticity",9,R.drawable.blue_box),
                DataChap(SECOND_VIEW,"Momentum",3,R.drawable.blue_box),
                DataChap(FIRST_VIEW,"Simple Harmonic Motion",10,R.drawable.blue_box),
                DataChap(FIRST_VIEW,"Wave",11,R.drawable.blue_box),
                DataChap(FIRST_VIEW,"Sound Wave",12,R.drawable.blue_box),
                DataChap(FIRST_VIEW,"Heat",13,R.drawable.blue_box),
                DataChap(FIRST_VIEW,"Light",14,R.drawable.blue_box),
                DataChap(FIRST_VIEW,"Static Electricity",15,R.drawable.blue_box),
                DataChap(SECOND_VIEW,"Momentum",3,R.drawable.blue_box),
                DataChap(FIRST_VIEW,"Current Electricity",16,R.drawable.blue_box),
                DataChap(FIRST_VIEW,"Magnetism",17,R.drawable.blue_box),
                DataChap(FIRST_VIEW,"Atomic & Nuclear Physics",18,R.drawable.blue_box),
                DataChap(FIRST_VIEW,"Electronics",19,R.drawable.blue_box),
            )

            1 ->return arrayListOf(

                DataChap(FIRST_VIEW,"State of Matter",1,R.drawable.yellow_box),
                DataChap(FIRST_VIEW,"Atomic Structure",2,R.drawable.yellow_box),
                DataChap(FIRST_VIEW,"Periodic Classification of Elements",3,R.drawable.yellow_box),
                DataChap(FIRST_VIEW,"Chemical Bonding",4,R.drawable.yellow_box),
                DataChap(SECOND_VIEW,"Momentum",3,R.drawable.yellow_box),
                DataChap(FIRST_VIEW,"Oxidation & Reduction",5,R.drawable.yellow_box),
                DataChap(FIRST_VIEW,"Solution",6,R.drawable.yellow_box),
                DataChap(FIRST_VIEW,"Acids,Bases & Salts",7,R.drawable.yellow_box),
                DataChap(FIRST_VIEW,"Behaviour of Gases",8,R.drawable.yellow_box),
                DataChap(SECOND_VIEW,"Momentum",3,R.drawable.yellow_box),
                DataChap(FIRST_VIEW,"Electrolysis",9,R.drawable.yellow_box),
                DataChap(FIRST_VIEW,"Carbon and its Compounds",10,R.drawable.yellow_box),
                DataChap(FIRST_VIEW,"Fuel",11,R.drawable.yellow_box),
                DataChap(FIRST_VIEW,"Metallurgy",12,R.drawable.yellow_box),
                DataChap(SECOND_VIEW,"Momentum",3,R.drawable.yellow_box),
            )

            2 ->return arrayListOf(

                DataChap(FIRST_VIEW,"Introduction Biology",1,R.drawable.green_box),
                DataChap(FIRST_VIEW,"Classification of Organism",2,R.drawable.green_box),
                DataChap(FIRST_VIEW,"Study of Cell -Cytology",3,R.drawable.green_box),
                DataChap(FIRST_VIEW,"Genetics",4,R.drawable.green_box),
                DataChap(SECOND_VIEW,"Momentum",3,R.drawable.green_box),
                DataChap(FIRST_VIEW,"Sex Determination in Human",5,R.drawable.green_box),
                DataChap(FIRST_VIEW,"Organic Evolution",6,R.drawable.green_box),
                DataChap(FIRST_VIEW,"Biology",0,R.drawable.green_box),
                DataChap(FIRST_VIEW,"Classification of Plantae",1,R.drawable.green_box),
                DataChap(SECOND_VIEW,"Momentum",3,R.drawable.green_box),
                DataChap(FIRST_VIEW,"Plant Morphology",2,R.drawable.green_box),
                DataChap(FIRST_VIEW,"Plant Tissue",3,R.drawable.green_box),
                DataChap(FIRST_VIEW,"Photosynthesis",4,R.drawable.green_box),
                DataChap(FIRST_VIEW,"Plant Hormones",5,R.drawable.green_box),
                DataChap(SECOND_VIEW,"Momentum",3,R.drawable.green_box),
                DataChap(FIRST_VIEW,"Plant Disease",6,R.drawable.green_box),
                DataChap(FIRST_VIEW,"Ecology",7,R.drawable.green_box),
                DataChap(FIRST_VIEW,"Nitrogen Cycle",8,R.drawable.green_box),
                DataChap(FIRST_VIEW,"Pollution",9,R.drawable.green_box),
                DataChap(SECOND_VIEW,"Momentum",3,R.drawable.green_box),
                DataChap(FIRST_VIEW,"Zoology",0,R.drawable.green_box),
                DataChap(FIRST_VIEW,"Classification of Animal Kingdom",1,R.drawable.green_box),
                DataChap(FIRST_VIEW,"Animal Tissue",2,R.drawable.green_box),
                DataChap(FIRST_VIEW,"Human Blood",3,R.drawable.green_box),
                DataChap(SECOND_VIEW,"Momentum",3,R.drawable.green_box),
                DataChap(FIRST_VIEW,"System of the Human Body",4,R.drawable.green_box),
                DataChap(FIRST_VIEW,"Nutrients",5,R.drawable.green_box),
                DataChap(FIRST_VIEW,"Human Disease",6,R.drawable.green_box),
                DataChap(FIRST_VIEW,"Plant Hormones",6,R.drawable.green_box),
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