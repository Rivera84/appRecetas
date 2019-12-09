package com.example.apprecetas.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.volley.RequestQueue
import com.example.apprecetas.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    //



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.content_activity__menu__recetas, container, false)
        //val textView: TextView = root.findViewById(R.id.)
        homeViewModel.text.observe(this, Observer {
        //    textView.text = it
        })
        return root
    }


}