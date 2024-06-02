package com.realform.macropaytestpokemon.presentation.ui.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.realform.macropaytestpokemon.R
import com.realform.macropaytestpokemon.domain.models.user.BillingInformation
import com.realform.macropaytestpokemon.domain.models.user.UserFull

@Composable
fun ProfileCard(
    user: UserFull,
    enabled:Boolean,
    onEditClick: () -> Unit // Callback para el evento de edición del perfil
) {
    val imageUri = rememberSaveable { mutableStateOf("") }
    val painter = rememberAsyncImagePainter(
        if (imageUri.value.isEmpty()) {
            R.drawable.profilepic
        } else {
            imageUri.value
        }
    )

    Card(
        modifier = Modifier.padding(start=16.dp, end=16.dp, bottom = 12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 28.dp
        )
    ) {
        Column {

            // Botón de edición en la esquina superior izquierda
            Row(
                modifier= Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = onEditClick,enabled=enabled) {
                    Icon(Icons.Default.Edit, contentDescription = "Editar")
                }
            }

            Row(
                modifier = Modifier.padding(start = 28.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Fotografía del usuario (lado izquierdo)
                Image(
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(25.dp))
                // Datos del usuario (lado derecho)
                Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                    Divider(color = Color.Gray, thickness = .35.dp)
                    Text(text = "Nombre: ${user.firstName + " " + user.lastName}",
                            fontSize = 10.sp)
                    Text(text = "Teléfono: ${user.phone}",
                        fontSize = 10.sp)
                    Text(text = "Correo electrónico: ${user.email}",
                        fontSize = 10.sp)
                    Text(text = "Dirección: ${
                        user.billingInformation.street +
                        "\n"+user.billingInformation.postalCode+"\n"+
                         user.billingInformation.city}",
                        fontSize = 10.sp)
                    Divider(color = Color.Gray, thickness = .35.dp)
                }
            }


        }
    }
}



@Preview(showBackground = true)
@Composable
fun ProfileCardPreview() {
    val user = UserFull(
        firstName = "John",
        lastName = "Doe",
        email = "john.doe@example.com",
        phone = "123456789",
        billingInformation = BillingInformation(),
        photoPath = R.drawable.profilepic.toString()
    )

    ProfileCard(
        user = user,
        enabled = true,
        onEditClick = { /* Acción de edición del perfil */ }
    )
}
