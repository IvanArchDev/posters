package com.ivk.filmsposters.network

import com.ivk.filmsposters.model.Film
import retrofit2.http.GET

interface ApiService {
    @GET("ar2code/apitest/master/movies.json")
    suspend fun getFilms() : List<Film>
}