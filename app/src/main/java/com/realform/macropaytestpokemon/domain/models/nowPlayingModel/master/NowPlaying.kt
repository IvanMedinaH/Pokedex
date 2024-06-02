package com.realform.macropaytestpokemon.domain.models.nowPlayingModel.master

data class NowPlaying(
    val page: Int,
    val results: List<MovieInfo>,
    val total_pages: Int,
    val total_results: Int
)