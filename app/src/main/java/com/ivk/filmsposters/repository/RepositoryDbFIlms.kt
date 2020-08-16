package com.ivk.filmsposters.repository

import com.ivk.filmsposters.FilmsApp
import com.ivk.filmsposters.model.Film

object RepositoryDbFilms {

    private val db = FilmsApp.getAppInstance().getDbInstance()

    fun insert(film: Film) = db.filmDao().insertFilm(film)

    fun insertAllFilms(films : List<Film>){
        films.forEach { film ->
            db.filmDao().insertFilm(film)
        }
    }

    fun getFilms() : List<Film> {
        return db.filmDao().getFilms()
    }

    fun clearDb() = db.filmDao().clearDb()
}