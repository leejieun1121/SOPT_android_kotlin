package com.example.webtoonproject.WebRecycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.webtoonproject.R

class WebtoonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val img_data : ImageView = itemView.findViewById(R.id.webtoon_image)
    val web_name : TextView = itemView.findViewById(R.id.webtoon_name)
    val rate : TextView = itemView.findViewById(R.id.webtoon_rate)
    val writer: TextView = itemView.findViewById(R.id.webtoon_writer)

    fun bind(Webtoondata: Webtoondata){
        Glide.with(itemView).load(Webtoondata.img_data).into(img_data)
        web_name.text = Webtoondata.web_name
        rate.text = Webtoondata.rate
        writer.text=Webtoondata.writer
    }

}