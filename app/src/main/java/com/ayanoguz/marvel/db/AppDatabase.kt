package com.ayanoguz.marvel.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ayanoguz.marvel.db.dao.ExampleDao
import com.ayanoguz.marvel.db.entity.ExampleEntity

@Database(entities = [ExampleEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exampleDao(): ExampleDao
}