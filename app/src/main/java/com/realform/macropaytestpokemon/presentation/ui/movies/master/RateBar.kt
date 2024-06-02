package com.realform.macropaytestpokemon.presentation.ui.movies.master

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun rateBar(
    size: Dp = 45.dp,
    starSize:Dp=25.dp,
    strokeWidth: Dp = 6.dp,
    progress: Float = 0f,
    startAngle: Float = 280f,
    backgroundArcColor: Color = Color.LightGray,
    progressArcColor1: Color = Color.Blue,
    progressArcColor2: Color = progressArcColor1
) {
    Canvas(modifier = Modifier.size(size)) {
        val strokeWidthPx = strokeWidth.toPx()
        val arcSize = size.toPx() - strokeWidthPx

        // Gradient Brush
        val gradientBrush = Brush.verticalGradient(
            colors = listOf(progressArcColor1, progressArcColor2, progressArcColor1)
        )
        // Background Arc Implementation
        drawArc(
            // Offset Half Stroke Width
            topLeft = Offset(strokeWidthPx / 2f, strokeWidthPx / 2f),
            color = backgroundArcColor,
            startAngle = 0f,
            sweepAngle = 360f,
            useCenter = false,
            size = Size(arcSize, arcSize),
            style = Stroke(width = strokeWidth.toPx())
        )


        // Progress Arc Implementation
        withTransform({
            rotate(degrees = startAngle, pivot = center)
        }) {
            drawArc(
                brush = gradientBrush,
                startAngle = 0f,
                sweepAngle = LoopingDecimals(progress) * 360,
                useCenter = false,
                topLeft = Offset(strokeWidthPx / 2, strokeWidthPx / 2),
                size = Size(arcSize, arcSize),
                style = Stroke(width = strokeWidthPx, cap = StrokeCap.Round)
            )
        }

        val starPath = Path().apply {
            moveTo(center.x, center.y - starSize.toPx() / 7f) // Top point
            lineTo(center.x + starSize.toPx() / 9f, center.y + starSize.toPx() / 5f) // Bottom-right point
            lineTo(center.x - starSize.toPx() / 5.4f, center.y) // Left point
            lineTo(center.x + starSize.toPx() / 5.4f, center.y) // Right point
            lineTo(center.x - starSize.toPx() / 9f, center.y + starSize.toPx() / 5f) // Bottom-left point
            close() // Close the path to form the star
        }
        drawPath(path = starPath, color = Color.Yellow, style = Stroke(width = 16f))
    }

}

fun LoopingDecimals(value: Float): Float {
    val res = value / 10.0f
    return res
}

    @Preview
@Composable
fun CustomerCircularProgressBarPreview() {
    rateBar(
        progress = 8.384f,
        progressArcColor1 = Color(0xFFD6DD20),
        progressArcColor2 = Color(0xFF726A28),
    )
}