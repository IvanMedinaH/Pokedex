package com.realform.macropaytestpokemon.core.di.signup

import com.realform.macropaytestpokemon.data.implrepository.userRemoteRegistryImpl.UserDataRegistryImpl
import com.realform.macropaytestpokemon.data.implrepository.userRemoteRegistryImpl.UserEmailPassRegistryImpl
import com.realform.macropaytestpokemon.domain.repository.login.IUserEmailPassRegistry
import org.koin.dsl.module

val signUpRepository= module{
    single { UserDataRegistryImpl(get()) }

    single<IUserEmailPassRegistry> {
        UserEmailPassRegistryImpl(
            auth = get(),  // Obtener la instancia de FirebaseAuth
            userDataRegistryImpl = get()  // Obtener la instancia de UserDataRegistryImpl
        )
    }
}