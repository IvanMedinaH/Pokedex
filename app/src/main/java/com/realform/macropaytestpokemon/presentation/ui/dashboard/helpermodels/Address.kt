package com.realform.macropaytestpokemon.presentation.ui.dashboard.helpermodels

data class Address(
    val addressId: String,
    val Street: String,
    val cp: String,
    val city: String,
    val state: String,
    val latitude: Double,
    val longitude: Double
)