package com.example.webtoonproject.WebRecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.webtoonproject.R

class WedWebtoonAdapter(private val context: Context): RecyclerView.Adapter<WebtoonViewHolder>(){
    var datas : MutableList<Webtoondata> = mutableListOf<Webtoondata>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebtoonViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.webtoon_item,parent,false)
        return WebtoonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size

    }

    override fun onBindViewHolder(holder: WebtoonViewHolder, position: Int) {
        holder.bind(datas[position])

    }



}