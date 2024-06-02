package com.realform.macropaytestpokemon.presentation.nav.optionsnavigation

import android.annotation.SuppressLint
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.realform.macropaytestpokemon.presentation.nav.mainNavigation.user
import com.realform.macropaytestpokemon.presentation.ui.dashboard.DashboardScreen
import com.realform.macropaytestpokemon.presentation.ui.dashboard.options.bookingscreen.ScheduleConsultScreen
import com.realform.macropaytestpokemon.presentation.ui.dashboard.options.messages.MessageCenterScreen


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OptionsNavGraph(navHostController: NavHostController ) {

    var isUserLoggedIn by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    // Define una función para manejar la navegación según la opción seleccionada en el dashboard

    navigation(navHostController = navHostController)
}


@Composable
fun navigation(navHostController:NavHostController){
    NavHost(
        navController = navHostController,
        startDestination = ScreenOptions.Dashboard.route
    ) {
        composable(ScreenOptions.Dashboard.route){
            var selectedOption: ScreenOptions? = null
            val onOptionClicked: (ScreenOptions) -> Unit = { option ->
                selectedOption = option // Capturar la opción seleccionada
                navHostController.navigate(option.route) // Navegar a la ruta correspondiente
            }

            DashboardScreen(
                user = user,
                onUploadPhotoClick = {},
                onOptionClicked = {option->
                    selectedOption = option
                    onOptionClicked(option)
                }
            )
        }

        composable(ScreenOptions.RecentOrders.route) {
            //TODO RecentOrdersScreen()
           // onOptionClicked(ScreenOptions.RecentOrders)
        }
        composable(ScreenOptions.MyAddresses.route) {
            //TODO MyAddressesScreen()
           // onOptionClicked(ScreenOptions.MyAddresses)
        }
        composable(ScreenOptions.Messaging.route) {
            //TODO MessagingScreen()
            MessageCenterScreen()
        }
        composable(ScreenOptions.ScheduleConsult.route) {
            ScheduleConsultScreen()
        }
        composable(ScreenOptions.ScheduledDatesList.route) {
            //TODO ScheduledDatesListScreen()
        //    onOptionClicked(ScreenOptions.ScheduledDatesList)
        }
        composable(ScreenOptions.FavoriteProviders.route) {
            //TODO FavoriteProvidersScreen()
          //  onOptionClicked(ScreenOptions.FavoriteProviders)
        }

    }
}

sealed class ScreenOptions(val route: String) {
    object Dashboard : ScreenOptions(route = "DASHBOARD")
    object RecentOrders : ScreenOptions(route = "RECENTORDERS")
    object MyAddresses : ScreenOptions(route = "ADDRESSES")
    object Messaging : ScreenOptions(route = "MESSAGES")
    object ScheduleConsult : ScreenOptions(route = "SCHEDULE")
    object ScheduledDatesList : ScreenOptions(route = "SCHEDULEDDATES")
    object FavoriteProviders : ScreenOptions(route = "FAVORITES")
}