package com.example.apprecetas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ApiAdapter(var itemList: List<Json>) : RecyclerView.Adapter<ApiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.item_recetas,parent,false)
        return  ViewHolder(v)
         }

    override fun getItemCount(): Int {
            return itemList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val itemList = itemList[position]

       // holder.nombre.text= itemList.nombre
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
    /*fun bindItems(data:TipoReseta_ApiResponse){


        val nombre: TextView = itemView.findViewById(R.id.txtNombreComida)
        //val image: ImageView= itemView.findViewById(R.id.ImageComida)



        }

    }

*/
        var nombre:TextView

        init{
            this.nombre=view.findViewById(R.id.txtNombreComida)
        }


    }

}
