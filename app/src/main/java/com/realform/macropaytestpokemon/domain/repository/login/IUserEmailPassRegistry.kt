package com.realform.macropaytestpokemon.domain.repository.login

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.realform.macropaytestpokemon.domain.models.user.User

interface IUserEmailPassRegistry {
    fun registerUserEmailAndPassword(user: User):Task<AuthResult>
    fun getID():String
}