package com.ivk.filmsposters.ui

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ivk.filmsposters.R

class PosterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val imageView = itemView.findViewById<ImageView>(R.id.poster)

    fun bind(url: String){
        Glide.with(itemView.context).load(url).into(imageView)
    }
}