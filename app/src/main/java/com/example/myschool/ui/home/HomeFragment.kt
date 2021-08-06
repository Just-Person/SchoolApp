package com.example.myschool.ui.home

import android.R
import android.app.Activity
import android.content.ContentValues.TAG
import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat.Token.fromBundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.ListView
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.findFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgument
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager.widget.ViewPager
import com.example.myschool.databinding.FragmentHomeBinding
import com.example.myschool.ui.timetable.PageViewModel
import com.example.myschool.ui.timetable.SectionsPagerAdapter
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout
import com.example.myschool.MainActivity


import androidx.viewpager.widget.PagerAdapter
import com.example.myschool.ui.gallery.GalleryFragment
import com.example.myschool.ui.gallery.GalleryFragmentArgs
import android.widget.TextView
import android.net.http.SslCertificate.saveState
import java.util.ResourceBundle.getBundle


class HomeFragment : Fragment(){
    private var monday: ArrayList<String>? = null
    private var tuesday: ArrayList<String>? = null
    private var wednesday: ArrayList<String>? = null
    private var thursday: ArrayList<String>? = null
    private var friday: ArrayList<String>? = null
    private var saturday: ArrayList<String>? = null
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e(TAG, "Hello! HomeFragment is activated")
        monday = this.arguments?.getStringArrayList("monday")
        tuesday = this.arguments?.getStringArrayList("tuesday")
        wednesday = this.arguments?.getStringArrayList("wednesday")
        thursday = this.arguments?.getStringArrayList("thursday")
        friday = this.arguments?.getStringArrayList("friday")
        saturday = this.arguments?.getStringArrayList("saturday")
        println("HomeFragment " + monday)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val viewPager: ViewPager = binding.viewPager
        val tabs: TabLayout =binding.tabs
        val mondayday = ArrayList<String>()
        val tuesdayday = ArrayList<String>()
        val wednesdayday = ArrayList<String>()
        val thursdayday = ArrayList<String>()
        val fridayday = ArrayList<String>()
        val saturdayday = ArrayList<String>()
        for (i in 0..7)
        {
            if (!monday?.get(i).equals(" ")) mondayday.add("${i+1}. "+monday?.get(i))
            if (!tuesday?.get(i).equals(" ")) tuesdayday.add("${i+1}. "+tuesday?.get(i))
            if (!wednesday?.get(i).equals(" ")) wednesdayday.add("${i+1}. "+wednesday?.get(i))
            if (!thursday?.get(i).equals(" ")) thursdayday.add("${i+1}. "+thursday?.get(i))
            if (!friday?.get(i).equals(" ")) fridayday.add("${i+1}. "+friday?.get(i))
            if (!saturday?.get(i).equals(" ")) saturdayday.add("${i+1}. "+saturday?.get(i))
        }

        val days = arrayListOf<ArrayList<String>>()
        days.add(mondayday)
        days.add(tuesdayday)
        days.add(wednesdayday)
        days.add(thursdayday)
        days.add(fridayday)
        days.add(saturdayday)
        tabs.setupWithViewPager(viewPager)
        val adapter: PagerAdapter = SectionsPagerAdapter(this.requireActivity(), days)
        viewPager.adapter = adapter
        viewPager.currentItem = 0
        return root
    }


    override fun onDestroyView() {

        Log.e(TAG, "Hello! HomeFragment is destroyed")
        super.onDestroyView()
        _binding = null
    }

}

