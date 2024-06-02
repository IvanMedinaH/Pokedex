package com.realform.macropaytestpokemon.data.remote.model.user

data class UserRemoteDB(
    var id:String,
    val email:String?=null,
    val firstName:String?=null,
    val lastName:String?=null,
    val phone:String?=null,
    var image:String?=null
)