package com.realform.macropaytestpokemon.core.di

import androidx.room.Room
import com.realform.macropaytestpokemon.data.implrepository.userLocalDataRegistryDBImpl.ProfileRepositoryImpl
import com.realform.macropaytestpokemon.data.local.db.ProfileDB
import com.realform.macropaytestpokemon.domain.repository.profiles.IProfileRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
const val DB_NAME="LocalProfile"

val roomModule = module {

    // Define el repositorio como un proveedor de Koin
    single<IProfileRepository> {
        ProfileRepositoryImpl(get())
    }

    // Define la base de datos como un proveedor de Koin
    single {
        Room.databaseBuilder(androidContext(), ProfileDB::class.java, DB_NAME)
            .build()
    }

    // Define el DAO como un proveedor de Koin
    single {
        get<ProfileDB>().userDao()
    }
}

