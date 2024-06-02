package com.realform.macropaytestpokemon.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.realform.macropaytestpokemon.data.local.db.entities.ProfileEntity

// MyAppDatabase.kt
@Database(entities = [ProfileEntity::class], version = 1)
abstract class ProfileDB : RoomDatabase() {
    abstract fun userDao(): ProfileDAO
}