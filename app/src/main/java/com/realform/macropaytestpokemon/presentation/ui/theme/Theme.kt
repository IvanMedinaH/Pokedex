package com.realform.macropaytestpokemon.presentation.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext

private val DarkColorPalette = darkColorScheme(
    primary =  ThemeColor.Purple200,
    secondary =  ThemeColor.Teal200,
    background =  ThemeColor.pitchBlack,
    surface =  ThemeColor.pitchBlack,
    onPrimary =  ThemeColor.pitchBlack,
    onSecondary =  ThemeColor.ClearSnow,
    onBackground =  ThemeColor.ClearSnow,
    onSurface =  ThemeColor.ClearSnow,
)

private val LightColorPalette = lightColorScheme(
    primary = ThemeColor.pitchBlack,
    secondary = ThemeColor.Teal200,
    background =  ThemeColor.ClearSnow,
    surface = ThemeColor.ClearSnow,
    onPrimary =  ThemeColor.ClearSnow,
    onSecondary =  ThemeColor.ClearSnow,
    onBackground =  ThemeColor.backgroundTransparent,
    onSurface =  ThemeColor.pitchBlack,
)


@Composable
fun AppTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val AppColors = when {
        (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) -> {
            if (isDarkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }
        isDarkTheme -> lightColorScheme()
        else -> darkColorScheme()
    }
        MaterialTheme(
            colorScheme = AppColors,
            typography = AppTypography,
            shapes = AppShapes,
            content = content,
        )

}

object Apptheme{
    val sizes: DesignSizes
        @Composable
        @ReadOnlyComposable
        get() = DesignSizes()
}