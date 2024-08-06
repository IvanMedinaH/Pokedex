package com.realform.macropaytestpokemon.data.mapper.pokemons

import com.realform.macropaytestpokemon.data.remote.model.pokemon_dotnet.master_dotnet_DTO.PocketMonsterListDTOItem
import com.realform.macropaytestpokemon.domain.models.pokemons_dotnet.master.PocketMonster

fun PocketMonsterListDTOItem.toDomain():PocketMonster{
    return PocketMonster(
        id = this.id,
        name = this.name,
        imgUri = this.imgUri,
        age = this.age,
        type = this.type,
        level = this.level,
        generation = this.generation
    )
}