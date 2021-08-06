package com.example.myschool.ui.slideshow

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myschool.R
import com.example.myschool.databinding.FragmentGalleryBinding
import com.example.myschool.databinding.FragmentSlideshowBinding
import com.example.myschool.ui.gallery.GalleryFragmentArgs
import com.example.myschool.ui.gallery.GalleryFragmentDirections

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var subjlist = this.requireArguments().getStringArrayList("teachersthings")
        var marklist = this.requireArguments().getStringArrayList("marks")
        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val subjects: ListView = binding.subject
        val marks: ListView = binding.mark
        val subjadapter = this.context?.let { ArrayAdapter<String>(it,
            android.R.layout.simple_list_item_1,subjlist!!) }

        subjects.adapter = subjadapter
        val teachadapter = this.context?.let { ArrayAdapter<String>(it,
            android.R.layout.simple_list_item_1,marklist!!) }
        marks.adapter = teachadapter
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}