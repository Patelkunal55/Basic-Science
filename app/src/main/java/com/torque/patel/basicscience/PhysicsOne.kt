package com.torque.patel.basicscience

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.security.PrivateKey

class PhysicsOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics_one)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        val no:Int = 1
        val number: Int = intent.getIntExtra("number", 0)



        val dataProvider = PhyArrData(this)
        val items = dataProvider.getPhysicsData(number)//this is a MutableList of
                                                                           // DataItem which is store in PhyArrData class

        recyclerView.adapter = PhyAdapter(this, items)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }


    class CollectData(private val dataList:MutableList<DataItem>){

        fun accessData(){
            for (data in dataList){


            }
        }
    }
}