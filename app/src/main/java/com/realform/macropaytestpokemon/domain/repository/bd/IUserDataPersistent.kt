package com.realform.macropaytestpokemon.domain.repository.bd

import com.realform.macropaytestpokemon.data.remote.model.user.UserRemoteDB

interface IUserDataPersistent {
    fun saveDataLocally(user: UserRemoteDB):Boolean
}