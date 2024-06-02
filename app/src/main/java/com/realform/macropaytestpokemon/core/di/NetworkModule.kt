package com.realform.macropaytestpokemon.core.di

import com.google.gson.Gson
import com.realform.macropaytestpokemon.core.consts.Secret
import com.realform.macropaytestpokemon.data.remote.interfaceservice.PokemonService.IPokedexService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    ///region pokemon
    single { providesIPokedexService(get()) }
    ///endregion

    single { providesParser() }
    single { providesOkHttpClient() }
    single {( providesRetrofit(get(),get()))}

}

fun providesParser(): Gson = Gson()
fun providesOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
    .apply {
        addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
    }
    .build()

fun providesRetrofit(converter: Gson, client:OkHttpClient): Retrofit {
    return  return Retrofit.Builder()
        .client(client)
        .baseUrl(Secret.POKEDEX_API)
        .addConverterFactory(GsonConverterFactory.create(converter))
        .build()
}

fun providesIPokedexService(retrofit: Retrofit): IPokedexService = retrofit.create(
    IPokedexService::class.java)


