package com.example.apprecetas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class ApiAdapter(context: Context, itemList: ArrayList<Recipe>) : RecyclerView.Adapter<ViewHolder>() {

 //   lateinit
    var  mContext: Context
    lateinit var mItemList: ArrayList<Recipe>

    init {
        mContext = context
        mItemList = itemList
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v: View = LayoutInflater.from(mContext).inflate(R.layout.item_content_receta,parent,false)
        return  ViewHolder(v)
         }

    override fun getItemCount(): Int = mItemList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var itemContentReceta = mItemList.get(position)

        var label = itemContentReceta.label
        var image= itemContentReceta.image

        holder.txtNomre.text = label
        Picasso.get().load(image).fit().centerInside().into(holder.imageView)

      /*  holder.itemView.setOnClickListener{
            Toast.makeText(context,"Coexion Establecidad",Toast.LENGTH_SHORT).show()
        }*/
    }
}

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
    var txtNomre:TextView= itemView.findViewById(R.id.txtNombreComida)
    var imageView :ImageView= itemView.findViewById(R.id.ImageComida)

    }


