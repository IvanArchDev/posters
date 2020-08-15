package com.ivk.filmsposters.db

import android.content.Context
import androidx.room.Room

class DataBaseModule {

    private val dbName = "films_db"

    fun provideDb(context: Context) : FilmsDb {
        return  Room.databaseBuilder<FilmsDb>(
            context,
            FilmsDb::class.java,
            dbName)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
}