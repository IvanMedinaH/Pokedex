package com.realform.macropaytestpokemon.core.di

import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val firebaseModule = module{
    single{ FirebaseApp.initializeApp(androidApplication())}
    single{ FirebaseAuth.getInstance(get())}
    single{ FirebaseFirestore.getInstance()}
    single{ providesFirestore()}
}

fun providesFirestore(): FirebaseFirestore {
    return FirebaseFirestore.getInstance()
}
