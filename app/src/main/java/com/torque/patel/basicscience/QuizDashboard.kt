package com.torque.patel.basicscience

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.google.android.gms.ads.MobileAds
import com.torque.patel.basicscience.adapter.DashboardAdapter
import com.torque.patel.basicscience.DataItems.DashboardItem


class QuizDashboard : AppCompatActivity(),DashboardAdapter.OnItemClickListener {

    private lateinit var appOpenAdManager: AppOpenAdManager







    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_dashboard)

        var buttonBack = findViewById<ImageView>(R.id.btnBack)
        buttonBack.setOnClickListener {
            backButton()
        }

        // Initialize AdMob
        //MobileAds.initialize(this)

        // Initialize App Open Ad Manager
        //appOpenAdManager = AppOpenAdManager(application)
        //appOpenAdManager.loadAd()


        val recyclerView : RecyclerView = findViewById(R.id.db_recyclerView)
        val adapter = DashboardAdapter(getList(), this)
        recyclerView.adapter = adapter
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)


        mToolbar()


        val callback = object : OnBackPressedCallback(true) { // 'true' means the callback is enabled initially
            override fun handleOnBackPressed() {
                // Your custom logic to handle the back event
                // If you want the system's default behavior, disable this callback
                // and call onBackPressedDispatcher.onBackPressed()

                backButton()

                //Toast.makeText(application,"Backbutton is pressed", Toast.LENGTH_SHORT).show()
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)


    }

    override fun onResume() {
        super.onResume()

        // Show ad when activity resumes
        //appOpenAdManager.showAdIfAvailable(this)
    }

    fun backButton(){
        val intent = Intent(this, MainMenu::class.java)
        startActivity(intent)
    }

    

    private fun mToolbar(){
        //val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.quiz_dashboard_toolbar)
        //toolbar.setTitleTextColor(resources.getColor(R.color.colorWhite)) // set Title text color
        //toolbar.title = "  Quiz" // set Title of toolbar
        //toolbar.setLogo(R.drawable.ic_quiz_icon)//set Icon
        //setSupportActionBar(toolbar)

        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //supportActionBar?.setDisplayShowHomeEnabled(true)

        // Set the back button color to white
        //supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow)
        //val upArrow = ContextCompat.getDrawable(this, R.drawable.ic_arrow)
        //upArrow?.setColorFilter(ContextCompat.getColor(this, R.color.colorWhite), PorterDuff.Mode.SRC_ATOP)
        //supportActionBar?.setHomeAsUpIndicator(upArrow)


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

    private fun getList() : Array<DashboardItem> {

        return arrayOf(
            DashboardItem(R.drawable.physics,"Physics"),
            DashboardItem(R.drawable.chemistry,"Chemistry"),
            DashboardItem(R.drawable.biology,"Biology")
        )
    }

    override fun onItemClick(position: Int) {
        val quiz_pos = intent.getIntExtra("quiz_subject",0)


        when(position){

            in 0..2 -> {
                val intent = Intent(this, QuizMenu::class.java)
                intent.putExtra("number", position)
                intent.putExtra("quiz_subject", position)
                startActivity(intent)

                //Toast.makeText(this,"Position: ${position}",Toast.LENGTH_SHORT).show()
            }
        }
    }





}