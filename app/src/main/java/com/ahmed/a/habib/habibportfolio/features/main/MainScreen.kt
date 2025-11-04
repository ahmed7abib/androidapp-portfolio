package com.ahmed.a.habib.habibportfolio.features.main


import android.annotation.SuppressLint
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView


@Composable
fun MainScreen() {
    FullWebView(url = "https://ahmed7abib.github.io/portfolio/")
}

@Composable
@SuppressLint("SetJavaScriptEnabled")
fun FullWebView(
    url: String = "https://www.google.com",
) {
    val context = LocalContext.current
    val webViewState = remember { WebView(context) }

    BackHandler(enabled = webViewState.canGoBack()) {
        webViewState.goBack()
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        AndroidView(
            factory = { webViewState },
            update = { view ->
                view.settings.javaScriptEnabled = true
                view.settings.domStorageEnabled = true
                view.webChromeClient = WebChromeClient()
                view.loadUrl(url)
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}
