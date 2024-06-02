package com.realform.macropaytestpokemon.domain.models.nowPlayingModel.detailLocal

data class NowPlayingMovieDetail(
    val title: String="",
    val homepage: String="",
    val overview: String="",
    val poster_path: String="",
    val popularity: Double=0.0,
    val tagline: String="",
    val genres: List<Genre> = emptyList()
)
