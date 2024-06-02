package com.realform.macropaytestpokemon.data.mapper.movies

import com.realform.macropaytestpokemon.data.remote.model.nowPlayingRemote.detailDTO.GenreDTO
import com.realform.macropaytestpokemon.data.remote.model.nowPlayingRemote.detailDTO.NowPlayingMovieDetailDTO
import com.realform.macropaytestpokemon.data.remote.model.nowPlayingRemote.masterDTO.NowPlayingDTO
import com.realform.macropaytestpokemon.data.remote.model.nowPlayingRemote.masterDTO.ResultDTO
import com.realform.macropaytestpokemon.domain.models.nowPlayingModel.detailLocal.Genre
import com.realform.macropaytestpokemon.domain.models.nowPlayingModel.detailLocal.NowPlayingMovieDetail
import com.realform.macropaytestpokemon.domain.models.nowPlayingModel.master.MovieInfo
import com.realform.macropaytestpokemon.domain.models.nowPlayingModel.master.NowPlaying

fun NowPlayingDTO.toNowPlaying(): NowPlaying {
    return NowPlaying(
        page = this.page,
        results = this.results.map {
            it.toMovieInfo()
        },
        total_pages = this.total_pages,
        total_results = this.total_results
    )
}

fun ResultDTO.toMovieInfo(): MovieInfo {
    return MovieInfo(
        id = this.id,
        poster_path = this.poster_path,
        title = this.title,
        video = this.video,
        vote_average = this.vote_average,
        vote_count = this.vote_count
    )
}

fun NowPlayingMovieDetailDTO.toNowPlayingMovieDetail():NowPlayingMovieDetail{
    return NowPlayingMovieDetail(
        title = this.title,
        homepage=this.homepage,
        overview=this.overview,
        poster_path=this.poster_path,
        popularity=this.popularity,
        tagline= this.tagline,
        genres= this.genres.map {
            it.toGenres()
        }
    )
}

fun GenreDTO.toGenres():Genre{
    return Genre(
        id=this.id,
        name=this.name
    )
}