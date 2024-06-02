package com.realform.macropaytestpokemon.domain.repository.pokedexRepository

import com.realform.macropaytestpokemon.data.utils.ResultAPI
import com.realform.macropaytestpokemon.domain.models.pokemons.detail.PokeMonDetails

interface IPokedexDetailRepository {
    suspend fun getPokemonDetails(id:String): ResultAPI<PokeMonDetails>
}