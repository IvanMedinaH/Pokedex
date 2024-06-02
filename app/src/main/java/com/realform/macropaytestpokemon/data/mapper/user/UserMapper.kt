package com.realform.macropaytestpokemon.data.mapper.user

import com.realform.macropaytestpokemon.data.remote.model.user.UserRemoteDB
import com.realform.macropaytestpokemon.domain.models.user.User


fun User.toUserDB( userID:String):UserRemoteDB{
    return UserRemoteDB(
        id=userID,
        email=this.email,
        firstName=this.firstName,
        lastName=this.lastName,
        phone=this.phone,
        image = ""
    )
}