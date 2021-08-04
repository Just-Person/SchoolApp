package com.example.myschool

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
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.example.myschool.databinding.ActivityMenuBinding
import com.example.myschool.ui.gallery.GalleryFragment
import com.example.myschool.ui.home.HomeFragment
import com.example.myschool.ui.timetable.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout
import androidx.navigation.NavArgument
import com.example.myschool.ui.gallery.GalleryFragmentDirections
import com.example.myschool.ui.home.HomeFragmentDirections
import com.example.myschool.ui.slideshow.SlideshowFragment


class MenuActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMenuBinding

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMenu.toolbar)
        val bundle = Bundle()
        bundle.putString("home", "From Activity")
        val home = HomeFragment()
        val gallery = GalleryFragment()
        // val action =
        //supportFragmentManager.beginTransaction().replace(R.id.fragment_container_view_tag,home).commit()
        //home.arguments = bundle

        //gallery.arguments =  bundle
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val nameArg = NavArgument.Builder().setDefaultValue("Программирование").build()
        // val nameArg1 = NavArgument.Builder().setDefaultValue("Галерея").build()
        val navInflater = navController.navInflater
        val navGraph = navInflater.inflate(R.navigation.mobile_navigation)
        navGraph.addArgument("home1", nameArg);
        navGraph.addArgument("gallery1", nameArg);
        navGraph.addArgument("slideshow1", nameArg);
        println(navGraph.arguments)
        //  navGraph.addArgument("gallery", nameArg1);
        navController.graph = navGraph;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        /*  val sectionsPagerAdapter = SectionsPagerAdapter(this,supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)*/
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }


}