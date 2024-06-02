package com.realform.macropaytestpokemon.presentation.ui.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.EventNote
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.realform.macropaytestpokemon.presentation.nav.optionsnavigation.ScreenOptions
import com.realform.macropaytestpokemon.presentation.ui.dashboard.helpermodels.Option


@Preview(showBackground = true)
@Composable
fun DashboardOptionsPreview() {
    DashboardOptions(onOptionSelected = {})
}

@Composable
fun DashboardOptions(onOptionSelected: (ScreenOptions) -> Unit) {
    val options = listOf(
        Option("Pedidos recientes", Icons.Default.ShoppingCart, ScreenOptions.RecentOrders),
        Option("Mis Direcciones", Icons.Default.LocationOn, ScreenOptions.MyAddresses),
        Option("Mensajes", Icons.Default.Chat, ScreenOptions.Messaging),
        Option("Agendar consulta", Icons.Default.EventNote, ScreenOptions.ScheduleConsult),
        Option("Mis fechas agendadas", Icons.Default.Event, ScreenOptions.ScheduledDatesList),
        Option("Proveedores favoritos", Icons.Default.Favorite, ScreenOptions.FavoriteProviders)
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(3) { rowIndex ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                repeat(2) { columnIndex ->
                    val index = rowIndex * 2 + columnIndex
                    if (index < options.size) {
                        val option = options[index]
                        CardOptionButton(option = option){
                            onOptionSelected(option.route)
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CardOptionButton(option: Option, onOptionSelected: (String) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .size(150.dp),
        onClick = { onOptionSelected(option.title) },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 28.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(top=15.dp, start = 35.dp, end = 30.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = option.icon,
                contentDescription = option.title,
                modifier = Modifier.size(64.dp),
                tint= Color.Gray
            )
            Text(
                text = option.title,
                color = Color.Black,
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
            )
        }
    }
}


