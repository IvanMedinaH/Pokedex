package com.realform.macropaytestpokemon.presentation.ui.register

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.realform.macropaytestpokemon.data.errors.RegistryError
import com.realform.macropaytestpokemon.domain.models.user.User
import com.realform.macropaytestpokemon.domain.repository.login.IUserEmailPassRegistry
import com.realform.macropaytestpokemon.presentation.ui.utils.isStrongPassword
import com.realform.macropaytestpokemon.presentation.ui.utils.isValidEmail

private const val REGISTERVIEWMODEL = "VIEWMODEL"

class RegisterViewModel(private val userRegistry : IUserEmailPassRegistry):ViewModel() {
    val error: RegistryError = RegistryError.UserNotRegistered("")
    private val _userRegistered = mutableStateOf<Boolean>(false)
    val userRegistred:MutableState<Boolean> = _userRegistered

    private val _user = mutableStateOf<User>(User(phone = null))
    val user : MutableState<User> get() =   _user


    private val _errorMessage = mutableStateOf<String?>("")
    val errorMessage : MutableState<String?> get() =   _errorMessage



    fun onFirstNameChanged(name: String) {
        _user.value = _user.value.copy(firstName = name)
    }
    fun onLastNameChanged(lastName: String) {
        _user.value = _user.value.copy(lastName = lastName)
    }
    fun onEmailChanged(email: String) {
        _user.value = _user.value.copy(email = email)
    }
    fun onPasswordChanged(pass: String) {
        _user.value = _user.value.copy(psswrd = pass)
    }
    fun onPhoneChanged(phone: String) {
        _user.value = _user.value.copy(phone = phone)
    }

    fun showError():String?{
        return _errorMessage.value
    }

    fun validateStrongPassword(): Boolean {
        val isValid = isStrongPassword(_user.value.psswrd)
        Log.d("VALIDPassword",isValid.toString())
       return if (isValid) {
           _errorMessage.value = null
           true
        } else {
           _errorMessage.value = "Tu contraseña parece no ser segura. Utiliza al menos 1 mayúscula, 1 número y 1 carácter especial."
           false
        }
    }
    fun validateValidEmail(): Boolean {
        val isValid = isValidEmail(_user.value.email)
        Log.d("VALIDEmail",isValid.toString())
        return if (isValid) {
            _errorMessage.value = null
            true
        } else {
            _errorMessage.value = "El formato del email no es correcto."
            false
        }
    }
      fun validateIfBlankFields():Boolean{
        // Validar que los campos obligatorios no estén vacíos
     return   if ( _user.value.firstName.isBlank() ||
            _user.value.lastName.isBlank()  ||
            _user.value.email.isBlank() ||
            _user.value.psswrd.isBlank()) {
            _errorMessage.value = "Por favor, completa todos los campos obligatorios."
            false
        }else{
            _errorMessage.value =null
            true
        }
    }

    fun registerUser( ): Task<AuthResult> {
        // Ejecutar el registro del usuario y obtener el Task correspondiente
        val res = userRegistry.registerUserEmailAndPassword(_user.value)

        // Actualizar el estado de _userRegistered según el resultado del Task
        res.addOnCompleteListener { task ->
            _userRegistered.value = task.isSuccessful
            if (task.isSuccessful) {
                Log.d("VM", "ViewModel registered: ${_userRegistered.value}")
            } else {
                Log.e("VM", "Failed to register user: ${task.exception}")
            }
        }
        // Devolver el Task para que pueda ser ejecutado desde un OnClickListener
        return res
    }


}