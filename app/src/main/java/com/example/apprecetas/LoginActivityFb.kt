package com.example.apprecetas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class LoginActivityFb : AppCompatActivity() {
    private var callbackManager: CallbackManager?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_fb)

        //BotonLogin
        val btnInicioUsuario = findViewById<Button>(R.id.btnInicioUsuario)
        val btnInicioFacebook= findViewById<Button>(R.id.btnInicioFacebook)

        btnInicioUsuario.setOnClickListener(){
            val intent = Intent(this,inicioSesioUsuario ::class.java)
            startActivity(intent)
            finish()
        }

        //Boton Login de Facebook
        btnInicioFacebook.setOnClickListener(){
            //Callback para inicio de sesion de facebook
            callbackManager= CallbackManager.Factory.create()
            LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile","email"))
            LoginManager.getInstance().registerCallback(callbackManager,
                object : FacebookCallback<LoginResult> {
                    override fun onSuccess(result: LoginResult?) {
                        // Log.d("MainActivity","Facebook token" + result.accessToken.token)
                        goMainScreen()
                        //startActivity(Intent(applicationContext,))
                    }

                    override fun onCancel() {
                        Log.d("MainActivity","Facebook onCanceler")
                    }

                    override fun onError(error: FacebookException?) {
                        Log.d("MainActivity", "Facebook onError")
                    }
                })

            /*  FacebookSdk.sdkInitialize(getApplicationContext())
              AppEventsLogger.activateApp(this)
  */
        }


    }

    fun goMainScreen(){
        intent= Intent(this,inicioSesioUsuario::class.java)
        startActivity(intent)
        finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager?.onActivityResult(requestCode,resultCode,data)
    }

}
