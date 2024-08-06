package com.realform.macropaytestpokemon.data.implrepository.pocketmonsterRepositoryImpl

import com.realform.macropaytestpokemon.data.mapper.pokemons.toDomain
import com.realform.macropaytestpokemon.data.remote.interfaceservice.PokemonService.IPocketmonsterService
import com.realform.macropaytestpokemon.data.utils.ResultAPI
import com.realform.macropaytestpokemon.domain.models.pokemons_dotnet.master.PocketMonster
import com.realform.macropaytestpokemon.domain.repository.pokedexRepository.IPocketmonsterRepository

class PocketmonsterRepositoryImpl(private val apiCall: IPocketmonsterService) : IPocketmonsterRepository {
    override suspend fun getAllPokemons(): ResultAPI<List<PocketMonster>> {
        return try {
            ResultAPI.Success(apiCall.getAllPokemons().map {
                it.toDomain()
            } )
        } catch (e: Exception) {
            ResultAPI.Error(e.message.toString())
        }
    }

}