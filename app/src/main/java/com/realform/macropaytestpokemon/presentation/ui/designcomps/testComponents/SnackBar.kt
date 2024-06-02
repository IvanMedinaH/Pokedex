package com.realform.macropaytestpokemon.presentation.ui.designcomps.testComponents

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.realform.macropaytestpokemon.presentation.ui.theme.ThemeColor
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@Composable
fun CustomSnackBar(user:String, launchSnackbar:Boolean) {
    var isSnackbarVisible by remember { mutableStateOf(false) }
    val snackbarHostState = remember {SnackbarHostState() }
    val scope= rememberCoroutineScope()
    Scaffold(
        snackbarHost = {
            Box() {
                SnackbarHost(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 0.dp)
                        .align(Alignment.BottomCenter),
                    hostState = snackbarHostState,
                    snackbar = { snackbarData: SnackbarData ->
                        Card(
                            modifier = Modifier
                                .padding(0.dp)
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
                            shape = RectangleShape
                        ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(4.dp),
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(color = ThemeColor.DenimBlue)
                                        .padding(top = 16.dp, bottom = 16.dp, start = 16.dp)
                                        .align(Alignment.CenterHorizontally)
                                ){
                                    Icon(
                                        imageVector = Icons.Default.Notifications,
                                        contentDescription = ""
                                    )
                                    Text(text = user)
                                }
                            }
                        }
                    }
                )
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            if(launchSnackbar) {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        message = "Bienvenido $user"
                    )
                }
            }
        }
     }
}



@Preview
@Composable
fun MyScreenPreview() {
    CustomSnackBar("Juan perez",false)
}
