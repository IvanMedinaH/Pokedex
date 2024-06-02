package com.realform.macropaytestpokemon.data.remote.model.pokemon.masterDTO

import com.google.gson.annotations.SerializedName

data class PokedexDTO(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val resultDTO: List<ResultDTO>
)