package com.realform.macropaytestpokemon.data.remote.interfaceservice.nowPlayingService.master

import com.realform.macropaytestpokemon.core.consts.Secret
import com.realform.macropaytestpokemon.data.remote.model.nowPlayingRemote.masterDTO.NowPlayingDTO
import retrofit2.http.GET

interface  INowPlayingService {
    //@GET("${Secret.BASE_URL}/movie/now_playing")
    suspend fun getAllMoviesNowPlaying(): NowPlayingDTO
}