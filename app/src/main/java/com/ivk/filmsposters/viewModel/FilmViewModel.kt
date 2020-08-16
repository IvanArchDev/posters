package com.ivk.filmsposters.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ivk.filmsposters.model.Film
import com.ivk.filmsposters.repository.RepositoryApiFilms

class FilmViewModel  : ViewModel() {
    private val films: MutableLiveData<List<Film>> = MutableLiveData()

    fun getFilms(): MutableLiveData<List<Film>> {
        RepositoryApiFilms.getFilms(films)
        return films
    }

    fun cancelJob()= RepositoryApiFilms.cancelJobs()
}