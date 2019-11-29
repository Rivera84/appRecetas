package com.example.apprecetas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_inicio_sesio_usuario.*

class inicioSesioUsuario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_sesio_usuario)

        btnCrearCuenta.setOnClickListener(){
            val intent= Intent(this, nuevoUsuario ::class.java )
            startActivity(intent)
            finish()
        }
    }
}
