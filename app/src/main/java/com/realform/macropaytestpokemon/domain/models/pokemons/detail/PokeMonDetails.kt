package com.realform.macropaytestpokemon.domain.models.pokemons.detail


import com.realform.macropaytestpokemon.data.remote.model.pokemon.detailDTO.Move
import com.realform.macropaytestpokemon.data.remote.model.pokemon.detailDTO.Sprites
import com.realform.macropaytestpokemon.data.remote.model.pokemon.detailDTO.Stat
import com.realform.macropaytestpokemon.data.remote.model.pokemon.detailDTO.Type

data class PokeMonDetails (
    val number: Int,
    val height: Int,
    val name: String,
    val weight: Int,
    val moves:List<Move>
)