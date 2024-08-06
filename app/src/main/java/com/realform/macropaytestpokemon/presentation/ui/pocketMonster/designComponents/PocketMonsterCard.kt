package com.realform.macropaytestpokemon.presentation.ui.pocketMonster.designComponents

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.realform.macropaytestpokemon.R
import com.realform.macropaytestpokemon.core.consts.Secret
import com.realform.macropaytestpokemon.domain.models.pokemons.master.PokemonMaster
import com.realform.macropaytestpokemon.domain.models.pokemons_dotnet.master.PocketMonster
import com.realform.macropaytestpokemon.presentation.ui.theme.ThemeColor

@Composable
fun PocketMonsterCard(pokemon: PocketMonster, onClick: (Int) -> Unit) {
    Card(
        border= BorderStroke(1.dp, ThemeColor.DarkBorder),
        shape = RoundedCornerShape(16.dp),
        elevation = 8.dp,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable {
                onClick(pokemon.id)
                Log.d("NUMBER","${pokemon.id}")
            } //  clic
    ) {
        Column {
            Box(
                modifier = Modifier
                    .height(290.dp)
                    .fillMaxWidth()
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                if(pokemon.id!=0){
                    AsyncImage(
                        model = pokemon.imgUri,
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }else {
                    Image(
                        painter = painterResource(id = R.drawable.ic_image_replaced),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    )
                }
            }
            /**************************************************************************************/
            /**************************************************************************************/
            /**************************************************************************************/
            /**************************************************************************************/
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Text(text = "Name: ${pokemon.name}", fontSize = 20.sp)
                Text(text = "Number: ${pokemon.id}", fontSize = 20.sp)
            }
        }
    }
}