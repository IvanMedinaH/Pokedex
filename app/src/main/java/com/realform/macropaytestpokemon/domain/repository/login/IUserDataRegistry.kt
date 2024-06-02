package com.realform.macropaytestpokemon.domain.repository.login

import com.realform.macropaytestpokemon.data.remote.model.user.UserRemoteDB

interface IUserDataRegistry {
    fun saveUserData( user: UserRemoteDB): Boolean

}