package com.realform.macropaytestpokemon.presentation.ui.designcomps

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.realform.macropaytestpokemon.presentation.ui.theme.ThemeColor.backgroundTransparent

@Preview
@Composable
fun prevLaunchCard(){
    LaunchCard(imageURL = "https://images2.imgbox.com/5b/02/QcxHUb5V_o.png",
        launchName = "FalconSat",
        launchHour ="2006-03-24T22:30:00.000Z" ,
        launchDetails ="Engine failure at 33 seconds and loss of vehicle" ,
        launchArticleURL="https://www.space.com/2196-spacex-inaugural-falcon-1-rocket-lost-launch.html",
        launchSuccess = false,
        onClick={}
    )
}

/*TODO: Use an object to show the state add a modifier to LaunchCard*/
@Composable
fun LaunchCard(
    imageURL:String,
    launchName:String,
    launchHour:String,
    launchDetails:String,
    launchArticleURL:String,
    launchSuccess:Boolean,
    onClick:(url:String)->Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation =  CardDefaults.cardElevation(
            defaultElevation = 20.dp
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier
            .padding(12.dp)
        ) {
            Box(modifier = Modifier.aspectRatio(3f / 4f)) {
                AsyncImage(
                    model = imageURL,// launch.links?.patch?.small,
                    contentDescription = "Launch Name:$launchName",
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color(0x80000000)),
                                startY = 0f,
                                endY = 550f
                            )
                        )
                ) {
                    Text(
                        text = launchName,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier
                            .padding(start = 10.dp, top = 15.dp)
                            .background(backgroundTransparent)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(2.dp)
                            .background(backgroundTransparent),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Box(){
                           Column() {
                               Text(
                                   text = launchDetails,
                                   color = MaterialTheme.colorScheme.onSecondary,
                                   style = MaterialTheme.typography.bodySmall,
                                   overflow = TextOverflow.Ellipsis,
                               )
                               Divider(modifier = Modifier.padding(start = 10.dp), thickness = 1.dp, color = Color.Blue)
                               Text(
                                   text = launchHour,
                                   color = MaterialTheme.colorScheme.onSecondary,
                                   style = MaterialTheme.typography.bodyMedium,
                                   fontWeight = FontWeight.Bold,
                               )
                               Text(
                                   text = launchSuccess.toString(),
                                   color = MaterialTheme.colorScheme.onSecondary,
                                   style = MaterialTheme.typography.bodyMedium,
                                   fontWeight = FontWeight.Bold,
                               )
                             HyperlinkText(
                                   text = "Want to know more?",
                                 launchArticleURL,
                                   onClick = {
                                       onClick(launchArticleURL)
                                   },
                                 modifier =Modifier.background(color= backgroundTransparent)
                                     .padding(horizontal = 4.dp, vertical = 4.dp)
                             )
                           }
                        }
                    }
                }
            }
        }
    }
}
