package com.realform.macropaytestpokemon.presentation.ui.login

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

private const val LOGINVIEWMODEL = "VIEWMODEL"

class LoginViewModel(private val auth: FirebaseAuth) : ViewModel() {

    private val _email = mutableStateOf("")
    val email: State<String> get() = _email

    private val _password = mutableStateOf("")
    val password: State<String> get() = _password

    private val _isLoginSuccess = mutableStateOf(false)
    val isLoginSuccess: State<Boolean> get() = _isLoginSuccess

    public fun ChallengeLogin(usr: String, psswrd: String) {
        _email.value = usr
        _password.value = psswrd

        Log.d(TAG, _email.value + " " + _password.value)
        Login()
    }


     fun Login(){
        auth.signInWithEmailAndPassword(_email.value, _password.value)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    Log.d(TAG, "signInWithEmail:success {${user?.email}}")
                    _isLoginSuccess.value=true
                } else {
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    _isLoginSuccess.value=false
                }
            }
    }

}