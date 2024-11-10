package com.torque.patel.basicscience

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.torque.patel.basicscience.ChapViewAdapter.Companion.FIRST_VIEW
import com.torque.patel.basicscience.ChapViewAdapter.Companion.SECOND_VIEW

class QuizMenu : AppCompatActivity(),QuizMenuAdapter.OnItemClickListner {
    val number:Int = 2


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_menu)




        val items = mutableListOf<QuizItem>()


        when(number){


                0 -> {
                    items.apply {
                        add(QuizItem.ListItem("1.","Unit"))
                        add(QuizItem.ListItem("2.","Motion"))
                        add(QuizItem.ListItem("3.","Work,Energy and Power"))
                        add(QuizItem.NativeAdItem)
                        add(QuizItem.ListItem("4.","Gravitation"))
                        add(QuizItem.ListItem("5.","Pressure"))
                        add(QuizItem.ListItem("6.","Floatation"))
                        add(QuizItem.ListItem("7.","Surface Tension"))
                        add(QuizItem.ListItem("8.","Viscosity"))
                        add(QuizItem.ListItem("9.","Elasticity"))
                        add(QuizItem.ListItem("10.","Simple Harmonic Motion"))
                        add(QuizItem.NativeAdItem)
                        add(QuizItem.ListItem("11.","Wave"))
                        add(QuizItem.ListItem("12.","Sound Wave"))
                        add(QuizItem.ListItem("13.","Heat"))
                        add(QuizItem.ListItem("14.","Light"))
                        add(QuizItem.ListItem("15.","Static Electricity"))
                        add(QuizItem.NativeAdItem)
                        add(QuizItem.ListItem("16.","Current Electricity"))
                        add(QuizItem.ListItem("17.","Magnetism"))
                        add(QuizItem.ListItem("18.","Atomic & Nuclear Physics"))
                        add(QuizItem.ListItem("19.","Electronics"))

                    }
                }

                1 -> {

                    items.apply {
                        add(QuizItem.ListItem("1.","State of Matter"))
                        add(QuizItem.ListItem("2.","Atomic Structure"))
                        add(QuizItem.ListItem("3.","Periodic Classification of Elements"))
                        add(QuizItem.ListItem("4.","Chemical Bonding"))
                        add(QuizItem.ListItem("5.","Oxidation & Reduction"))
                        add(QuizItem.ListItem("6.","Solution"))
                        add(QuizItem.ListItem("7.","Acids,Bases & Salts"))
                        add(QuizItem.ListItem("8.","Behaviour of Gases"))
                        add(QuizItem.ListItem("9.","Electrolysis"))
                        add(QuizItem.ListItem("10.","Carbon and its Compounds"))
                        add(QuizItem.ListItem("11.","Fuel"))
                        add(QuizItem.ListItem("12.","Metallurgy"))
                        add(QuizItem.ListItem("13.","Momentum"))
                    }

                }
            
                2 -> {

                    items.apply {
                        add(QuizItem.ListItem("1.","Introduction to Biology"))
                        add(QuizItem.ListItem("2.","Classification of Organism"))
                        add(QuizItem.ListItem("3.","Study of Cell"))
                        add(QuizItem.ListItem("4.","Genetics"))
                        add(QuizItem.ListItem("5.","Sex Determination in Human"))
                        add(QuizItem.ListItem("6.","Organic Evolution"))
                        add(QuizItem.ListItem("I.","Biology"))
                        add(QuizItem.ListItem("1.","Classification of Plantae"))
                        add(QuizItem.ListItem("2.","Plant Morphology"))
                        add(QuizItem.ListItem("3.","Plant Tissue"))
                        add(QuizItem.ListItem("4.","Photosynthesis"))
                        add(QuizItem.ListItem("5.","Plant Hormones"))
                        add(QuizItem.ListItem("6.","Plant Disease"))
                        add(QuizItem.ListItem("7.","Ecology"))
                        add(QuizItem.ListItem("8.","Nitrogen Cycle"))
                        add(QuizItem.ListItem("9.","Pollution"))
                        add(QuizItem.ListItem("II.","Zoology"))
                        add(QuizItem.ListItem("1.","Classification of Animal Kingdom"))
                        add(QuizItem.ListItem("2.","Animal Tissue"))
                        add(QuizItem.ListItem("3.","Human Blood"))
                        add(QuizItem.ListItem("4.","System of the Human Body"))
                        add(QuizItem.ListItem("5.","Nutrients"))
                        add(QuizItem.ListItem("6.","Human Disease"))

                    }
                    
                }

            else -> {
                      items.apply {
                          add(QuizItem.ListItem("00.","No list is Added"))
                      }
            }

        }












        val recyclerView: RecyclerView = findViewById(R.id.quiz_menu_recyclerView)
        recyclerView.adapter = QuizMenuAdapter( items,this,this )
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)









    }

    override fun onItemClick(position: Int) {



        when {
            position < 21 && number == 0 -> {
                val intent = Intent(this, Quiz::class.java)
                intent.putExtra("question", position)
                intent.putExtra("testSet", number)
                startActivity(intent)
                finish()
            }
            position < 15 && number == 1 -> {
                val intent = Intent(this, Quiz::class.java)
                intent.putExtra("question", position)
                intent.putExtra("testSet", number)
                startActivity(intent)
                finish()
            }

            position < 25 && number == 2 -> {
                val intent = Intent(this, Quiz::class.java)
                intent.putExtra("question", position)
                intent.putExtra("testSet", number)
                startActivity(intent)
                finish()
            }
        }

    }



    private fun Toast(message: String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }


}