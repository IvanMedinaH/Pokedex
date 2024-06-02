package com.realform.macropaytestpokemon.shortcuts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.realform.macropaytestpokemon.presentation.ui.theme.AppTheme
import com.realform.macropaytestpokemon.presentation.ui.newPost.PostForm

class ShortCutsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                PostForm()
            }
        }
    }
}
