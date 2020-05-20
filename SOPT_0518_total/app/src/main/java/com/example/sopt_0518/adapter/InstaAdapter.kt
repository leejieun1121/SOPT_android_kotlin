package com.example.sopt_0518.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt_0518.data.InstarViewHolder
import com.example.sopt_0518.R
import com.example.sopt_0518.data.InstaData

class InstaAdapter (private val context : Context) : RecyclerView.Adapter<InstarViewHolder>(){
    var datas : MutableList<InstaData> = mutableListOf<InstaData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstarViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_insta,parent,false)
        return InstarViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size;
    }

    override fun onBindViewHolder(holder: InstarViewHolder, position: Int) {
        holder.bind(datas[position])
    }

}