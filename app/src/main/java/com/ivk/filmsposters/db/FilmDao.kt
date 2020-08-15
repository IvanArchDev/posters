package com.ivk.filmsposters.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ivk.filmsposters.model.Film
import retrofit2.http.DELETE

@Dao
interface FilmDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFilm(film: Film)

    @Query("SELECT * FROM films")
    fun getFilms() : List<Film>

    @DELETE
    fun clearDb()
}