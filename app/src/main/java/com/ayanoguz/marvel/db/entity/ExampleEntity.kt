package com.ayanoguz.marvel.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ExampleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 1
)