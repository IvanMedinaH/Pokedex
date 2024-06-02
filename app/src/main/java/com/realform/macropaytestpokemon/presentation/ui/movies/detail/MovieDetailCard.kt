package com.realform.macropaytestpokemon.presentation.ui.movies.detail
/*
import androidx.compose.foundation.background
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
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.realform.macropaytestpokemon.core.consts.Secret
import com.realform.macropaytestpokemon.presentation.ui.theme.ThemeColor
import com.realform.macropaytestpokemon.presentation.ui.designcomps.HyperlinkText

@Composable
fun MovieDetailCard(
    posertPath:String,
    movieTitle:String,
    popularity:String,
    movieTagline:String,
    overview:String,
    onClick:(homepage:String)->Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp),
        elevation =  CardDefaults.cardElevation(
            defaultElevation = 20.dp
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier
            .padding(2.dp)
        ) {
            Box(modifier = Modifier.aspectRatio(3f / 4f)) {
                AsyncImage(
                    model = Secret.IMG_BASE_URL+posertPath,// launch.links?.patch?.small,
                    contentDescription = "",
                    modifier = Modifier.fillMaxWidth()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color(0x2055EED2)),
                                startY = 0f,
                                endY = 550f
                            )
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(2.dp)
                            .background(ThemeColor.backgroundTransparent),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Box(){
                            Column() {
                                Text(
                                    text = movieTagline,
                                    color = ThemeColor.Bianca,
                                    style = MaterialTheme.typography.bodySmall,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier=Modifier
                                        .padding(horizontal = 16.dp, vertical = 16.dp)
                                        .background(color= ThemeColor.backgroundTransparent)
                                )
                                Divider(modifier = Modifier.padding(start = 10.dp), thickness = 1.dp, color = ThemeColor.ashGrey)
                                Text(
                                    text = popularity,
                                    color = ThemeColor.Bianca,
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.Bold,
                                    modifier=Modifier
                                        .padding(horizontal = 16.dp, vertical = 16.dp)
                                        .background( color= ThemeColor.backgroundTransparent)
                                )
                            }
                        }


                    }
                }
            }

            Divider(modifier = Modifier.padding(start = 10.dp), thickness = 1.dp, color = Color.White)
            Text(
                text = overview,
                color = ThemeColor.EerieBlack,
                style = MaterialTheme.typography.bodyLarge,
                overflow = TextOverflow.Visible,
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp),
            )
            HyperlinkText(
                text = "Want to know more?",
                overview,
                onClick = {
                    onClick(overview)
                },
                modifier =Modifier.background(color= ThemeColor.backgroundTransparent)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
    }
}
*/

