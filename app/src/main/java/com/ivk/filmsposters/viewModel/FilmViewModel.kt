package com.ivk.filmsposters.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ivk.filmsposters.model.FilmResponse
import com.ivk.filmsposters.repository.RepositoryApiFilms

class FilmViewModel  : ViewModel() {
    private val films: MutableLiveData<List<FilmResponse>> = MutableLiveData()

    fun getFilms(): MutableLiveData<List<FilmResponse>> {
        RepositoryApiFilms.getFilms(films)
        return films
    }

    fun cancelJob()= RepositoryApiFilms.cancelJobs()
}