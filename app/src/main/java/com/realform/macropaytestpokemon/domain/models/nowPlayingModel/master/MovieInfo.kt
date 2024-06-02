package com.realform.macropaytestpokemon.domain.models.nowPlayingModel.master

data class MovieInfo (
    val id: Int,
    val poster_path: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)