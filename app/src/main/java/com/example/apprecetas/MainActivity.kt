package com.example.apprecetas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.facebook.AccessToken

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        val btnCerrarSesion= findViewById<Button>(R.id.cerrarSesion)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(AccessToken.getCurrentAccessToken()==null){
            goLoginScreen()
        }

        btnCerrarSesion.setOnClickListener{
           goLoginScreen()
        }

        }

    fun goLoginScreen(){
        intent=  Intent(this, LoginActivityFb::class.java)
        startActivity(intent)

    }


    }

