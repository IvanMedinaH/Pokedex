package com.realform.macropaytestpokemon.presentation.ui.dashboard.options.bookingscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.realform.macropaytestpokemon.domain.models.scheduledapointments.AppointmentInfo
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleConsultScreen() {
    var date by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    var reason by remember { mutableStateOf("") }
    val state = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)
    val openDialog = remember { mutableStateOf(true) }
    val calendar = Calendar.getInstance()
    calendar.set(1990, 0, 22) // add year, month (Jan), date
    // set the initial date
    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = calendar.timeInMillis)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        DatePicker(
            state = state,
            modifier = Modifier.padding(16.dp),
            //dateFormatter = DatePickerFormatter(),
             title = {
                 Text(text = "Selecciona la fecha")
            },
            headline = {
                Text(text = "Fecha")
            }
        )

        val formatter = SimpleDateFormat("dd MMMM yyyy", Locale.ROOT)
        Text(
            text = "Fecha: ${formatter.format(Date(datePickerState.selectedDateMillis!!))}"
        )

        TextField(
            value = time,
            onValueChange = { time = it },
            label = { Text("Hora") }
        )

        TextField(
            value = reason,
            onValueChange = { reason = it },
            label = { Text("Motivo de la consulta") }
        )

        Button(
            onClick = {
                val consultationInfo = AppointmentInfo(date, time, reason)
                //onScheduleConsult(consultationInfo)
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Programar Consulta")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun datePickerDialogs(openDialog:MutableState<Boolean>, state: DatePickerState){
    if (openDialog.value) {
        DatePickerDialog(
            onDismissRequest = {
                openDialog.value = false
            },

            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value= false
                    }
                ) {
                    Text("OK")
                }
            },

            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("CANCEL")
                }
            }
        ) {
            DatePicker(
                state = state
            )
        }
    }
}

@Preview
@Composable
fun ScheduleConsultScreenPreview() {
    ScheduleConsultScreen()
}