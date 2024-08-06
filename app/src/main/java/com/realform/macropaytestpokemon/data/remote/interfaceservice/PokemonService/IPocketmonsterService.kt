package com.realform.macropaytestpokemon.data.remote.interfaceservice.PokemonService

import com.realform.macropaytestpokemon.core.consts.Secret
import com.realform.macropaytestpokemon.data.remote.model.pokemon_dotnet.master_dotnet_DTO.PocketMonsterListDTOItem
import retrofit2.http.GET
import retrofit2.http.Path

interface IPocketmonsterService {

        @GET("${Secret.API_LOCAL}fromPocketmonstersdb")
        suspend fun getAllPokemons(): List<PocketMonsterListDTOItem>


        @GET("${Secret.API_LOCAL}/{id}")
        suspend fun getPokemonDetails(@Path("id") id: Int): PocketMonsterListDTOItem

}