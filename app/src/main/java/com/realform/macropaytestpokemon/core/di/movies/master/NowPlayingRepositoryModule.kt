package com.realform.macropaytestpokemon.core.di.movies.master

import com.realform.macropaytestpokemon.data.implrepository.moviesRepositoryImpl.master.MoviesRepositoryImpl
import com.realform.macropaytestpokemon.domain.repository.nowPlaying.IMoviesNowPlayingRepository
import org.koin.dsl.module


val nowPlayingRepository = module {
    single <IMoviesNowPlayingRepository>{ MoviesRepositoryImpl(get()) }
}