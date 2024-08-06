package com.realform.macropaytestpokemon

import android.app.Application
import com.realform.macropaytestpokemon.core.di.firebaseModule
import com.realform.macropaytestpokemon.core.di.networkModule
import com.realform.macropaytestpokemon.core.di.pokemons.pocketMonsterRepoModule
import com.realform.macropaytestpokemon.core.di.pokemons.pokedexDetailRepositoryModule
import com.realform.macropaytestpokemon.core.di.pokemons.pokedexRepositoryModule
import com.realform.macropaytestpokemon.core.di.roomModule
import com.realform.macropaytestpokemon.core.di.signup.signUpRepository
import com.realform.macropaytestpokemon.core.di.viewModelModule
import com.realform.macropaytestpokemon.core.di.webNavigation
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PokemonApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Log Koin into Android logger information for logcat
            androidLogger()
            // Reference Android context
            androidContext(this@PokemonApplication)
            // Load modules
            modules(
                networkModule,
                viewModelModule,
                pocketMonsterRepoModule,
                pokedexRepositoryModule,
                pokedexDetailRepositoryModule,
                signUpRepository,
                webNavigation,
                firebaseModule,
                roomModule
            )
        }
    }
}