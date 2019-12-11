package com.example.apprecetas

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_content_receta.*
import kotlinx.android.synthetic.main.item_recetas.*

class Item_recetas : AppCompatActivity() {

    lateinit var  resquestQueue : RequestQueue
    var itemList = ArrayList<Recipe>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_recetas)


        httpVolley_PlatoComida(getTipoComidaApi("pollo"))


    }

    //Realizar una peticion http para una comida "x"
    private fun httpVolley_PlatoComida(tipoComida: String) {

        val queue=Volley.newRequestQueue(this)


        val stringReseta= StringRequest(Request.Method.GET,tipoComida,
            Response.Listener<String>{ response ->
                Log.d("HTTP Response",response)

                Toast.makeText(this, "Conexión establecida", Toast.LENGTH_LONG).show()
                jsonToObjectTipoCComida(response)
            }, Response.ErrorListener {
                Log.d("HTTP Respone","Ha ocurrido un erro")

                Toast.makeText(this, "¡Ha ocurrido un error en la conexión!", Toast.LENGTH_SHORT).show()
            })

                queue.add(stringReseta)
    }

    private fun getTipoComidaApi(tipoComida: String): String {
        return "https://test-es.edamam.com/search?q=$tipoComida&app_id=2c500e60&app_key=7cf25b7eef9d0ab96caad0e1e3e94279"
    }



    //Pasar un objeto JSON a objetos de Kotlin
    fun jsonToObjectTipoCComida(response: String) {
        // Inicializar la variable de tipo  Gson
        val gson = Gson()
        val apiResponse = gson.fromJson(response, Json::class.java)

        itemList.add(Recipe(apiResponse.hits[0].recipe.image,apiResponse.hits[0].recipe.label))
        itemList.add(Recipe(apiResponse.hits[1].recipe.image,apiResponse.hits[1].recipe.label))
        itemList.add(Recipe(apiResponse.hits[2].recipe.image,apiResponse.hits[2].recipe.label))
        itemList.add(Recipe(apiResponse.hits[3].recipe.image,apiResponse.hits[3].recipe.label))
        itemList.add(Recipe(apiResponse.hits[4].recipe.image,apiResponse.hits[4].recipe.label))
        itemList.add(Recipe(apiResponse.hits[5].recipe.image,apiResponse.hits[5].recipe.label))
        itemList.add(Recipe(apiResponse.hits[6].recipe.image,apiResponse.hits[6].recipe.label))
        itemList.add(Recipe(apiResponse.hits[7].recipe.image,apiResponse.hits[7].recipe.label))
        itemList.add(Recipe(apiResponse.hits[8].recipe.image,apiResponse.hits[8].recipe.label))
        itemList.add(Recipe(apiResponse.hits[9].recipe.image,apiResponse.hits[9].recipe.label))


        var recyclerView: RecyclerView= findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this)
        val adapter = ApiAdapter(this,itemList)
        recyclerView.adapter=adapter
        Log.d("ArregloRecipe","${itemList}")
    }




}