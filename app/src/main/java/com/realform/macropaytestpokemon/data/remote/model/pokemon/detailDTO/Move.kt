package com.realform.macropaytestpokemon.data.remote.model.pokemon.detailDTO

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)