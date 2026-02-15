package com.torque.patel.basicscience

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.material.navigation.NavigationView
import com.google.android.play.core.review.ReviewException
import com.google.android.play.core.review.ReviewManagerFactory
import com.torque.patel.basicscience.adapter.MenuAdapter
import com.torque.patel.basicscience.DataItems.ExampleItem
import com.torque.patel.basicscience.adapter.ImageSliderAdapter

class MainMenu : AppCompatActivity(), MenuAdapter.OnItemClickListner {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    lateinit var adView: AdView
    lateinit var adRequest: AdRequest

    lateinit var recyclerView : RecyclerView


    private lateinit var viewPager: ViewPager2
    private lateinit var dotsLayout: LinearLayout
    private val handler = Handler(Looper.getMainLooper())
    private var currentPage = 0

    private lateinit var appOpenAdManager: AppOpenAdManager

    lateinit var adapter: MenuAdapter




    // Add your images here
    private val images = listOf(
        R.drawable.sliders1,
        R.drawable.sliders2,
        R.drawable.sliders3,
        R.drawable.sliders4
    )

    private val texts = listOf(
        "Welcome to Basic Science",
        "Explore Physics, Chemistry, and Biology",
        "Test your knowledge with our quizzes",
        "Learn and have fun!"
    )

    private val autoScrollRunnable = object : Runnable {
        override fun run() {
            currentPage = (currentPage + 1) % images.size
            viewPager.setCurrentItem(currentPage, true)
            handler.postDelayed(this, 8000) // Auto-scroll every 3 seconds
        }
    }

    val items = ArrayList<ExampleItem>()

    //private val dataItem = ArrayList<ExampleItem>()
    @SuppressLint("MissingInflatedId", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)



        MobileAds.initialize(this)

        ToolBar()

        appReview()

        //BannerAds()

        items.add(ExampleItem(R.drawable.physics,"Physics"))
        items.add(ExampleItem(R.drawable.chemistry,"Chemistry"))
        items.add(ExampleItem(R.drawable.biology,"Biology"))
        items.add(ExampleItem(R.drawable.quiz_icon,"Quiz"))


        recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        adapter = MenuAdapter(items, this)
        recyclerView.adapter = adapter

        //recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.setHasFixedSize(true)

        NavigationDrawer()

        SliderImages()


