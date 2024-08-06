package com.realform.macropaytestpokemon.domain.repository.pokedexRepository

import com.realform.macropaytestpokemon.data.utils.ResultAPI
import com.realform.macropaytestpokemon.domain.models.pokemons_dotnet.master.PocketMonster

interface IPocketmonsterRepository {
    suspend fun getAllPokemons(): ResultAPI<List<PocketMonster>>
}