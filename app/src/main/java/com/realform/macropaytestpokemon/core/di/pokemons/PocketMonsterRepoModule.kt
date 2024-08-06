package com.realform.macropaytestpokemon.core.di.pokemons

import com.realform.macropaytestpokemon.data.implrepository.pocketmonsterRepositoryImpl.PocketmonsterRepositoryImpl
import com.realform.macropaytestpokemon.domain.repository.pokedexRepository.IPocketmonsterRepository
import org.koin.dsl.module


val pocketMonsterRepoModule = module {
    single <IPocketmonsterRepository>{ PocketmonsterRepositoryImpl (get()) }
}