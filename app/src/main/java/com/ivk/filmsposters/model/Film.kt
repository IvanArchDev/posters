package com.ivk.filmsposters.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "films")
data class Film (
    @PrimaryKey
    val id : Int,
    val poster : String,
    val year : Int
)