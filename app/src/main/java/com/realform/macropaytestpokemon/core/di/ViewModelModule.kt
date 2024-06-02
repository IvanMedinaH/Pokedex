package com.realform.macropaytestpokemon.core.di

import com.realform.macropaytestpokemon.presentation.ui.login.LoginViewModel
import com.realform.macropaytestpokemon.presentation.ui.movies.detail.NowPlayingDetailViewModel
import com.realform.macropaytestpokemon.presentation.ui.movies.master.NowPlayingViewModel
import com.realform.macropaytestpokemon.presentation.ui.pokedex.detail.PokedexDetailViewModel
import com.realform.macropaytestpokemon.presentation.ui.pokedex.master.PokedexViewModel
import com.realform.macropaytestpokemon.presentation.ui.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{PokedexDetailViewModel(get(),get())}
    viewModel{PokedexViewModel(get(),get())}
    viewModel{LoginViewModel(get())}
    viewModel{RegisterViewModel(get())}
}



