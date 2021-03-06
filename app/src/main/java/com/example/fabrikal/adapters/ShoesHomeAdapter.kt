package com.example.fabrikal.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fabrikal.R
import com.example.fabrikal.model.ShoeHomeItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_shoe_grid_item.view.*

class ShoesHomeAdapter(val lista : List<ShoeHomeItem> ) : RecyclerView.Adapter<ShoesHomeAdapter.ViewHolder>() {
    var onItemClick: ((ShoeHomeItem) -> Unit)? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        init {
            itemView.setOnClickListener {

                onItemClick?.invoke(lista[adapterPosition])
            }
        }

        fun bind(item: ShoeHomeItem){
            Picasso.get().load(item.urlImagen).into(itemView.photoImageView)
            itemView.titleTextView.text = item.brand
            itemView.descripcionTextView.text = item.descripcion
            itemView.precioTextView.text = item.precio

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
       val view =  LayoutInflater.from(parent.context).inflate(R.layout.view_shoe_grid_item,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position])
    }


}