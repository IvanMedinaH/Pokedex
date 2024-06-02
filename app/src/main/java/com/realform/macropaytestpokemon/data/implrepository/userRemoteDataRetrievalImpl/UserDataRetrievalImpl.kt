package com.realform.macropaytestpokemon.data.implrepository.userRemoteDataRetrievalImpl

import com.google.firebase.firestore.FirebaseFirestore
import com.realform.macropaytestpokemon.data.remote.model.user.UserRemoteDB
import com.realform.macropaytestpokemon.domain.repository.login.IUserDataRetrieval

class UserDataRetrievalImpl(private val firestore: FirebaseFirestore) : IUserDataRetrieval {
    override fun getUserById(userId: String, onSuccess: (UserRemoteDB?) -> Unit, onFailure: (Exception) -> Unit) {
        //referencia a la colección de usuarios en Firestore
        val usersCollection = firestore.collection("users")

        //consulta para buscar al usuario por su ID
        usersCollection.document(userId).get().addOnSuccessListener { firestoreDocument ->

                if (firestoreDocument != null && firestoreDocument.exists()) {
                    //El documento existe, puedes obtener los datos del usuario
                    val user = firestoreDocument.toObject(UserRemoteDB::class.java)
                    onSuccess(user)
                } else {
                    //El documento no existe, el usuario no fue encontrado
                    onSuccess(null)
                }
            }
            .addOnFailureListener { exception ->
                //error al intentar realizar la consulta
                onFailure(exception)
            }
    }
}
