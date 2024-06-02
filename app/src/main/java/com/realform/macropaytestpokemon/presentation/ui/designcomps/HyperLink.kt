package com.realform.macropaytestpokemon.presentation.ui.designcomps

import android.util.Log
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun HyperlinkText(
    text: String,
    url: String,
    onClick: (url: String) -> Unit,
    modifier: Modifier
) {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
            append(text)
            addStringAnnotation(
                tag = "URL",
                annotation = url,
                start = 0,
                end = text.length
            )
        }
    }

    ClickableText(
        text = annotatedString,
        style = TextStyle(
            color = MaterialTheme.colorScheme.primary,
            fontSize = 14.sp,
            fontFamily = FontFamily.SansSerif
        ),
        modifier= modifier
        ,
        onClick = { offset ->
            Log.d("ClickableText", "$offset -th character is clicked.")
            annotatedString.getStringAnnotations(tag = url, start=0, end = 10)
            onClick(url)
        }
    )
}