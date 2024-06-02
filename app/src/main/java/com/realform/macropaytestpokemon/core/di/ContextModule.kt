package com.realform.macropaytestpokemon.core.di

import android.content.Context
import com.realform.macropaytestpokemon.data.implrepository.webNavigationImpl.WebNavigatorImpl
import com.realform.macropaytestpokemon.domain.repository.website.IWebNavigator
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val webNavigation = module {
    single {
            provideWebNavigator(androidContext())
    }
}

private fun provideWebNavigator(androidContext: Context): IWebNavigator {
    return WebNavigatorImpl(androidContext)
}