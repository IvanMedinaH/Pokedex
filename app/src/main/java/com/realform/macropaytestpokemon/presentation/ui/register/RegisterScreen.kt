package com.realform.macropaytestpokemon.presentation.ui.register

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel


@Composable
fun RegisterScreen(viewModel: RegisterViewModel = koinViewModel(), toLoginScreen:()->Unit) {

    var errorText by remember { mutableStateOf("") }

    //This can be refactor into an Object
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var canDisplayError by remember { mutableStateOf<Boolean> (false)}

    var isRegistrationSuccess by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = firstName,
            onValueChange ={

                firstName=it
                viewModel.onFirstNameChanged(firstName)
                           },
            label = { Text("First Name") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            isError = errorText.isNotEmpty(),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Text(
            text = errorText,
            color = Color.Red,
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = lastName,
            onValueChange ={
                lastName=it
                viewModel.onLastNameChanged(lastName)},
            label = { Text("Last Name") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange ={
                email=it
                viewModel.onEmailChanged(email)},
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

  Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange ={
                password=it
                viewModel.onPasswordChanged(password)
                errorMessage=null
                           },
            label = { Text("Password") },
            trailingIcon = {
                IconButton(
                    onClick = {
                        isPasswordVisible = !isPasswordVisible
                    }
                ) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                        contentDescription = null
                    )
                }
            },
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                capitalization = KeyboardCapitalization.None
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = phone,
            onValueChange = {
                phone=it
                viewModel.onPhoneChanged(phone)
                            },
            label = { Text("Phone (optional)") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (canDisplayError) {
            Text(
                text =viewModel.showError()!!,
                color = Color.Red,
                modifier = Modifier.fillMaxWidth()
            )
        }else{
            errorMessage=null
        }

        // Observe isRegistrationSuccess
        LaunchedEffect(isRegistrationSuccess) {
                // Do Navigation
            if(isRegistrationSuccess){
                Log.d("Registration", "User is registred: $isRegistrationSuccess")
                toLoginScreen()
            }
        }

        Button(
            onClick = {
                if (viewModel.validateIfBlankFields()) {
                    if (viewModel.validateValidEmail() && viewModel.validateStrongPassword()) {
                        CoroutineScope(Dispatchers.IO).launch {
                            // Llamar a registerUser y esperar a que se complete el Task
                           viewModel.registerUser().addOnCompleteListener{registrationTask->
                               // Verificar si el registro fue exitoso
                               if (registrationTask.isSuccessful) {
                                   CoroutineScope(Dispatchers.Main).launch {
                                       // Actualizar el estado de la pantalla y limpiar los campos
                                       isRegistrationSuccess = true
                                       firstName = ""
                                       lastName = ""
                                       phone = ""
                                       email = ""
                                       password = ""
                                       Log.d("REGISTER_SCREEN", "$isRegistrationSuccess")

                                       //TODO Mostrar un mensaje de usuario creado a través de Snackbar con Compose
                                       //TODO Navegar a la pantalla de inicio de sesión
                                       //Mo34%&3Rw
                                       //toLoginScreen()
                                   }
                               } else {
                                   // Registro fallido
                                   Log.e("REGISTER_SCREEN", "Failed to register user: ${registrationTask.exception}")
                               }
                            }
                        }
                    }
                } else {
                    canDisplayError = true
                    errorMessage = viewModel.showError()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Register")
        }
    }
}

