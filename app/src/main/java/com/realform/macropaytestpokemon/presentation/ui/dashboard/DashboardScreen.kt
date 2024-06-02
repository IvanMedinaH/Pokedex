package com.realform.macropaytestpokemon.presentation.ui.dashboard

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.realform.macropaytestpokemon.R
import com.realform.macropaytestpokemon.domain.models.user.BillingInformation
import com.realform.macropaytestpokemon.domain.models.user.UserFull
import com.realform.macropaytestpokemon.presentation.nav.optionsnavigation.ScreenOptions
import com.realform.macropaytestpokemon.presentation.ui.dashboard.dashboardedit.EditProfileForm
import kotlinx.coroutines.launch

@Composable
fun DashboardScreen(
    //backgroundImage: Painter, // Imagen de fondo
    user: UserFull, // Datos del usuario
    onOptionClicked: (ScreenOptions) -> Unit, // Callback para abrir el formulario de edición
    onUploadPhotoClick: () -> Unit // Callback para subir la foto del usuario
) {
    val coroutineScope = rememberCoroutineScope()
    var isEditing by remember { mutableStateOf(false) }
    var canOpen by remember { mutableStateOf(true)}
    var numb by remember { mutableStateOf(1) }
    var textoEsPrimo by remember { mutableStateOf("") }


    Column(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.weight(.6f)) {
            // Imagen de fondo
            Image(
                painter = painterResource(id = R.drawable.user_photo_background),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2.2f) // Proporción de 3:2,
            )
            // Columna para alinear el Card y los botones
            Column(
                modifier = Modifier
                    .padding(top = 55.dp) // Padding top de 250px
                    .fillMaxWidth()
            ) {

                    // Card con información del usuario
                    ProfileCard(user = user,enabled = canOpen, onEditClick = {
                        /* Acción de edición del perfil */
                        coroutineScope.launch {
                            numb++
                            if(isPrime(numb)){
                                isEditing=true
                                canOpen=false
                            }
                            Log.d("EDITING", "$isEditing")
                        }
                    })

            }
        }
        Column(
            modifier = Modifier
                .weight(1.6f)
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            // Agrega tus elementos aquí
            if (isEditing) {
                EditProfileForm(
                    user = user,
                    onSaveClick = { /* Realiza la acción de guardar */ },
                    onClose={
                        canOpen=true
                        isEditing=false
                    }
                )
            } else {
                DashboardOptions() {
                    onOptionClicked(it)
                   // Log.d("OPTION_SELECTED:",it.title)
                }
            }
        }
    }
}


fun isPrime(num: Int): Boolean {
    if (num <= 1) {
        return false
    }
    for (i in 2 until num) {
        if (num % i == 0) {
            return false
        }
    }
    return true
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    val backgroundImage = painterResource(id = R.drawable.user_photo_background)
    val user = UserFull(
        firstName = "John",
        lastName = "Doe",
        email = "john.doe@example.com",
        phone = "123456789",
        billingInformation = BillingInformation(),
        photoPath = ""
    )

    DashboardScreen(
        //backgroundImage = backgroundImage,
        user = user,
        onOptionClicked = {}
    ) {}
}