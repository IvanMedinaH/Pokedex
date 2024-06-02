package com.realform.macropaytestpokemon.presentation.ui.website

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebPage(url: String) {
    // Utiliza AndroidView para integrar el WebView en la composición
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                // Habilita la ejecución de JavaScript en el WebView si es necesario
                settings.javaScriptEnabled = true

                // Configura el cliente del WebView para abrir en la misma instancia
                // (en lugar de abrir en el navegador externo)
                webViewClient = WebViewClient()

                // Carga la URL proporcionada
                loadUrl(url)
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}