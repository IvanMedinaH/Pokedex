package com.realform.macropaytestpokemon.domain.repository.nowPlaying

import com.realform.macropaytestpokemon.data.utils.ResultAPI
import com.realform.macropaytestpokemon.domain.models.nowPlayingModel.master.NowPlaying

interface IMoviesNowPlayingRepository {
    suspend fun getAllMoviesNowPlaying():ResultAPI<NowPlaying>
}