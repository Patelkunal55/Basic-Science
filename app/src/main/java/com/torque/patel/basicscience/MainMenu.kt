package com.torque.patel.basicscience

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.torque.patel.basicscience.R.color.colorBlack
import com.torque.patel.basicscience.R.color.colorWhite

class MainMenu : AppCompatActivity(),MenuAdapter.OnItemClickListner {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    //private val dataItem = ArrayList<ExampleItem>()
    @SuppressLint("MissingInflatedId", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.menu_toolbar)
        toolbar.title = "Main Menu"
        setSupportActionBar(toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.adapter = MenuAdapter(getList(),this)

        //recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.setHasFixedSize(true)


        drawerLayout = findViewById(R.id.my_drawer_layout)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)


        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val navigationView = findViewById<NavigationView>(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener {menuItem ->
            when(menuItem.itemId){
                R.id.nav_account -> {
                    // Handle click on item 1
                    showToast("My Account Clicked!")
                    true
                }
                R.id.nav_settings -> {
                    // Handle click on item 2
                    showToast("Setting Clicked!")
                    true
                }
                else -> false
            }

        }

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


    private fun getList(): Array<ExampleItem> {

        return arrayOf(
            ExampleItem(R.drawable.physics,"Physics"),
            ExampleItem(R.drawable.chemistry,"Chemistry"),
            ExampleItem(R.drawable.biology,"Biology"),
            ExampleItem(R.drawable.ic_satisfied,"Question Quiz"),
        )

    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, ChapterActivity::class.java)
        intent.putExtra("subject", position)
        startActivity(intent)

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