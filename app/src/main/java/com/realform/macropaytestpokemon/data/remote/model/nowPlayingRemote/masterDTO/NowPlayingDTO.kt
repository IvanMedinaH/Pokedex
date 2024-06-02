package com.realform.macropaytestpokemon.data.remote.model.nowPlayingRemote.masterDTO

data class NowPlayingDTO(
    val dates: DatesDTO,
    val page: Int,
    val results: List<ResultDTO>,
    val total_pages: Int,
    val total_results: Int
)