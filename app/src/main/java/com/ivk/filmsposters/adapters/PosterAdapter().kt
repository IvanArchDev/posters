package com.ivk.filmsposters.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ivk.filmsposters.R
import com.ivk.filmsposters.model.FilmResponse
import com.ivk.filmsposters.ui.PosterHolder

class PosterAdapter() : RecyclerView.Adapter<PosterHolder>() {
    private var films: MutableList<FilmResponse> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterHolder {
        return PosterHolder(LayoutInflater.from(parent.context).inflate(R.layout.poster_card, parent, false))
    }

    override fun getItemCount(): Int {
        return films.size
    }

    override fun onBindViewHolder(holder: PosterHolder, position: Int) {
        holder.bind(films[position].poster)
    }
    fun updateList(updatedList: List<FilmResponse>) {
        films.clear()
        films.addAll(updatedList)
        this.notifyDataSetChanged()
    }
}