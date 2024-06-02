package com.realform.macropaytestpokemon.data.implrepository.moviesRepositoryImpl.master

import com.realform.macropaytestpokemon.data.mapper.movies.toNowPlaying
import com.realform.macropaytestpokemon.data.remote.interfaceservice.nowPlayingService.master.INowPlayingService
import com.realform.macropaytestpokemon.data.utils.ResultAPI
import com.realform.macropaytestpokemon.domain.models.nowPlayingModel.master.NowPlaying
import com.realform.macropaytestpokemon.domain.repository.nowPlaying.IMoviesNowPlayingRepository

class MoviesRepositoryImpl(private val apiCall: INowPlayingService):IMoviesNowPlayingRepository {
    override suspend fun getAllMoviesNowPlaying(): ResultAPI<NowPlaying> {
        return try {
            ResultAPI.Success(apiCall.getAllMoviesNowPlaying().toNowPlaying())
        } catch (e: Exception) {
            ResultAPI.Error(e.message.toString())
        }
    }
}