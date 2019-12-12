package com.example.apprecetas

import android.content.Intent
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class Activity_webView : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        val objetoIntent: Intent =intent
        var valorRecibido = objetoIntent.getStringExtra("url")

        val web: WebView=findViewById(R.id.webView)
        web.webViewClient = object: WebViewClient(){}
        web.webChromeClient= object : WebChromeClient() {}
        val setting = web.settings
        setting.javaScriptEnabled=true
        web.loadUrl(valorRecibido)


    }



}
