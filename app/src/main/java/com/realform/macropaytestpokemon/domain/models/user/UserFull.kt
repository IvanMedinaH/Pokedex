package com.realform.macropaytestpokemon.domain.models.user

data class UserFull(
    val id:String="",
    val firstName: String = "",
    val lastName: String = "",
    val phone: String?="",
    val email: String = "",
    val photoPath:String ="",
    val billingInformation: BillingInformation
)