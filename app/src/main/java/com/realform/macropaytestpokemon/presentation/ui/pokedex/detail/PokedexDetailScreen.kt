package com.realform.macropaytestpokemon.presentation.ui.pokedex.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import com.realform.macropaytestpokemon.domain.models.pokemons.detail.PokeMonDetails
import com.realform.macropaytestpokemon.presentation.ui.pokedex.designComponents.PokemonCardDetail
import com.realform.macropaytestpokemon.presentation.ui.theme.ThemeColor
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokedexDetailScreen(id: String, viewModel: PokedexDetailViewModel = koinViewModel()
) {

    val isLoggedIn by viewModel.isLoggedIn.observeAsState(false)
    val isLoading by viewModel.isLoading.collectAsState(initial = false)
    val pokemon:PokeMonDetails

    LaunchedEffect(key1 = true) {
        viewModel.loadPokemonDetail(id)
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
                }
            )
        },

        content = { // Main content area
                paddingValues ->
            Column (modifier = Modifier
                .padding(paddingValues)
            ){
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    )
                }

                viewModel.pokemon.value?.let {
                    PokemonCardDetail(it)
                }

            }
        }

    )
}