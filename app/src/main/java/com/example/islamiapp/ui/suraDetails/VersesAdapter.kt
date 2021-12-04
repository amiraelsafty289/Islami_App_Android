package com.example.islamiapp.ui.suraDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.R

class VersesAdapter : RecyclerView.Adapter<VersesAdapter.ViewHolder>(){

    var verses : List<String> ?= null

    fun changeData(verses : List<String>){
        this.verses = verses
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_verse,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.content.setText(verses?.get(position))
    }

    override fun getItemCount(): Int {
        return verses?.size ?: 0
    }



    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val content : TextView = itemView.findViewById(R.id.content)
    }
}