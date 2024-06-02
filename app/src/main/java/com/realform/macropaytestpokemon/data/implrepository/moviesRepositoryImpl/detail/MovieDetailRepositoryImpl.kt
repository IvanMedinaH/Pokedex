package com.realform.macropaytestpokemon.data.implrepository.moviesRepositoryImpl.detail

import com.realform.macropaytestpokemon.data.mapper.movies.toNowPlayingMovieDetail
import com.realform.macropaytestpokemon.data.remote.interfaceservice.nowPlayingService.detail.INowPlayingDetailService
import com.realform.macropaytestpokemon.data.utils.ResultAPI
import com.realform.macropaytestpokemon.domain.models.nowPlayingModel.detailLocal.NowPlayingMovieDetail
import com.realform.macropaytestpokemon.domain.repository.nowPlaying.IMoviesNowPlayingDetailRepository
/*
class MovieDetailRepositoryImpl(private  val apiCall: INowPlayingDetailService):IMoviesNowPlayingDetailRepository {
    override suspend fun getNowPlayingMovieDetail(id: String): ResultAPI<NowPlayingMovieDetail> {
        return try {
            ResultAPI.Success(apiCall.getNowPlayingMovieDetail(id).toNowPlayingMovieDetail())
        } catch (e: Exception) {
            ResultAPI.Error(e.message.toString())
        }
    }
}
*/