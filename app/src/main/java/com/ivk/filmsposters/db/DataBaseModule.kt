package com.ivk.filmsposters.db

import android.app.Application
import androidx.room.Room

class DataBaseModule {

    private val dbName = "films_db"

    fun provideDb(application: Application) : FilmsDb {
        return  Room.databaseBuilder<FilmsDb>(
            application,
            FilmsDb::class.java,
            dbName)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
}