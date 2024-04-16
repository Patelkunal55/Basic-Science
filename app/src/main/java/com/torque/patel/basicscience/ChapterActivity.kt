package com.torque.patel.basicscience

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.torque.patel.basicscience.ChapViewAdapter.Companion.FIRST_VIEW
import com.torque.patel.basicscience.databinding.ActivityChapterBinding

class ChapterActivity : AppCompatActivity(), OnItemClickListener, OnItemClickListner {

    //val no = 1


    private lateinit var binding:ActivityChapterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChapterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initView()
        val sub:Int = intent.getIntExtra("subject",0)


        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
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



                DataChap(FIRST_VIEW,"Unit",1),
                DataChap(FIRST_VIEW,"Motion",2),
                DataChap(FIRST_VIEW,"Work,Energy and Power",3),
                DataChap(FIRST_VIEW,"Gravitation",4),
                DataChap(FIRST_VIEW,"Pressure",5),
                DataChap(FIRST_VIEW,"Floatation",6),
                DataChap(FIRST_VIEW,"Surface Tension",7),
                DataChap(FIRST_VIEW,"Viscosity",8),
                DataChap(FIRST_VIEW,"Elasticity",9),
                DataChap(FIRST_VIEW,"Simple Harmonic Motion",10),
                DataChap(FIRST_VIEW,"Wave",11),
                DataChap(FIRST_VIEW,"Sound Wave",12),
                DataChap(FIRST_VIEW,"Heat",13),
                DataChap(FIRST_VIEW,"Light",14),
                DataChap(FIRST_VIEW,"Static Electricity",15),
                DataChap(FIRST_VIEW,"Current Electricity",16),
                DataChap(FIRST_VIEW,"Magnetism",17),
                DataChap(FIRST_VIEW,"Atomic & Nuclear Physics",18),
                DataChap(FIRST_VIEW,"Electronics",19),
            )

            1 ->return arrayListOf(

                DataChap(FIRST_VIEW,"State of Matter",1),
                DataChap(FIRST_VIEW,"Atomic Structure",2),
                DataChap(FIRST_VIEW,"Periodic Classification of Elements",3),
                DataChap(FIRST_VIEW,"Chemical Bonding",4),
                DataChap(FIRST_VIEW,"Oxidation & Reduction",5),
                DataChap(FIRST_VIEW,"Solution",6),
                DataChap(FIRST_VIEW,"Acids,Bases & Salts",7),
                DataChap(FIRST_VIEW,"Behaviour of Gases",8),
                DataChap(FIRST_VIEW,"Electrolysis",9),
                DataChap(FIRST_VIEW,"Carbon and its Compounds",10),
                DataChap(FIRST_VIEW,"Fuel",11),
                DataChap(FIRST_VIEW,"Metallurgy",12)
            )

            2 ->return arrayListOf(

                DataChap(FIRST_VIEW,"Introduction Biology",1),
                DataChap(FIRST_VIEW,"Classification of Organism",2),
                DataChap(FIRST_VIEW,"Study of Cell -Cytology",3),
                DataChap(FIRST_VIEW,"Genetics",4),
                DataChap(FIRST_VIEW,"Sex Determination in Human",5),
                DataChap(FIRST_VIEW,"Organic Evolution",6),
                DataChap(FIRST_VIEW,"Biology",0),
                DataChap(FIRST_VIEW,"Classification of Plantae",1),
                DataChap(FIRST_VIEW,"Plant Morphology",2),
                DataChap(FIRST_VIEW,"Plant Tissue",3),
                DataChap(FIRST_VIEW,"Photosynthesis",4),
                DataChap(FIRST_VIEW,"Plant Hormones",5),
                DataChap(FIRST_VIEW,"Plant Disease",6),
                DataChap(FIRST_VIEW,"Ecology",7),
                DataChap(FIRST_VIEW,"Nitrogen Cycle",8),
                DataChap(FIRST_VIEW,"Pollution",9),
                DataChap(FIRST_VIEW,"Zoology",0),
                DataChap(FIRST_VIEW,"Classification of Animal Kingdom",1),
                DataChap(FIRST_VIEW,"Animal Tissue",2),
                DataChap(FIRST_VIEW,"Human Blood",3),
                DataChap(FIRST_VIEW,"System of the Human Body",4),
                DataChap(FIRST_VIEW,"Nutrients",5),
                DataChap(FIRST_VIEW,"Human Disease",6),
            )

            else -> return arrayListOf(
                DataChap(FIRST_VIEW,"No Data Found",0),
            )

        }



    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onItemClick(position: Int) {
        val sub:Int = intent.getIntExtra("subject",0)
        when(sub){
            0 -> {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("number", position)
                startActivity(intent)
                Toast.makeText(this, "Item clicked at position $position", Toast.LENGTH_SHORT).show()
            }

            1 -> {
                val intent = Intent(this, Chemistry::class.java)
                intent.putExtra("number", position)
                startActivity(intent)
                Toast.makeText(this, "Item clicked at position $position", Toast.LENGTH_SHORT).show()
            }

            2 -> {
                val intent = Intent(this, Biology::class.java)
                intent.putExtra("biology", position)
                startActivity(intent)
                Toast.makeText(this, "Item clicked at position $position", Toast.LENGTH_SHORT).show()
            }


        }



    }


}