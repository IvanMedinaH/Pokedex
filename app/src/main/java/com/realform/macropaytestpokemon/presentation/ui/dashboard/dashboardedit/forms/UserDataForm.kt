package com.realform.macropaytestpokemon.presentation.ui.dashboard.dashboardedit.forms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UserForm() {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    Card(
        modifier = Modifier
            .padding(16.dp),
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 28.dp
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            TextField(
                value = "",
                onValueChange = {
                    firstName= it
                                },
                label = { Text("Nombre") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = "",
                onValueChange = { lastName= it  },
                label = { Text("Apellido") }
            )
            Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = "",
                    onValueChange = { phone= it  },
                    label = { Text("Teléfono") }
                )

            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = "",
                onValueChange = {email= it  },
                label = { Text("Correo electrónico") }
            )
        }
    }
}


@Preview
@Composable
fun UserFormPreview() {
    UserForm()
}
