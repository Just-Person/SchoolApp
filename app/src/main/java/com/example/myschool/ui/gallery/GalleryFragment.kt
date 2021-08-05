package com.example.myschool.ui.gallery

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat.Token.fromBundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.Person.fromBundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentController
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.mediarouter.media.MediaRouteDescriptor.fromBundle
import androidx.mediarouter.media.MediaSessionStatus.fromBundle
import androidx.navigation.findNavController
import com.example.myschool.MobileNavigationArgs
import com.example.myschool.R
import com.example.myschool.databinding.FragmentGalleryBinding
import com.example.myschool.ui.home.HomeFragment
import com.example.myschool.ui.home.HomeFragmentArgs
import com.example.myschool.ui.home.HomeFragmentDirections

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel
    private var _binding: FragmentGalleryBinding? = null
var strfromhome: String? = String()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // val seta = HomeFragmentArgs().home1
var lock = this.requireArguments().getString("gallery1")
        //val bund = this.requireActivity().findNavController(requireView()).graph
        //lock = bund?.getString("gallery1")

        strfromhome = HomeFragmentArgs.fromBundle(requireArguments()).home1//.arguments?.getString("home1")
        println("GalleryFragment strfromhome "+ lock)
        println("Home "+HomeFragmentArgs.fromBundle(requireArguments()).home1)
            //.fromBundle(arguments).getPrivacyPolicyLink()
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root



       // val intf = arguments?.getInt("intt")
        println("GalleryFragment args " + GalleryFragmentArgs.fromBundle(requireArguments()).gallery1)
       // val actionfromhome = HomeFragmentDirections.actionNavHomeToNavGallery().arguments
        //val actiontohome = GalleryFragmentDirections.actionNavGalleryToNavHome(strtext!!)
        //val actiontoslideshow = GalleryFragmentDirections.actionNavGalleryToNavSlideshow(strtext!!)
        //actiontohome.arguments.putString("home1",strtext)
        //actiontoslideshow.arguments.putString("slideshow1",strtext)
        //println("GalleryFragment "+ strtext)
        //println(actionfromhome)
        val textView: TextView = binding.textGallery

        textView.text = GalleryFragmentArgs.fromBundle(requireArguments()).gallery1;
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}