package com.realform.macropaytestpokemon.presentation.ui.movies.master
/*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.realform.macropaytestpokemon.core.consts.Secret
import com.realform.macropaytestpokemon.domain.models.nowPlayingModel.master.MovieInfo
import com.realform.macropaytestpokemon.presentation.ui.theme.ThemeColor

@Composable
fun MovieItem(movie: MovieInfo, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 12.dp)
            .clickable {
                onClick()
            },
        elevation = CardDefaults.cardElevation(16.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column() {
            Box(
                modifier = Modifier.aspectRatio(16f / 16f)
            ) {
                AsyncImage(
                    model = Secret.IMG_BASE_URL+movie.poster_path,
                    contentDescription = "Image of ${movie.title}",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color(0x85152421)),
                                startY = 0f,
                                endY = 750f
                            )
                        )
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    movie.title.let {
                        Text(
                            text = it,
                            color = MaterialTheme.colorScheme.onSecondary,
                            style = MaterialTheme.typography.displayMedium,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.background(ThemeColor.backgroundTransparent)
                                .padding(6.dp)
                        )
                    }

                    movie.vote_average.let {
                        rateBar(
                            progress =it.toFloat(),
                            progressArcColor1 = Color(0xFFD6DD20),
                            progressArcColor2 = Color(0xFF726A28),
                        )
                    }
                }
            }
        }
    }
}
*/