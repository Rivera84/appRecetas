package com.example.apprecetas

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_nuevo_usuario.*

class nuevoUsuario : AppCompatActivity() {


    var firebaseAuth:FirebaseAuth?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_usuario)
        firebaseAuth=FirebaseAuth.getInstance()
        btnInicioUsuario1.setOnClickListener(){

            verificarCampo()
        }
    }

    fun verificarCampo(){
        val email= txtEmail.text.toString().trim()
        val password=txtContrasena.text.toString().trim()
        val passwordC=txtConfirmarContrasena.text.toString().trim()
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Se debe ingresar un email", Toast.LENGTH_LONG).show()
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Se debe ingresar un email", Toast.LENGTH_LONG).show()
        }
        if(password!=passwordC){
            Toast.makeText(this,"Las contraseñas son diferentes", Toast.LENGTH_LONG).show()
        }else {

            firebaseAuth?.createUserWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(this, OnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Se ha registrado el email", Toast.LENGTH_LONG).show()
                        var intent = Intent(this,Item_recetas::class.java)
                        startActivity(intent)
                        finish()
                    } else {

                        Toast.makeText(this, "No se ha podido registrar usuario", Toast.LENGTH_LONG).show()
                    }

                })
        }
    }
}
