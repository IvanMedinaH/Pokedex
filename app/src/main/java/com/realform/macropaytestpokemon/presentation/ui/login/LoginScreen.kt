package com.realform.macropaytestpokemon.presentation.ui.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.realform.macropaytestpokemon.R
import com.realform.macropaytestpokemon.presentation.ui.theme.ThemeColor
import org.koin.androidx.compose.koinViewModel


const val TAG ="LOGIN"

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel(),
    onLoginSuccess: () -> Unit,
    navigateToSignUp:()->Unit,
    navigateToWebsite:(url:String)->Unit
    ) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.fondo_login_pokedex), // Cambia a tu imagen de fondo
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .width(450.dp)
                //.fillMaxSize()
                .padding(top=160.dp, start=45.dp, end = 95.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedTextColor = ThemeColor.CherryPokemon,
                    unfocusedBorderColor = ThemeColor.DarkBorder,
                    unfocusedLabelColor = ThemeColor.CartoonGray,
                    focusedLabelColor = ThemeColor.FunnyBlue,
                    unfocusedLeadingIconColor = ThemeColor.GreenPokemon
                ),
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Email,
                        contentDescription = null,
                        tint = ThemeColor.FunnyBlue // Cambia el color del ícono aquí
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedTextColor = ThemeColor.CherryPokemon,
                    unfocusedBorderColor = ThemeColor.DarkBorder,
                    unfocusedLabelColor = ThemeColor.CartoonGray,
                    focusedLabelColor = ThemeColor.FunnyBlue,
                    unfocusedLeadingIconColor = ThemeColor.GreenPokemon
                ),
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            isPasswordVisible = !isPasswordVisible
                        }
                    ) {
                        Icon(
                            imageVector = if (isPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription = null,
                            tint = ThemeColor.FunnyBlue // Cambia el color del ícono aquí
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
            Column() {
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(
                        onClick = {
                            navigateToSignUp()
                        },
                        enabled = true
                    ) {
                        Text(
                            text = "Sign up",
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                    }

                    Text(
                        text = "/",
                        fontSize = 18.sp,
                        color = Color.Black
                    )

                    TextButton(
                        onClick = {
                            navigateToWebsite("realformstudio.com")
                        },
                        enabled = true
                    ) {
                        Text(
                            text = "Website",
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            // Manejar el caso en que el usuario deja campos vacíos
            if (errorMessage != null) {
                Text(
                    text = errorMessage!!,
                    color = Color.Red,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // Observe Login
            //Cl2545#$%
            //andrew@hotmail.com
            LaunchedEffect(viewModel.isLoginSuccess.value) {
                if (viewModel.isLoginSuccess.value) {
                    Log.d("Login", "User is Logged in: ${viewModel.isLoginSuccess.value}")
                    onLoginSuccess()
                }
            }

            Button(
                onClick = {
                    if (email.isBlank() || password.isBlank()) {
                        errorMessage = "Por favor, completa todos los campos."
                        return@Button
                    }
                    viewModel.ChallengeLogin(email, password)
                },
                colors = ButtonDefaults.buttonColors(containerColor =ThemeColor.GreenPokemon),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Log In")
            }
        }
    }
}


