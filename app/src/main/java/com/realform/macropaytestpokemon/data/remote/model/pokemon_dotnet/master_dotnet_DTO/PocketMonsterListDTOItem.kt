package com.realform.macropaytestpokemon.data.remote.model.pokemon_dotnet.master_dotnet_DTO

import com.google.gson.annotations.SerializedName

data class PocketMonsterListDTOItem(
    val id: Int,
    @SerializedName("age")
    val age: String,
    @SerializedName("generation")
    val generation: Int,
    @SerializedName("imgUri")
    val imgUri: String,
    @SerializedName("level")
    val level: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: Int
)