package com.realform.macropaytestpokemon.presentation.ui.movies.master
/*
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cloud
import androidx.compose.material.icons.rounded.CloudOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.realform.macropaytestpokemon.R
import com.realform.macropaytestpokemon.presentation.ui.theme.ThemeColor
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NowPlayingScreen(
    viewModel: NowPlayingViewModel = koinViewModel(),
    navigateToDetail: (id: String) -> Unit
) {
    val lazyListState = rememberLazyListState()

    val isLoggedIn by viewModel.isLoggedIn.observeAsState(false)



    LaunchedEffect(key1 = true) {
        viewModel.loadNowPlayingMovies()
    }



    Scaffold(
        topBar = {
            // App Bar content
            TopAppBar(
                modifier = Modifier,
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = ThemeColor.pitchBlack,
                    actionIconContentColor = ThemeColor.clearSnow,
                    navigationIconContentColor = ThemeColor.clearSnow,
                    scrolledContainerColor = ThemeColor.ashGrey,
                    titleContentColor = ThemeColor.clearSnow,
                ),
                title = {
                    androidx.compose.material3.Text(
                        text =   buildAnnotatedString {
                            withStyle(style = SpanStyle(
                                fontWeight = FontWeight.ExtraBold,
                                color= ThemeColor.clearSnow,
                                fontSize = 28.sp)
                            ) {
                                append(stringResource(R.string.now_playing_movies))
                            }
                        },
                        color = ThemeColor.clearSnow,
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
                    viewModel.nowPlayingState.value?.let {
                        items(it.results) { movie ->
                           MovieItem(movie = movie) {
                                movie.id.let {
                                    Log.d("DETAIL_ID", it.toString())
                                    if (isLoggedIn) {
                                        navigateToDetail(it.toString())
                                    }
                                }
                            }
                        }
                    }
                }
            }
        },
        floatingActionButton = {
            //TODO Floating Action Button
        }
    )
}
*/
