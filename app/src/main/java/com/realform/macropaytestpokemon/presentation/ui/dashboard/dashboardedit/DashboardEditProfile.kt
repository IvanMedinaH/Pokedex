package com.realform.macropaytestpokemon.presentation.ui.dashboard.dashboardedit

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.realform.macropaytestpokemon.domain.models.user.BillingInformation
import com.realform.macropaytestpokemon.domain.models.user.UserFull
import com.realform.macropaytestpokemon.presentation.ui.dashboard.dashboardedit.forms.BillingInformationForm
import com.realform.macropaytestpokemon.presentation.ui.dashboard.dashboardedit.forms.UserForm
import com.realform.macropaytestpokemon.presentation.ui.designcomps.FormCarousel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EditProfileForm(
    user: UserFull, // Datos del usuario
    onSaveClick: (UserFull) -> Unit, // Callback para guardar los cambios
    onClose: () -> Unit
) {

    //region Image painter uri
    val imageUri = rememberSaveable { mutableStateOf("") }
    val painter = rememberAsyncImagePainter(
        if (imageUri.value.isEmpty()) {
          //  R.drawable.profilepic
        } else {
            imageUri.value
        }
    )
    val launcher  = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()){ uri:Uri?->
        uri?.let {
            imageUri.value = it.toString()
        }
    }
    //endregion

    Card(
        modifier = Modifier
            .padding(16.dp),
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 28.dp
        )
    ) {

        // Botón de edición en la esquina superior izquierda
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text=" Edit Profile",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            IconButton(onClick = onClose) {
                Icon(Icons.Default.Close, contentDescription = "Editar")
            }
        }
        Column(modifier = Modifier.padding(16.dp)
        ) {

            //region Load new Image
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                TextButton(
                    onClick = {
                        launcher.launch("image/*")
                    } ,
                ) {
                    Text("Cargar nueva imagen")
                }
                profileImage(painter)
            }
            //endregion

            //region FORMS
            /*Column(modifier = Modifier.padding(12.dp)) {
                // Campos de texto para editar la información del usuario
                TextField(
                    value = user.firstName,
                    onValueChange = { /* Actualiza el nombre del usuario */ },
                    label = { Text("Nombre") }
                )
                TextField(
                    value = user.lastName,
                    onValueChange = { /* Actualiza el apellido del usuario */ },
                    label = { Text("Apellido") }
                )
                user.phone?.let {
                    TextField(
                        value = it,
                        onValueChange = { /* Actualiza el teléfono del usuario */ },
                        label = { Text("Teléfono") }
                    )
                }
                TextField(
                    value = user.billingInformation.street,
                    onValueChange = { /* Actualiza la dirección del usuario */ },
                    label = { Text("Dirección") }
                )
                TextField(
                    value = user.email,
                    onValueChange = { /* Actualiza el correo electrónico del usuario */ },
                    label = { Text("Correo electrónico") }
                )
            }*/

            FormCarousel(
                modifier = Modifier.fillMaxSize(),
                slideDuration = 3.0f, // Duración del desplazamiento automático
                forms = formsList
            )

            //endregion

            //region Dots Indictors
            // IndicatorDot(modifier = Modifier, 8.dp,Color.Gray)
           /* DotsIndicator(modifier = Modifier,
                totalDots = 2,
                selectedIndex = 0,
                dotSize = 8.dp
            )*/
            //endregion

            //region BUTTONS
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Save changes
                OutlinedButton(
                    onClick = { onSaveClick(user) },
                    modifier = Modifier
                        .width(120.dp),
                    border = ButtonDefaults.outlinedButtonBorder.copy(
                        width = .25.dp,
                    ), // Outline color
                    shape = MaterialTheme.shapes.extraSmall
                ) {
                    Text("Guardar")
                }

                // Save changes
                FilledIconButton(
                    onClick = { onSaveClick(user) },
                    modifier = Modifier
                        .width(120.dp),
                    shape = MaterialTheme.shapes.extraSmall
                ) {
                    Text("Cancel")
                }
            }
            //endregion

        }
    }
}


val form1: @Composable () -> Unit = {
    UserForm()
}

val form2: @Composable () -> Unit = {
    BillingInformationForm()
}
val formsList = listOf(form1, form2)

@Composable
fun DotsIndicator(
    modifier: Modifier = Modifier,
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color =  Color.Black,
    unSelectedColor: Color =  Color.Gray ,
    dotSize: Dp
) {
    LazyRow(
        modifier = modifier
            .wrapContentWidth()
            .wrapContentHeight()
    ) {
        items(totalDots) { index ->
            IndicatorDot(
                color = if (index == selectedIndex) selectedColor else unSelectedColor,
                size = dotSize
            )

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}
@Composable
fun IndicatorDot(
    modifier: Modifier = Modifier,
    size: Dp,
    color: Color
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(color)
    )
}


@Composable
fun profileImage(painter: AsyncImagePainter ) {
    Image(
        painter = painter,
        contentDescription = "",
        modifier = Modifier
            .height(60.dp)
            .width(60.dp)
            .border(
                border = BorderStroke(
                    2.dp,
                    color = Color.Gray
                ),
                shape = RectangleShape
            )
    )
}

@Preview(showBackground = true)
@Composable
fun EditProfileFormPreview() {
    val user = UserFull(
        firstName = "John",
        lastName = "Doe",
        email = "john.doe@example.com",
        phone = "123456789",
        billingInformation = BillingInformation(street = "123 Main St"),
      //  photoPath = R.drawable.profilepic
    )

    EditProfileForm(
        user = user,
        onSaveClick = {},
        onClose = {}
    )
}





/*
@Composable
fun ImageUploadScreen(
    onImageSelected: (Uri) -> Unit
) {
    var selectedImageUri: Uri? by remember { mutableStateOf<Uri?>(null) }
    val getContent =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { result: Uri? ->
            result?.let { uri ->
                selectedImageUri = uri
            }
        }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = { getContent.launch("image/*") },
            content = { Text("Select Image") }
        )

        selectedImageUri?.let { uri ->
            // Display the selected image
            Image(
                painter = rememberImagePainter(uri),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )

            Button(
                onClick = { onImageSelected(uri) },
                content = { Text("Upload Image") }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ImageUploadScreenPreview() {
    ImageUploadScreen(onImageSelected = {})
}
*/