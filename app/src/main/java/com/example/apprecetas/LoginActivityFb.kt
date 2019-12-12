package com.example.apprecetas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.firebase.auth.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class LoginActivityFb : AppCompatActivity() {
    private var callbackManager: CallbackManager?=null
    var firebaseAuth: FirebaseAuth?=null
    var firebaseAutListener: FirebaseAuth.AuthStateListener?=null


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

                        handleFacebookAccessToken(result!!.accessToken)

                    }

                    override fun onCancel() {
                        Log.d("MainActivity","Facebook onCanceler")
                    }

                    override fun onError(error: FacebookException?) {
                        Log.d("MainActivity", "Facebook onError")
                    }
                })

            firebaseAuth = FirebaseAuth.getInstance()
            firebaseAutListener= FirebaseAuth.AuthStateListener {firebaseAuth ->
                val user :FirebaseUser =firebaseAuth.currentUser!!
                if(user!=null){
                    goMainScreen()
                }
            }

        }





    }



    fun handleFacebookAccessToken(accessToken: AccessToken){
       val credential: AuthCredential= FacebookAuthProvider.getCredential(accessToken.token)
        firebaseAuth?.signInWithCredential(credential)?.addOnCompleteListener(this){task ->

            if(!task.isSuccessful){
                Log.d("TAG","signInWithCredential:failure",task.exception)
              //  val user = firebaseAuth.currentUser
                Toast.makeText(applicationContext,"Ha ocurrido un error",Toast.LENGTH_LONG).show()
            }else{
                goMainScreen()
            }

        }
    }




    private fun goMainScreen(){
        intent= Intent(this, Activity_Menu ::class.java)
        startActivity(intent)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager?.onActivityResult(requestCode,resultCode,data)
    }

    override fun onStart() {
        super.onStart()
    firebaseAuth?.addAuthStateListener(firebaseAutListener!!)
    }

    override fun onStop() {
        super.onStop()
    firebaseAuth?.removeAuthStateListener(firebaseAutListener!!)
    }

}
