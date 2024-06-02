package com.realform.macropaytestpokemon.presentation.ui.movies.detail
/*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.realform.macropaytestpokemon.presentation.ui.theme.ThemeColor
import org.koin.androidx.compose.koinViewModel



@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun NowPlayingDetailScreen(id: String, viewModel: NowPlayingDetailViewModel = koinViewModel()) {

    val movieItem = viewModel.nowPlayingmovieItemDetail .collectAsState()

    val movieDetail by rememberUpdatedState(movieItem.value)

    var articleURL = movieItem.value?.homepage

    LaunchedEffect(id) {
        viewModel.getNowPlayingMovieDetail(id)
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
                    Text(
                        text =   buildAnnotatedString {
                            withStyle(style = SpanStyle(
                                fontWeight = FontWeight.Normal,
                                color = ThemeColor.clearSnow,
                                fontSize = 12.sp)
                            ) {
                                append("Movie title: ")
                            }
                            withStyle(style = SpanStyle(
                                fontWeight = FontWeight.ExtraBold,
                                color= ThemeColor.clearSnow,
                                fontSize = 16.sp)
                            ) {
                                append("${movieItem.value?.title}")
                            }
                        },
                        color = ThemeColor.clearSnow,
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        },
        content = { // Main content area
                paddingValues->
            val layoutDirection = LocalLayoutDirection.current
            Box(
                modifier = Modifier
                    .padding(paddingValues)
            ) {
                val pageCount = 0
                val state = rememberPagerState(
                    initialPage = 0,
                    initialPageOffsetFraction = 0f
                ) {
                    pageCount
                }
                Column(
                    Modifier.verticalScroll(state = rememberScrollState())
                ){

                     MovieDetailCard(
                            posertPath = movieDetail?.poster_path.toString(),
                            movieTitle = movieDetail?.title.toString(),
                            popularity = movieDetail?.popularity.toString(),
                            movieTagline = movieDetail?.tagline.toString(),
                            overview = movieDetail?.overview.toString(),
                            onClick = {
                                articleURL?.let { url ->
                                    viewModel.LaunchWebsite(url) }
                            }
                        )

                }
            }
        },
        floatingActionButton = {
            //TODO Floating Action Button
        }
    )
}
*/