package com.realform.macropaytestpokemon.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.realform.macropaytestpokemon.data.local.db.entities.ProfileEntity

// UserDAO.kt
@Dao
interface ProfileDAO {
    @Query("SELECT * FROM profile")
    fun getAll(): List<ProfileEntity>

    @Query("SELECT * FROM profile WHERE id = :id")
    fun getProfileById(id: String): ProfileEntity?

    @Query("DELETE FROM profile WHERE id = :id")
    fun deleteProfileById(id: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProfile(profile: ProfileEntity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertAll(vararg users: ProfileEntity)
}