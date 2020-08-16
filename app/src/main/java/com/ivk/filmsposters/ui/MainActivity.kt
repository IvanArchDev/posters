package com.ivk.filmsposters.ui

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.ivk.filmsposters.R
import com.ivk.filmsposters.adapters.PosterAdapter
import com.ivk.filmsposters.model.Film
import com.ivk.filmsposters.repository.RepositoryDbFilms
import com.ivk.filmsposters.viewModel.FilmViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var viewModel : FilmViewModel
    private var adapter = PosterAdapter()
    private val filterYear = 2020
    private val verticalCount = 3
    private val horizontalCount = 5
    private val loadedList: MutableList<Film> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        filmsRecyclerView.layoutManager = GridLayoutManager(this, getCountRow(), VERTICAL, false)
        filmsRecyclerView.adapter = adapter
        switch_btn.setOnClickListener(this)
        val cachedList = RepositoryDbFilms.getFilms()
        if (cachedList.isNotEmpty()) adapter.updateList(cachedList)
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

    private fun getCountRow() : Int {
        return if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            verticalCount
        } else{
            horizontalCount
        }
    }
}