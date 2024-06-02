package com.realform.macropaytestpokemon.domain.models.user

data class User(
    val email:String="",
    val psswrd:String="",
    val firstName:String="",
    val lastName:String="",
    val phone:String?,
)