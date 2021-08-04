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
    private var vstup: String? = null
    private var savedState: Bundle? = null
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
        vstup = this.arguments?.getString("home1")
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)


        val bundle = Bundle()
        val galleryFragment= GalleryFragment()
       bundle.putString("gallery1","Программирование")
        galleryFragment.arguments = bundle
       //val actiontogallery = HomeFragmentDirections.actionNavHomeToNavGallery("Программирование")
        //val actiontoslideshow = HomeFragmentDirections.actionNavHomeToNavSlideshow(strtext!!)
      //  galleryFragment.arguments = HomeFragmentArgs.fromBundle(requireArguments()).toBundle()
       //actiontogallery.arguments.putString("gallery1","Программирование")
        //GalleryFragmentArgs.fromBundle(requireArguments()).toBundle().putAll(bundle)


        println("Gallery "  + GalleryFragmentArgs.fromBundle(requireArguments()).gallery1)


        Log.e(TAG,"HomeGallery "  + GalleryFragmentArgs.fromBundle(requireArguments()).gallery1)
        //actiontoslideshow.arguments.putString("slideshow1",strtext)
     val nameArg = NavArgument.Builder().setDefaultValue("Программирование").build()
        val navController = findNavController()
        val navInflater = navController.navInflater
        val navGraph = navInflater.inflate(com.example.myschool.R.navigation.mobile_navigation)
     //   actiontogallery.arguments.putAll(bundle)
       // findNavController().createDeepLink().setArguments(bundle)
      //  findNavController().graph.addArgument("home1",nameArg)
       // findNavController().graph.addArgument("gallery1", nameArg);
       // navGraph.addArgument("slideshow1", nameArg);
        // findNavController().navigate(actiontogallery)
      //  Toast.makeText(this.requireContext(),strtext.toString(), Toast.LENGTH_SHORT).show()*/
        println("HomeFragment " + vstup)
        println("HomeFragment args " + HomeFragmentArgs.fromBundle(requireArguments()).home1)
        //findNavController().graph = navGraph
        //println(actiontogallery.arguments)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val viewPager: ViewPager = binding.viewPager
            //findViewById(R.id.view_pager)
        val tabs: TabLayout =binding.tabs
            //findViewById(R.id.tabs)

        val personList0 = ArrayList<String>()
        val personList1 = ArrayList<String>()
        val personList2 = ArrayList<String>()
        val personList3 = ArrayList<String>()
        val personList4 = ArrayList<String>()
        val personList5 = ArrayList<String>()
        personList0.add(vstup!!)
         personList0.add("Математика")
            personList0.add("Математика")
            personList0.add("Математика")
            personList0.add("Математика")
            personList0.add("Математика")
            personList1.add("Русский язык")
            personList1.add("Русский язык")
            personList1.add("Русский язык")
            personList1.add("Русский язык")
            personList1.add("Русский язык")
            personList1.add("Русский язык")
            personList2.add("Химия")
            personList2.add("Химия")
            personList2.add("Химия")
            personList2.add("Химия")
            personList2.add("Химия")
            personList2.add("Химия")
            personList3.add("Биология")
            personList3.add("Биология")
            personList3.add("Биология")
            personList3.add("Биология")
            personList3.add("Биология")
            personList3.add("Биология")
            personList4.add("Физкультура")
            personList4.add("Физкультура")
            personList4.add("Физкультура")
            personList4.add("Физкультура")
            personList4.add("Физкультура")
            personList4.add("Физкультура")
            personList5.add("Математика")
            personList5.add("Информатика")
            personList5.add("Информатика")
            personList5.add("Информатика")
            personList5.add("Информатика")
            personList5.add("Информатика")
            val personList = arrayListOf<ArrayList<String>>()
            personList.add(personList0)
            personList.add(personList1)
            personList.add(personList2)
            personList.add(personList3)
            personList.add(personList4)
            personList.add(personList5)
        tabs.setupWithViewPager(viewPager)
        val adapter: PagerAdapter = SectionsPagerAdapter(this.requireActivity(), personList)
        viewPager.adapter = adapter
        viewPager.currentItem = 0
        return root
    }

    override fun onResume() {
        super.onResume()
        vstup = this.arguments?.getString("home1")
        Log.e(TAG,"HomeResumed " + vstup)
    }

    override fun onDestroyView() {

        Log.e(TAG, "Hello! HomeFragment is destroyed")
        super.onDestroyView()
        _binding = null
    }

}

