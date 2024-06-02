package com.realform.macropaytestpokemon.core.di.pokemons

import com.realform.macropaytestpokemon.data.implrepository.pokemonRepositoryImpl.master.PokedexRepositoryImpl
import com.realform.macropaytestpokemon.domain.repository.pokedexRepository.IPokedexRepository
import org.koin.dsl.module


val pokedexRepositoryModule = module {
    single <IPokedexRepository>{ PokedexRepositoryImpl (get()) }
}