package com.example.myschool.ui.home

import android.R
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.myschool.databinding.FragmentHomeBinding
import com.example.myschool.ui.timetable.PageViewModel
import com.example.myschool.ui.timetable.SectionsPagerAdapter
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout
import com.example.myschool.MainActivity


import androidx.viewpager.widget.PagerAdapter





class HomeFragment : Fragment(){

    private lateinit var homeViewModel: HomeViewModel
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
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
            val viewPager: ViewPager = binding.viewPager
            //findViewById(R.id.view_pager)
        val tabs: TabLayout =binding.tabs
            //findViewById(R.id.tabs)
        val personList0 = ArrayList<String>()
        personList0.add("Математика")
        personList0.add("Русский язык")
        val personList1 = ArrayList<String>()
        personList1.add("Биология")
        personList1.add("Химия")
        personList1.add("Физика")
        val personList = arrayListOf<ArrayList<String>>()
        personList.add(personList0)
        personList.add(personList1)
        tabs.setupWithViewPager(viewPager)
        val adapter: PagerAdapter = SectionsPagerAdapter(this.requireActivity(), personList)
        viewPager.adapter = adapter
        viewPager.currentItem = 0
        return root
    }



    override fun onDestroyView() {
        /* val mFragmentMgr: FragmentManager = childFragmentManager
    val mTransaction: FragmentTransaction = mFragmentMgr.beginTransaction()
    val childFragment: Fragment = TimeTableHolderFragment()
    mTransaction.remove(childFragment);
    mTransaction.commit();*/
        super.onDestroyView()
        Log.e(TAG, "Hello! HomeFragment is destroyed")
       // childFragmentManager.isDestroyed
        _binding = null
    }

}

