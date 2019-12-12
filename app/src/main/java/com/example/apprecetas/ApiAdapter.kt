package com.example.apprecetas

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class ApiAdapter(var context: Context,  itemList: ArrayList<Recipe>, var clickListener:ClickListener) : RecyclerView.Adapter<ViewHolder>() {

 //   lateinit
    var  mContext: Context
    var mItemList: ArrayList<Recipe>

    init {
        mContext = context
        mItemList = itemList
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v: View = LayoutInflater.from(mContext).inflate(R.layout.item_content_receta,parent,false)
        return  ViewHolder(v,clickListener)
         }

    override fun getItemCount(): Int = mItemList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var itemContentReceta = mItemList.get(position)

        var label = itemContentReceta.label
        var image= itemContentReceta.image
        var url = itemContentReceta.url

        holder.txtNomre.text = label
        holder.url=url
        Picasso.get().load(image).fit().centerInside().into(holder.imageView)

    }
}

    class ViewHolder(var view: View, var clicListener:ClickListener) : RecyclerView.ViewHolder(view),View.OnClickListener{
    var txtNomre:TextView= itemView.findViewById(R.id.txtNombreComida)
    var imageView :ImageView= itemView.findViewById(R.id.ImageComida)
    var url=""

            override fun onClick(v:View){
                clicListener.onClick(view,adapterPosition)
            }

        init {
            view.setOnClickListener(this)
        }

    }


