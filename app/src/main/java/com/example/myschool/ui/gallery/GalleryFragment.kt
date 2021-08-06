package com.example.myschool.ui.gallery

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat.Token.fromBundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
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
    private val binding get() = _binding!!

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var subjlist = this.requireArguments().getStringArrayList("teachersthings")
        var teachlist = this.requireArguments().getStringArrayList("teachersname")
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val subjects: ListView = binding.subj
        val teachers: ListView = binding.teach
        val subjadapter = this.context?.let { ArrayAdapter<String>(it,
            android.R.layout.simple_list_item_1,subjlist!!) }

        subjects.adapter = subjadapter
        val teachadapter = this.context?.let { ArrayAdapter<String>(it,
            android.R.layout.simple_list_item_1,teachlist!!) }
        teachers.adapter = teachadapter
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}