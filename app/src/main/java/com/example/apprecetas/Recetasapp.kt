package com.example.apprecetas

//import com.example.apprecetas.ui.Api
import android.app.Application
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger

class Recetasapp : Application() {
    override fun onCreate() {
        super.onCreate()
        FacebookSdk.getApplicationContext()
        AppEventsLogger.activateApp(this)
    }



}