package com.realform.macropaytestpokemon.data.implrepository.userLocalDataRegistryDBImpl

import com.realform.macropaytestpokemon.data.local.db.ProfileDAO
import com.realform.macropaytestpokemon.data.local.db.entities.ProfileEntity
import com.realform.macropaytestpokemon.domain.repository.profiles.IProfileRepository

class ProfileRepositoryImpl(private val daoDB: ProfileDAO) : IProfileRepository {

    override suspend fun getAllProfiles(): List<ProfileEntity> {
        return daoDB.getAll()
    }

    override suspend fun getProfileById(id: String): ProfileEntity? {
        return daoDB.getProfileById(id)
    }

    override suspend fun deleteProfileById(id: String) {
        daoDB.deleteProfileById(id)
    }

    override suspend fun insertProfile(profile: ProfileEntity) {
        daoDB.insertProfile(profile)
    }
}
