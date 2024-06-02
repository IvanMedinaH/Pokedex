package com.realform.macropaytestpokemon.domain.models.user

data class BillingInformation(
    val id: String="",
    val street: String = "",
    val city: String="",
    val country: String = "",
    val state: String ="",
    val postalCode:String=""
)
