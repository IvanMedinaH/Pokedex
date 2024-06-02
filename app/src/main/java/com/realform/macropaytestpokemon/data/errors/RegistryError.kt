package com.realform.macropaytestpokemon.data.errors

sealed class RegistryError(messge:String) {
    class UserNotRegistered (message: String) : RegistryError(message)

}