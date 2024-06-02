package com.realform.macropaytestpokemon.data.implrepository.userRemoteRegistryImpl

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.realform.macropaytestpokemon.data.remote.model.user.UserRemoteDB
import com.realform.macropaytestpokemon.domain.repository.login.IUserDataRegistry

//Mu$&mP14!5%
class UserDataRegistryImpl(private val db: FirebaseFirestore) : IUserDataRegistry {

    override fun saveUserData(user: UserRemoteDB): Boolean {
        val dbCollection = db.collection("Users")
        val id = user.id
        Log.d("USERID", "User ID : $id")
        var resultTask = false

        dbCollection.document(id).set(user).addOnCompleteListener { saveData ->
            if (saveData.isSuccessful) {
                resultTask = true
                Log.d("SUCCESS_USERID", "User ID registered : $resultTask")
            }
        }
        return resultTask
    }

}