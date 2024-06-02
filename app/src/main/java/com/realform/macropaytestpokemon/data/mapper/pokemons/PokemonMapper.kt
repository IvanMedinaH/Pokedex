package com.realform.macropaytestpokemon.data.mapper.pokemons

import com.realform.macropaytestpokemon.core.consts.Secret
import com.realform.macropaytestpokemon.data.remote.model.pokemon.masterDTO.PokedexDTO
import com.realform.macropaytestpokemon.data.remote.model.pokemon.masterDTO.ResultDTO
import com.realform.macropaytestpokemon.data.remote.model.pokemon.detailDTO.PokemonDTO
import com.realform.macropaytestpokemon.domain.models.pokemons.detail.PokeMonDetails
import com.realform.macropaytestpokemon.domain.models.pokemons.master.Pokedex
import com.realform.macropaytestpokemon.domain.models.pokemons.master.PokemonMaster
import com.realform.macropaytestpokemon.domain.models.pokemons.master.Result
import java.util.Locale

fun PokedexDTO.toPokedex():Pokedex{
    return Pokedex(
        results = this.resultDTO.map { it.toResult() }
    )
}

fun ResultDTO.toResult(): Result {
    return Result(
        name = this.name,
        url = this.url
    )
}


fun Result.ToDomain():PokemonMaster{
    val arrayUrl = url.split("/")
    val id = arrayUrl[arrayUrl.size - 2].toInt()
    val name = name.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
    }
    val img = "${Secret.POKEDEX_IMG}$id.png"
    return PokemonMaster(
        name=name,
        number=id,
        img=img
    )
}

// Definición de la función de mapeo
fun PokemonDTO.toDomain(): PokeMonDetails {
    return PokeMonDetails(
        number = this.id,
        height = this.height,
        name = this.name,
        moves = this.moves,
        weight = this.weight
    )
}