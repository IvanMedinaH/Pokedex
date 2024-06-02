package com.realform.macropaytestpokemon.data.remote.interfaceservice.PokemonService

import com.realform.macropaytestpokemon.core.consts.Secret
import com.realform.macropaytestpokemon.data.remote.model.pokemon.masterDTO.PokedexDTO
import com.realform.macropaytestpokemon.data.remote.model.pokemon.detailDTO.PokemonDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IPokedexService {

        @GET("${Secret.POKEDEX_API}")
        suspend fun getAllPokemons(
            @Query("limit") limit: Int,
            @Query("offset") offset: Int
        ): PokedexDTO


        @GET("${Secret.POKEDEX_API}/{id}")
        suspend fun getPokemonDetails(@Path("id") id: Int): PokemonDTO
}