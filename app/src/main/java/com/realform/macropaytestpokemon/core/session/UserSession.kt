package com.realform.macropaytestpokemon.core.session

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

object UserSession {
    private var currentUser: FirebaseUser? = null

    fun start(auth: FirebaseAuth) {
        auth.addAuthStateListener { firebaseAuth ->
            currentUser = firebaseAuth.currentUser
        }
    }

    fun signOut(auth: FirebaseAuth) {
        auth.signOut()
    }

    fun isLoggedIn(): Boolean {
        return currentUser != null
    }

    fun getCurrentUser(): FirebaseUser? {
        return currentUser
    }
}