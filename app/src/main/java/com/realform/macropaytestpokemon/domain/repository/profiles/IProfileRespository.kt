package com.realform.macropaytestpokemon.domain.repository.profiles

import com.realform.macropaytestpokemon.data.local.db.entities.ProfileEntity

interface IProfileRepository {
    suspend fun getAllProfiles(): List<ProfileEntity>
    suspend fun getProfileById(id: String): ProfileEntity?
    suspend fun deleteProfileById(id: String)
    suspend fun insertProfile(profile: ProfileEntity)
}