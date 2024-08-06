package com.realform.macropaytestpokemon.domain.models.pokemons_dotnet.master

data class PocketMonster(
    val id: Int,
    val name: String,
    val imgUri: String,
    val age: String,
    val type: Int,
    val level: Int,
    val generation: Int
)
