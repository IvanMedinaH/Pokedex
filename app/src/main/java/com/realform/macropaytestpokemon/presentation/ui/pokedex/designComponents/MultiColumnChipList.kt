package com.realform.macropaytestpokemon.presentation.ui.pokedex.designComponents

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ChipColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.realform.macropaytestpokemon.presentation.ui.theme.ThemeColor

@Composable
fun MultiColumnChipList(chipLabels: List<String>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {
        items(chipLabels) {
            label ->
            SuggestionChip(
                colors = ChipColors(
                    containerColor = ThemeColor.ChipBlue,
                    labelColor = ThemeColor.ClearSnow,
                    leadingIconContentColor = ThemeColor.ClearSnow,
                    trailingIconContentColor = ThemeColor.ClearSnow,
                    disabledContainerColor = ThemeColor.CartoonGray,
                    disabledLabelColor = ThemeColor.CartoonGray,
                    disabledLeadingIconContentColor = ThemeColor.CartoonGray,
                    disabledTrailingIconContentColor = ThemeColor.CartoonGray
                ),
                onClick = { },
                label = {
                    Text(
                        text = label,
                        fontSize = 14.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                modifier = Modifier.padding(8.dp)
                    .border(1.dp, Color.Black, MaterialTheme.shapes.medium)
                    .shadow(4.dp, MaterialTheme.shapes.medium),
            )
        }
    }
}