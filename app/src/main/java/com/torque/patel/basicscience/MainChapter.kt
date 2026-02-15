package com.torque.patel.basicscience

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.MobileAds
import com.torque.patel.basicscience.adapter.MainAdapter
import com.torque.patel.basicscience.DataItems.DataChapter


class MainChapter : AppCompatActivity(), MainAdapter.OnItemClickListner {
    private lateinit var toolbarTitle: TextView
    private lateinit var backButton: ImageView
    private lateinit var image_logo: ImageView
    //val number:Int = 2
    val image_physics: Int = R.drawable.ic_physics_logo

    val items = mutableListOf<DataChapter>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter : MainAdapter


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_chapter)

        MobileAds.initialize(this)

        toolbarTitle = findViewById<TextView>(R.id.toolbar_Title)
        backButton = findViewById<ImageView>(R.id.back_Button)
        image_logo = findViewById<ImageView>(R.id.toolbar_logo)


        val number: Int = intent.getIntExtra("subject", 0)


        setupBackButton()

        toolbars(number)

        chapterTopic(number,items)

        recyclerSetup(items,number)

        setupBackButton()


    }

    private fun recyclerSetup(items: MutableList<DataChapter>, number: Int) {
        recyclerView = findViewById(R.id.recycler_chapter)
        adapter = MainAdapter(this, items, this, number)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
    }

    private fun chapterTopic(num: Int, items: MutableList<DataChapter>) {


        // Load string arrays from resources
        val physicsTopics = resources.getStringArray(R.array.physics_topics).toList()
        val chemistryTopics = resources.getStringArray(R.array.chemistry_topics).toList()
        val biologyTopics = resources.getStringArray(R.array.biology_topics).toList()
        val botanyTopics = resources.getStringArray(R.array.botany_topics).toList()
        val zoologyTopics = resources.getStringArray(R.array.zoology_topics).toList()

        when (num) {
            0 -> {
                // Physics Topics
                for (i in physicsTopics.indices) {
                    items.add(DataChapter.ChapterItem("${i + 1}.", physicsTopics[i]))
                    // Add ad after every 3rd, 11th, and 15th item
                    if (i == 2 || i == 11 || i == 15 ) {//
                        items.add(DataChapter.NativeItems)
                    }
                }
            }

            1 -> {
                // Chemistry Topics
                for (i in chemistryTopics.indices) {
                    items.add(DataChapter.ChapterItem("${i + 1}.", chemistryTopics[i]))
                    // Add ad after 3rd and 10th item
                    if (i == 2 || i == 9) {
                        items.add(DataChapter.NativeItems)
                    }
                }
            }

            2 -> {

                // Biology Topics - General
                for (i in biologyTopics.indices) {
                    items.add(DataChapter.ChapterItem("${i + 1}.", biologyTopics[i]))
                    if (i == 2) {
                        items.add(DataChapter.NativeItems)
                    }
                }

                // Botany Section Header
                items.add(
                    DataChapter.ChapterItem(
                        "I.",
                        resources.getString(R.string.biology_section)
                    )
                )

                // Botany Topics
                for (i in botanyTopics.indices) {
                    items.add(DataChapter.ChapterItem("${i + 1}.", botanyTopics[i]))
                    if (i == 2 || i == 8) {
                        items.add(DataChapter.NativeItems)
                    }
                }

                // Zoology Section Header
                items.add(
                    DataChapter.ChapterItem(
                        "II.",
                        resources.getString(R.string.zoology_section)
                    )
                )

                // Zoology Topics
                for (i in zoologyTopics.indices) {
                    items.add(DataChapter.ChapterItem("${i + 1}.", zoologyTopics[i]))
                    if (i == 2) {
                        items.add(DataChapter.NativeItems)
                    }
                }
            }


            else -> {
                items.apply {
                    add(DataChapter.ChapterItem("00.", "No list is Added"))
                }


            }

        }
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
        val filteredList = mutableListOf<DataChapter>()

        for (item in items){
            if (item is DataChapter.ChapterItem && item.chapterName.lowercase().contains(text?.lowercase() ?: ""))
                filteredList.add(item)
        }

        if (filteredList.isEmpty()) {
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show()
        }

        adapter.filterList(filteredList as ArrayList<DataChapter>)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                this.finish()
                true

            }

            else -> super.onOptionsItemSelected(item)

        }
    }

    private fun toolbars(pos: Int) {


        when (pos) {
            0 -> configureToolbar("Physics", R.drawable.ic_physics_logo, R.color.colorPrimary)
            1 -> configureToolbar("Chemistry", R.drawable.ic_chemistry_logo, R.color.colorYello)
            2 -> configureToolbar("Biology", R.drawable.ic_biology_logo, R.color.colorGreenLight)

        }
    }

    fun configureToolbar(title: String, logoRes: Int, colorRes: Int) {
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.main_chapter_toolbar)
        toolbarTitle.setTextColor(ContextCompat.getColor(this, R.color.colorWhite))

        toolbarTitle.text = title
        image_logo.setImageResource(logoRes)
        toolbar.backgroundTintList = ContextCompat.getColorStateList(this, colorRes)
        window.statusBarColor = ContextCompat.getColor(this, colorRes)

        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
    }

    fun setupBackButton() {
        backButton.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            intent.putExtra("subject", 0)
            startActivity(intent)
        }
    }

    override fun onItemClick(position: Int) {

        val sub: Int = intent.getIntExtra("subject", 0)
        when (sub) {
            0 -> startSubjectActivity(PhysicsOne::class.java, "number", position)
            1 -> startSubjectActivity(ChemistryTwo::class.java, "number", position)
            2 -> startSubjectActivity(BiologyThree::class.java, "biology", position)
        }
    }

    fun startSubjectActivity(activityClass: Class<*>, extraKey: String, position: Int) {
        //Toast.makeText(this,"Position: $position", Toast.LENGTH_SHORT).show()
        Intent(this, activityClass).apply {
            putExtra(extraKey, position)
            startActivity(this)
        }
    }

}
