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
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.mediarouter.media.MediaRouteDescriptor.fromBundle
import androidx.mediarouter.media.MediaSessionStatus.fromBundle
import com.example.myschool.R
import com.example.myschool.databinding.FragmentGalleryBinding
import com.example.myschool.ui.home.HomeFragmentArgs
import com.example.myschool.ui.home.HomeFragmentDirections

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel
    private var _binding: FragmentGalleryBinding? = null
var strfromhome: String? = String()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onAttach(context: Context) {
        super.onAttach(context)
        strfromhome = arguments?.getString("gallery1")
        Log.e("TAG","GalleryOnAttach " +  GalleryFragmentArgs.fromBundle(requireArguments()).gallery1)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)
        val url: String = GalleryFragmentArgs.fromBundle(requireArguments()).gallery1
println(url)
        println("Home "+HomeFragmentArgs.fromBundle(requireArguments()).home1)
            //.fromBundle(arguments).getPrivacyPolicyLink()
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val strtext = arguments?.let {
            val safeArgs = GalleryFragmentArgs.fromBundle(it)
            println("GalleryFragment "+ safeArgs.gallery1)
        }


       // val intf = arguments?.getInt("intt")
        println("GalleryFragment "+ strtext)
       // val actionfromhome = HomeFragmentDirections.actionNavHomeToNavGallery().arguments
        //val actiontohome = GalleryFragmentDirections.actionNavGalleryToNavHome(strtext!!)
        //val actiontoslideshow = GalleryFragmentDirections.actionNavGalleryToNavSlideshow(strtext!!)
        //actiontohome.arguments.putString("home1",strtext)
        //actiontoslideshow.arguments.putString("slideshow1",strtext)
        //println("GalleryFragment "+ strtext)
        //println(actionfromhome)
        val textView: TextView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        textView.text = strtext!!.toString();
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}