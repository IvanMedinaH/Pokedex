package com.realform.macropaytestpokemon.data.mapper.user

import com.realform.macropaytestpokemon.data.local.db.entities.ProfileEntity
import com.realform.macropaytestpokemon.domain.models.user.UserFull

fun UserFull.toProfileEntity(): ProfileEntity {
    return ProfileEntity(
        id = this.id,
        firstName = this.firstName,
        lastName = this.lastName,
        phone = this.phone,
        email = this.email,
        photoPath = this.photoPath,
        street = this.billingInformation.street,
        city = this.billingInformation.city,
        country = this.billingInformation.country,
        state = this.billingInformation.state,
        postalCode = this.billingInformation.postalCode
    )
}