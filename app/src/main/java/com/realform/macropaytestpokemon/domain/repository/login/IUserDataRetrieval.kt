package com.realform.macropaytestpokemon.domain.repository.login

import com.realform.macropaytestpokemon.data.remote.model.user.UserRemoteDB

interface IUserDataRetrieval {
    fun getUserById(userId: String, onSuccess: (UserRemoteDB?) -> Unit, onFailure: (Exception) -> Unit)
}