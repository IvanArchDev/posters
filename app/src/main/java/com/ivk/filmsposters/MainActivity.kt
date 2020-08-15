package com.ivk.filmsposters

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.ivk.filmsposters.adapters.PosterAdapter
import com.ivk.filmsposters.model.FilmResponse
import com.ivk.filmsposters.repository.RepositoryDbFilms
import com.ivk.filmsposters.viewModel.FilmViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var viewModel : FilmViewModel
    private var adapter = PosterAdapter()
    private val filterYear = 2020
    private val loadedList: MutableList<FilmResponse> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        filmsRecyclerView.layoutManager = GridLayoutManager(this, 3, VERTICAL, false)
        filmsRecyclerView.adapter = adapter
        switch_btn.setOnClickListener(this)

        viewModel = ViewModelProvider(this).get(FilmViewModel::class.java)
        viewModel.getFilms().observe(this, Observer { films ->
            loadedList.clear()
            loadedList.addAll(films)
            filteringFilmsAndSet()
        })
    }

    private fun filteringFilmsAndSet(){
        val filteredList = if (switch_btn.isChecked) loadedList.filter { it.year == filterYear } else loadedList
        adapter.updateList(filteredList)
    }

    override fun onStop() {
        super.onStop()
        viewModel.cancelJob()
    }

    override fun onClick(v: View?) {
        filteringFilmsAndSet()
    }
}