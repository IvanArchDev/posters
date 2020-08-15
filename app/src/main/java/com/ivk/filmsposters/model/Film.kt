package com.ivk.filmsposters.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "films")
data class Film (
    @PrimaryKey(autoGenerate = true)
    private val id : Int,
    val url : String,
    val year : Int,
    val filmId : String
)