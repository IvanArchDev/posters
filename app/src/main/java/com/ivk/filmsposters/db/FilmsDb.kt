package com.ivk.filmsposters.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ivk.filmsposters.model.Film

@Database(entities = [Film::class], version = 1, exportSchema = false)
abstract class FilmsDb : RoomDatabase() {
    abstract fun filmDao() : FilmDao
}