package com.realform.macropaytestpokemon.core.di.pokemons

import com.realform.macropaytestpokemon.data.implrepository.pokemonRepositoryImpl.detail.PokedexDetailRepositoryImpl
import com.realform.macropaytestpokemon.data.implrepository.pokemonRepositoryImpl.master.PokedexRepositoryImpl
import com.realform.macropaytestpokemon.domain.repository.pokedexRepository.IPokedexDetailRepository
import com.realform.macropaytestpokemon.domain.repository.pokedexRepository.IPokedexRepository
import org.koin.dsl.module


val pokedexDetailRepositoryModule = module {
    single <IPokedexDetailRepository>{ PokedexDetailRepositoryImpl (get()) }
}