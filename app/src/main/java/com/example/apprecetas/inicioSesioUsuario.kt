package com.example.apprecetas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_inicio_sesio_usuario.*
import kotlinx.android.synthetic.main.activity_nuevo_usuario.*

class inicioSesioUsuario : AppCompatActivity() {


    var firebaseAuth: FirebaseAuth?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_sesio_usuario)


        firebaseAuth= FirebaseAuth.getInstance()

        btnInicioUsuario.setOnClickListener(){
            verificarCampo()
        }

        btnCrearCuenta.setOnClickListener(){
            val intent= Intent(this, nuevoUsuario ::class.java )
            startActivity(intent)
            finish()
        }
    }

    fun verificarCampo(){

        var email= txtUsuario.text.toString().trim()
        var password=txtPassword.text.toString().trim()
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Se debe ingresar un email", Toast.LENGTH_LONG).show()
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Se debe ingresar un email", Toast.LENGTH_LONG).show()
        }

        firebaseAuth?.signInWithEmailAndPassword(email,password)
            ?.addOnCompleteListener(this, OnCompleteListener { task ->
                if(task.isSuccessful){
                    val intent=Intent(application,Item_recetas::class.java)
                    startActivity(intent)
                }else{

                    Toast.makeText(this,"Correo o Contraseña incorrecta", Toast.LENGTH_LONG).show()
                }

            })

    }
}
