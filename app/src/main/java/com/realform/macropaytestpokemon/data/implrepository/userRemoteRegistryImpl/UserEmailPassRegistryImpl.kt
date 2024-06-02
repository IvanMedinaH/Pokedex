package com.realform.macropaytestpokemon.data.implrepository.userRemoteRegistryImpl

import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.realform.macropaytestpokemon.data.mapper.user.toUserDB
import com.realform.macropaytestpokemon.domain.models.user.User
import com.realform.macropaytestpokemon.domain.repository.login.IUserEmailPassRegistry

class UserEmailPassRegistryImpl(
    private val auth: FirebaseAuth,
    private val userDataRegistryImpl: UserDataRegistryImpl
) : IUserEmailPassRegistry {
    var isRegistryCompleted: Boolean = false

    override fun registerUserEmailAndPassword(user: User): Task<AuthResult> {
        return auth.createUserWithEmailAndPassword(user.email, user.psswrd).addOnCompleteListener { registerUserPasswordTask ->
            if (registerUserPasswordTask.isSuccessful) {
                var res = userDataRegistryImpl.saveUserData(user.toUserDB(getID()))
                if(res){
                             Log.d("IDSETUP", "ID settled: $res")
                             isRegistryCompleted = res
                     }
            } else{
                Log.w("Registration", "createUserWithEmail:failure", registerUserPasswordTask.exception)
            }
        }
    }

    override fun getID(): String {
        val userID = auth.currentUser?.uid ?: ""
        Log.d("USERID", "UserID: $userID")
        return userID
    }
}
