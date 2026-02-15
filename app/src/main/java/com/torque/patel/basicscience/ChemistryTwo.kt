package com.torque.patel.basicscience

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.torque.patel.basicscience.adapter.ChemAdapter
import com.torque.patel.basicscience.DataItems.DataItem
import com.torque.patel.basicscience.databinding.ActivityChemistryTwoBinding
import kotlin.math.abs

class ChemistryTwo : AppCompatActivity() {
    private lateinit var motionLayout: MotionLayout
    private lateinit var appBarLayout: AppBarLayout
    private lateinit var backButton: ImageView
    private lateinit var toolbarTitle: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chemistry_two)

        motionLayout = findViewById(R.id.motionLayout)
        appBarLayout = findViewById(R.id.appBarLayout)
        backButton = findViewById(R.id.backButton)
        toolbarTitle = findViewById(R.id.toolbarTitle)


        val recyclerView:RecyclerView = findViewById(R.id.chemtwo_recyclerView)

        setupBackButton()
        setupMotionLayout()
        val number:Int = intent.getIntExtra("number",0)

        val dataProviders = ChemistryDataProvider(this)
        val items = dataProviders.getChemistryData(number)


        val pageTitle = items.firstNotNullOfOrNull { it as? DataItem.TextItem }?.textTitle

        if (pageTitle != null) {
            // Find your title TextViews from the layout
            val largeTitle: TextView = findViewById(R.id.titleText)
            val smallToolbarTitle: TextView = findViewById(R.id.toolbarTitle)

            // Set the text for both titles
            largeTitle.text = pageTitle
            toolbarTitle.text = pageTitle
            //smallToolbarTitle.text = pageTitle

            //toolbarTitle.text = pageTitle

        }
        recyclerView.adapter = ChemAdapter(this,items)
        recyclerView.layoutManager = LinearLayoutManager(this)



    }

    fun setupMotionLayout() {


        appBarLayout.addOnOffsetChangedListener(
            AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                val progress = abs(verticalOffset / appBarLayout.totalScrollRange.toFloat())
                motionLayout.progress = progress

                val titleAlpha = when {
                    progress > 0.7f -> (progress - 0.7f) / 0.3f
                    else -> 0f
                }
                toolbarTitle.alpha = titleAlpha
            }
        )
    }

     fun setupBackButton() {
        backButton.setOnClickListener {
            // Handle back button click
            val intent = Intent(this, MainChapter::class.java)
            intent.putExtra("subject", 1)
            startActivity(intent)
            //Toast.makeText(this, "Back button clicked", Toast.LENGTH_SHORT).show()
            // In a real app, you would use:
            // onBackPressed() or finish()
        }
    }






}