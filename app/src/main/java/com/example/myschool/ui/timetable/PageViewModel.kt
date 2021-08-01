package com.example.myschool.ui.timetable

import android.R
import android.content.Context
import android.widget.ArrayAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PageViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
    var personList = ArrayList<String>()
    val text: LiveData<List<String>> = Transformations.map(_index)

    {
        personList.add("Hello world from section: $it")
        personList.add("Hello $it")
        personList.add("Привет $it")
        personList

    }
    //  val text: LiveData<String> = Transformations.map(_index) {
    //   "Hello world from section: $it"
    //  }
    fun setIndex(index: Int) {
        _index.value = index
    }
}