package com.realform.macropaytestpokemon.presentation.nav.mainNavigation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.realform.macropaytestpokemon.R
import com.realform.macropaytestpokemon.domain.models.user.BillingInformation
import com.realform.macropaytestpokemon.domain.models.user.UserFull
import com.realform.macropaytestpokemon.presentation.nav.optionsnavigation.OptionsNavGraph
import com.realform.macropaytestpokemon.presentation.ui.dashboard.landing.LandingScreen
import com.realform.macropaytestpokemon.presentation.ui.designcomps.BottomSheetLayout
import com.realform.macropaytestpokemon.presentation.ui.login.LoginScreen
import com.realform.macropaytestpokemon.presentation.ui.pokedex.detail.PokedexDetailScreen
//import com.realform.macropaytestpokemon.presentation.ui.movies.detail.NowPlayingDetailScreen
//import com.realform.macropaytestpokemon.presentation.ui.movies.master.NowPlayingScreen
import com.realform.macropaytestpokemon.presentation.ui.pokedex.master.PokedexScreen
import com.realform.macropaytestpokemon.presentation.ui.register.RegisterScreen
import com.realform.macropaytestpokemon.presentation.ui.website.WebPage

val user = UserFull(
    firstName = "John",
    lastName = "Doe",
    email = "john.doe@example.com",
    phone = "123456789",
    billingInformation = BillingInformation(),
    photoPath = R.drawable.profilepic.toString()
)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnrememberedMutableState")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RootNavGraphNavigation(navHostController: NavHostController) {
    var isUserLoggedIn by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    var isClicked by mutableStateOf(false)

    NavHost(
        navController = navHostController,
        startDestination = Screen.LoginPage.route
    ) {

        ///region Landing
        composable(Screen.Landing.route) {
            if (!isClicked) {
                LandingScreen {
                    isClicked = true
                }
            } else {
                OptionsNavGraph(navHostController = rememberNavController())
            }
        }
        ///endRegion

        ///region LOGIN
        composable(Screen.LoginPage.route) {
            LoginScreen(
                onLoginSuccess = {
                    Log.d("Navigation", "Navigating to Main page")
                    navHostController.navigate(Screen.PokemonPage.route)
                },
                navigateToWebsite = { url ->
                    Log.d("Navigation", "Navigating to webpage")
                    navHostController.navigate(Screen.website.route + "/$url")
                },
                navigateToSignUp = {
                    Log.d("Navigation", "Navigating to Sign up")
                    navHostController.navigate(Screen.userRegistyPage.route)
                }
            )
            //navHostController.navigateUp() // Cerrar pantalla de inicio de sesión
        }
        ///endregion

        ///region REGISTRY
        composable(Screen.userRegistyPage.route) { backStackEntr ->
            RegisterScreen() {
                Log.d("Navigation", "Navigating to LoginPage")
                navHostController.navigate(Screen.LoginPage.route) {
                    // delete backstack
                    popUpTo(Screen.LoginPage.route) {
                        inclusive = true
                    }
                }
            }
        }
        ///endregion

        ///region WEBSITE
        composable(Screen.website.route + "/{url}") { backStackEntr ->
            Log.d("Navigation", "Entering website composable")
            WebPage(backStackEntr.arguments?.getString("url") ?: "")
        }
        ///endregion

        ///region POKEMON LIST
        composable(Screen.PokemonPage.route){
            PokedexScreen(navigateToDetail = {id->
                navHostController.navigate("${Screen.PokemonDetailPage.route}/$id")
            })
        }
        ///endregion

        ///region POKEMON DETAIL
        composable(Screen.PokemonDetailPage.route+ "/{id}"){backStackEntr ->
            Log.d("Navigation", "Entering Pokemon detail composable")
            PokedexDetailScreen(backStackEntr.arguments?.getString("id") ?: "")
        }
        ///endregion




        ///region Bottomsheet LoggedIN
        composable(Screen.LoggedInBottomSheet.route) {
            if (isUserLoggedIn) {
                // Mostrar BottomSheetScaffold cuando el usuario está logeado
                BottomSheetLayout()
            } else {
                // User Not logged in
                Text("Usuario no logeado")
            }
        }
        ///endregion




    }
}


sealed class Screen(val route: String) {
    object PokemonPage:Screen(route="POKEMONS")
    object PokemonDetailPage:Screen(route="POKEMONDETAIL")
    object Landing : Screen(route = "LANDING")
    object LoginPage : Screen(route = "LOGIN")
    object userRegistyPage : Screen(route = "REGISTRY")
    object website : Screen(route = "WWW")
    object Dashboard : Screen(route = "DASHBOARD")
    object LoggedInBottomSheet : Screen(route = "BOTTOMSHEETLOGGEDIN")
    object LaunchesListPage : Screen(route = "LAUNCHES")
    object LaunchDetailPage : Screen(route = "LAUNCHDETAIL")
    object FavLaunches : Screen(route = "FAVLAUNCHES")
}