package com.example.apprecetas.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.apprecetas.Item_recetas
import com.example.apprecetas.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    lateinit var btnBuscar:Button


    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_Titulo)
        homeViewModel.text.observe(this, Observer {
            textView.text = it

        })

        var eTextBuscar:EditText=root.findViewById(R.id.eTxtBuscar)
        btnBuscar=root.findViewById(R.id.btnBuscarComida)

        btnBuscar.setOnClickListener(){
            val intent= Intent(context,Item_recetas::class.java)
            startActivity(intent)

            var texto :String=eTextBuscar.text.toString()
            val intent2=Intent(context,Item_recetas::class.java)
            intent2.putExtra("valor_Edittext",texto)
            startActivity(intent2)

        }

        return root

    }



}
