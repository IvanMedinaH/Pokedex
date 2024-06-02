package com.realform.macropaytestpokemon.presentation.ui.pokedex.master

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cloud
import androidx.compose.material.icons.rounded.CloudOff
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.realform.macropaytestpokemon.R
import com.realform.macropaytestpokemon.data.mapper.pokemons.ToDomain
import com.realform.macropaytestpokemon.presentation.ui.pokedex.designComponents.PokemonCardMaster
import com.realform.macropaytestpokemon.presentation.ui.theme.ThemeColor
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokedexScreen(viewModel: PokedexViewModel = koinViewModel(),
                  navigateToDetail: (id: String) -> Unit,
) {
    val lazyListState = rememberLazyListState()
    val isLoggedIn by viewModel.isLoggedIn.observeAsState(false)
    val pokemons by viewModel.pokemonos.observeAsState(null)
    val isLoading by viewModel.isLoading.collectAsState(initial = false)

    LaunchedEffect(key1 = true) {
        viewModel.loadAllPokemons()
    }

    LaunchedEffect(key1 = pokemons) {
        pokemons?.let {
            Log.d("PokedexScreen", "Pokemons loaded: ${it.results}")
        }
    }

    LaunchedEffect(key1 = lazyListState) {
        snapshotFlow {
            lazyListState.layoutInfo.visibleItemsInfo
        }
            .map { visibleItems -> visibleItems.lastOrNull()?.index }
            .distinctUntilChanged()
            .collect { lastVisibleItemIndex ->
                val totalItemCount = pokemons?.results?.size ?: 0

                if (lastVisibleItemIndex != null && lastVisibleItemIndex >= totalItemCount - 3) {
                    viewModel.loadAllPokemons()
                }
            }
    }


    Scaffold(
        topBar = {
            // App Bar content
            TopAppBar(
                modifier = Modifier,
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = ThemeColor.FunnyBlue,
                    actionIconContentColor = ThemeColor.CartoonGray,
                    navigationIconContentColor = ThemeColor.CartoonGray,
                    scrolledContainerColor = ThemeColor.ashGrey,
                    titleContentColor = ThemeColor.CartoonGray,
                ),
                title = {
                    Text(
                        text =   buildAnnotatedString {
                            withStyle(style = SpanStyle(
                                fontWeight = FontWeight.ExtraBold,
                                color= ThemeColor.ClearSnow,
                                fontSize = 28.sp)
                            ) {
                                append(stringResource(R.string.pokedex_list))
                            }
                        },
                        color = ThemeColor.ClearSnow,
                        fontWeight = FontWeight.Bold
                    )
                },
                actions = {
                    IconButton(
                        onClick = {
                            viewModel.setLoggedInStatus(!isLoggedIn)
                            if (!isLoggedIn) {
                                viewModel.signOut()
                            }
                        }
                    ) {
                        val icon = if (isLoggedIn) Icons.Rounded.Cloud else Icons.Rounded.CloudOff
                        Icon(
                            imageVector = icon,
                            contentDescription = if (isLoggedIn) "Logout" else "Login"
                        )
                    }
                }
            )
        },

        content = { // Main content area
                paddingValues ->
            Column (modifier = Modifier
                .padding(paddingValues)
            ){
                LazyColumn(
                    state = lazyListState,
                    modifier = Modifier.fillMaxSize()
                ) {
                    pokemons?.let {
                        items(it.results) { result ->
                            PokemonCardMaster(result.ToDomain()){ clickedPokemon ->
                                Log.d("PokedexScreen", "Pokemon clicked: ${clickedPokemon}")
                                navigateToDetail(clickedPokemon.toString())
                            }
                        }
                    }

                    if (isLoading) {
                        item {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                                    .wrapContentWidth(Alignment.CenterHorizontally)
                            )
                        }
                    }

                }
            }
        }

    )
}
