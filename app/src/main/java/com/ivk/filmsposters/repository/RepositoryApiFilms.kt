package com.ivk.filmsposters.repository

import androidx.lifecycle.MutableLiveData
import com.ivk.filmsposters.model.Film
import com.ivk.filmsposters.network.RetrofitBuilder
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object RepositoryApiFilms {

    var job : CompletableJob? = null

    fun getFilms(filmsLD: MutableLiveData<List<Film>>) {
        job = Job()
        job?.let {
            CoroutineScope(IO + it).launch {
                val films = RetrofitBuilder.apiService.getFilms()
                RepositoryDbFilms.insertAllFilms(films)
                withContext(Main){
                    filmsLD.value = films
                    it.complete()
                }
            }
        }
    }

    fun cancelJobs() {
        job?.cancel()
    }
}