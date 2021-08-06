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

    private var _binding: FragmentGalleryBinding? = null
var strfromhome: String? = String()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
var lock = this.requireArguments().getString("gallery2")
        strfromhome = HomeFragmentArgs.fromBundle(requireArguments()).home1
        println("GalleryFragment strfromhome "+ lock)
        println("Home "+HomeFragmentArgs.fromBundle(requireArguments()).home1)
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        println("GalleryFragment args " + GalleryFragmentArgs.fromBundle(requireArguments()).gallery1)
        val textView: TextView = binding.textGallery

        textView.text = lock;
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}