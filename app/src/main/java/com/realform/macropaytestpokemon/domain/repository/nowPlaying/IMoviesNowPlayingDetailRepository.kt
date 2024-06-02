package com.realform.macropaytestpokemon.domain.repository.nowPlaying

import com.realform.macropaytestpokemon.data.utils.ResultAPI
import com.realform.macropaytestpokemon.domain.models.nowPlayingModel.detailLocal.NowPlayingMovieDetail

interface IMoviesNowPlayingDetailRepository {
    suspend fun getNowPlayingMovieDetail(id:String): ResultAPI<NowPlayingMovieDetail>
}