        onBackPressess()
    }


    fun appReview(){


        val manager = ReviewManagerFactory.create(this)

        val request = manager.requestReviewFlow()
        request.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // ReviewInfo object mil gaya
                val reviewInfo = task.result

                // 🔥 IMPORTANT: Review dialog launch karna
                val flow = manager.launchReviewFlow(this, reviewInfo)
                flow.addOnCompleteListener {
                    // Review flow complete ho gaya
                    // (user ne review diya ya nahi — ye info nahi milti)
                }

            } else {
                // Error handle kar sakte ho (optional)
                val exception = task.exception
                if (exception is ReviewException) {
                    val reviewErrorCode = exception.errorCode
                    // Log.d("Review", "Error code: $reviewErrorCode")
                }
            }
        }

    }



    private fun onBackPressess() {
        var doubleBackToExitPressedOnce = false

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (doubleBackToExitPressedOnce) {
                    // If pressed twice within 2 seconds, exit the app
                    finishAffinity()
                    return
                }

                // First press: Set the flag to true and show a toast
                doubleBackToExitPressedOnce = true
                Toast.makeText(this@MainMenu, "Press back again to exit", Toast.LENGTH_SHORT).show()

                // Reset the flag after 2 seconds (2000ms)
                Handler(Looper.getMainLooper()).postDelayed({
                    doubleBackToExitPressedOnce = false
                }, 2000)
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)
    }








    private fun ToolBar(){
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.menu_toolbar)
        toolbar.setTitleTextColor(resources.getColor(R.color.colorWhite))
        //toolbar.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        //toolbar.setLogo(R.drawable.test_icon)
        toolbar.title = "  General Science"
        toolbar.setLogo(R.drawable.ic_science_logo)

        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)

        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as androidx.appcompat.widget.SearchView

        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(query: String?): Boolean = false

            override fun onQueryTextChange(newText: String?): Boolean {
                filter(newText)
                return true
            }

        })
        return true
    }


    private fun filter(text : String?){
        val filteredList = ArrayList<ExampleItem>()

        for (item in items){
            if (item.text1.lowercase().contains(text?.lowercase() ?: "")){
                filteredList.add(item)
            }
        }

        if (filteredList.isEmpty()) {
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show()
        }

        adapter.filterList(filteredList)
    }


    private fun NavigationDrawer(){
        drawerLayout = findViewById(R.id.my_drawer_layout)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        actionBarDrawerToggle.drawerArrowDrawable.color = resources.getColor(R.color.colorWhite)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val navigationView = findViewById<NavigationView>(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener {menuItem ->
            when(menuItem.itemId){
                R.id.nav_main -> {
                    // Handle click on item 1
                    showToast("Home")
                    true
                }
                R.id.nav_physics -> {
                    // Handle click on item 2
                    val intent = Intent(this, ChapterActivity::class.java)
                    intent.putExtra("subject", 0)
                    startActivity(intent)
                    true
                }

                R.id.nav_chemistry -> {
                    // Handle click on item 2
                    val intent = Intent(this, ChapterActivity::class.java)
                    intent.putExtra("subject", 1)
                    startActivity(intent)
                    true
                }
                R.id.nav_biology -> {
                    // Handle click on item 2
                    val intent = Intent(this, ChapterActivity::class.java)
                    intent.putExtra("subject", 2)
                    startActivity(intent)
                    true
                }

                R.id.policy -> {
                    // Handle click on item 2
                    showToast("Policy")
                    true
                }
                R.id.exit -> {
                    // Handle click on item 2
                    showToast("Exit")
                    true
                }
                else -> false
            }

        }

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


    /*private fun getList(): ArrayList<ExampleItem> {

        return arrayOf(
            ExampleItem(R.drawable.physics,"Physics"),
            ExampleItem(R.drawable.chemistry,"Chemistry"),
            ExampleItem(R.drawable.biology,"Biology"),
            ExampleItem(R.drawable.quiz_icon,"Quiz"),
        )

    }*/

    override fun onItemClick(position: Int) {


        //Toast.makeText(this,"Position: ${position}",Toast.LENGTH_SHORT).show()

        when(position){
            in 0..2 -> {
                val intent = Intent(this, MainChapter::class.java)
                intent.putExtra("subject", position)
                startActivity(intent)
            }

            in 3..3-> {
                val intent = Intent(this, QuizDashboard::class.java)
                intent.putExtra("subject", position)
                intent.putExtra("quiz_subject",position)
                startActivity(intent)
            }

            else -> {}
        }


    }

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.navigation_menu,menu)
        return true
    }*/
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {

            //Toast.makeText(this,"Hello",Toast.LENGTH_SHORT).show()
            true
        } else {
            super.onOptionsItemSelected(item)
        }



    /*if (actionBarDrawerToggle.onOptionsItemSelected(item)) {

            Toast.makeText(this,"Hello",Toast.LENGTH_SHORT).show()
            true
        } else {
            super.onOptionsItemSelected(item)
        }*/


    }


    fun SliderImages(){
        viewPager = findViewById(R.id.viewPager)
        dotsLayout = findViewById(R.id.dotsLayout)

        val adapter = ImageSliderAdapter(images, texts)
        viewPager.adapter = adapter

        setupDots(images.size)
        setCurrentDot(0)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                currentPage = position
                setCurrentDot(position)
            }
        })

        // Start auto-scroll
        handler.postDelayed(autoScrollRunnable, 3000)
    }

    private fun setupDots(count: Int) {
        dotsLayout.removeAllViews()
        val dots = Array(count) { ImageView(this) }

        dots.forEach { dot ->
            dot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dot_inactive))
            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(8, 0, 8, 0)
            }
            dotsLayout.addView(dot, params)
        }
    }

    private fun setCurrentDot(position: Int) {
        val childCount = dotsLayout.childCount
        for (i in 0 until childCount) {
            val dot = dotsLayout.getChildAt(i) as ImageView
            val drawableId = if (i == position) R.drawable.dot_active else R.drawable.dot_inactive
            dot.setImageDrawable(ContextCompat.getDrawable(this, drawableId))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(autoScrollRunnable)
    }







    /*button1.setOnClickListener {
            val intent = Intent(this, ChapterActivity::class.java)
            intent.putExtra("subject", 0)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this, ChapterActivity::class.java)
            intent.putExtra("subject", 1)
            startActivity(intent)
        }

        button3.setOnClickListener {
            val intent = Intent(this, ChapterActivity::class.java)
            intent.putExtra("subject", 2)
            startActivity(intent)
        }*/

}
