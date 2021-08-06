package com.example.myschool

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract
import android.util.AttributeSet
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.SurfaceControl
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.*
import androidx.viewpager.widget.ViewPager
import com.example.myschool.databinding.ActivityMenuBinding
import com.example.myschool.ui.gallery.GalleryFragment
import com.example.myschool.ui.home.HomeFragment
import com.example.myschool.ui.timetable.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout
import androidx.navigation.fragment.NavHostFragment
import com.example.myschool.ui.gallery.GalleryFragmentArgs
import com.example.myschool.ui.gallery.GalleryFragmentDirections
import com.example.myschool.ui.home.HomeFragmentArgs
import com.example.myschool.ui.home.HomeFragmentDirections
import com.example.myschool.ui.slideshow.SlideshowFragment
import com.google.firebase.database.*


class MenuActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMenuBinding
    lateinit var db: FirebaseDatabase
    lateinit var table: DatabaseReference
    private val navController by lazy { findNavController(R.id.nav_host_fragment) }
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMenu.toolbar)
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val userID = intent.extras?.getString("userID")
       val monday = intent.extras?.getStringArrayList("monday")
        val tuesday = intent.extras?.getStringArrayList("tuesday")
        val wednesday = intent.extras?.getStringArrayList("wednesday")
        val thursday = intent.extras?.getStringArrayList("thursday")
        val friday = intent.extras?.getStringArrayList("friday")
        val saturday = intent.extras?.getStringArrayList("saturday")
        val nameArgmonday = NavArgument.Builder().setDefaultValue(monday).build()
        val nameArgtuesday = NavArgument.Builder().setDefaultValue(tuesday).build()
        val nameArgwednesday = NavArgument.Builder().setDefaultValue(wednesday).build()
        val nameArgthursday = NavArgument.Builder().setDefaultValue(thursday).build()
        val nameArgfriday = NavArgument.Builder().setDefaultValue(friday).build()
        val nameArgsaturday = NavArgument.Builder().setDefaultValue(saturday).build()
        val navInflater = navController.navInflater
        val navGraph = navInflater.inflate(R.navigation.mobile_navigation)
        navGraph.addArgument("monday", nameArgmonday);
        navGraph.addArgument("tuesday", nameArgtuesday);
        navGraph.addArgument("wednesday", nameArgwednesday);
        navGraph.addArgument("thursday", nameArgthursday);
        navGraph.addArgument("friday", nameArgfriday);
        navGraph.addArgument("saturday", nameArgsaturday);
        println(navGraph.arguments.values)
        navController.graph = navGraph;

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )

navController.addOnDestinationChangedListener { controller, destination, arguments ->

    navController.graph.findNode(R.id.nav_home)?.addArgument(
        "monday", NavArgument.Builder()
            .setDefaultValue(monday)
            .build()
    )
    navController.graph.findNode(R.id.nav_home)?.addArgument(
        "tuesday", NavArgument.Builder()
            .setDefaultValue(tuesday)
            .build()
    )
    navController.graph.findNode(R.id.nav_home)?.addArgument(
        "wednesday", NavArgument.Builder()
            .setDefaultValue(wednesday)
            .build()
    )
    navController.graph.findNode(R.id.nav_home)?.addArgument(
        "thursday", NavArgument.Builder()
            .setDefaultValue(thursday)
            .build()
    )
    navController.graph.findNode(R.id.nav_home)?.addArgument(
        "friday", NavArgument.Builder()
            .setDefaultValue(friday)
            .build()
    )
    navController.graph.findNode(R.id.nav_home)?.addArgument(
        "saturday", NavArgument.Builder()
            .setDefaultValue(saturday)
            .build()
    )
    navController.graph.findNode(R.id.nav_gallery)?.addArgument(
        "gallery2", NavArgument.Builder()
            .setDefaultValue("Programming")
            .build()
    )
    navController.graph.findNode(R.id.nav_slideshow)?.addArgument(
        "slideshow1", NavArgument.Builder()
            .setDefaultValue("Programming")
            .build()
    )


}

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }




}