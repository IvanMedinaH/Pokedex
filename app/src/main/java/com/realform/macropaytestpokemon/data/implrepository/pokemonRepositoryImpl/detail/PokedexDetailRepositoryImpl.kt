package com.realform.macropaytestpokemon.data.implrepository.pokemonRepositoryImpl.detail

import com.realform.macropaytestpokemon.data.mapper.pokemons.toDomain
import com.realform.macropaytestpokemon.data.remote.interfaceservice.PokemonService.IPokedexService
import com.realform.macropaytestpokemon.data.utils.ResultAPI
import com.realform.macropaytestpokemon.domain.models.pokemons.detail.PokeMonDetails
import com.realform.macropaytestpokemon.domain.repository.pokedexRepository.IPokedexDetailRepository

class PokedexDetailRepositoryImpl(private val apiCall: IPokedexService): IPokedexDetailRepository {
    override suspend fun getPokemonDetails(id: String): ResultAPI<PokeMonDetails> {
        return try {
            ResultAPI.Success(apiCall.getPokemonDetails (id.toInt()).toDomain())
        } catch (e: Exception) {
            ResultAPI.Error(e.message.toString())
        }
    }
}