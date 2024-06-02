package com.realform.macropaytestpokemon.domain.repository.pokedexRepository

import com.realform.macropaytestpokemon.data.utils.ResultAPI
import com.realform.macropaytestpokemon.domain.models.pokemons.master.Pokedex

interface IPokedexRepository {
    suspend fun getAllPokemons(offset: Int,limit: Int): ResultAPI<Pokedex>
}