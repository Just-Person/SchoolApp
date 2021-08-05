package com.example.myschool.ui.slideshow

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myschool.R
import com.example.myschool.databinding.FragmentSlideshowBinding
import com.example.myschool.ui.gallery.GalleryFragmentDirections

class SlideshowFragment : Fragment() {

    private lateinit var slideshowViewModel: SlideshowViewModel
    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)
        val strtext = this.arguments?.getString("slideshow1")

        val actiontohome = SlideshowFragmentDirections.actionNavSlideshowToNavHome(strtext!!)
     //   val actiontogallery = SlideshowFragmentDirections.actionNavSlideshowToNavGallery(strtext!!)
       // actiontohome.arguments.putString("home1",strtext)
      //  actiontogallery.arguments.putString("gallery1",strtext)
        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root
        println("SlideshowFragment  " + strtext)
        val textView: TextView = binding.textSlideshow
        slideshowViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}