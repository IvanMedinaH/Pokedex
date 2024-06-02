package com.realform.macropaytestpokemon.presentation.ui.dashboard.options.myaddresses

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.realform.macropaytestpokemon.presentation.ui.dashboard.helpermodels.Message

@Composable
fun MyAddressesScreen(){
    val sampleMessages = listOf(
        Message("1", "f4gw45vs", "Pizza day", "Hello, how are you?", System.currentTimeMillis()),
        Message("2", "fe4tge12", "Promociones", "This is a test message", System.currentTimeMillis())
    )
    AddressesContainer(messages = sampleMessages)
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddressesContainer(messages: List<Message>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Messages") },
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()
            .padding(start = 12.dp,end=12.dp, bottom = 12.dp)) {
            val AppBarHeight = 56.dp
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = AppBarHeight)
            ) {
                items(messages) { message ->
                    AddressItem(message, {})
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}