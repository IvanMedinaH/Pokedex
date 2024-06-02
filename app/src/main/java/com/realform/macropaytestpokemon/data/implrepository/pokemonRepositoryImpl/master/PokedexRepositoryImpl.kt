package com.realform.macropaytestpokemon.data.implrepository.pokemonRepositoryImpl.master

import com.realform.macropaytestpokemon.data.mapper.pokemons.toPokedex
import com.realform.macropaytestpokemon.data.remote.interfaceservice.PokemonService.IPokedexService
import com.realform.macropaytestpokemon.data.utils.ResultAPI
import com.realform.macropaytestpokemon.domain.models.pokemons.master.Pokedex
import com.realform.macropaytestpokemon.domain.repository.pokedexRepository.IPokedexRepository

class PokedexRepositoryImpl(private val apiCall: IPokedexService) :IPokedexRepository {

    override suspend fun getAllPokemons(offset: Int, limit: Int): ResultAPI<Pokedex> {
        return try {
          ResultAPI.Success(apiCall.getAllPokemons(offset=offset,limit=limit).toPokedex())
        } catch (e: Exception) {
            ResultAPI.Error(e.message.toString())
        }
    }
}