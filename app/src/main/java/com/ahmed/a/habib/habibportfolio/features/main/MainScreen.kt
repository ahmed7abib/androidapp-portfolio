package com.ahmed.a.habib.habibportfolio.features.main


import android.annotation.SuppressLint
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.ahmed.a.habib.habibportfolio.R
import com.ahmed.a.habib.habibportfolio.contact_me_screen


@Composable
fun MainScreen(navController: NavHostController) {
    ConstraintLayout {
        val (webView, button) = createRefs()

        FullWebView(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(webView) {
                    top.linkTo(parent.top)
                    bottom.linkTo(button.top)
                }
                .padding(vertical = 22.dp),
            url = "https://ahmed7abib.github.io/portfolio/"
        )

        Button(
            onClick = { navController.navigate(contact_me_screen) },
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .padding(8.dp)
                .constrainAs(button) {
                    bottom.linkTo(parent.bottom)
                },
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = stringResource(R.string._contact_me),
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
@SuppressLint("SetJavaScriptEnabled")
fun FullWebView(
    modifier: Modifier,
    url: String = "https://www.google.com",
) {
    val context = LocalContext.current
    val webViewState = remember { WebView(context) }

    BackHandler(enabled = webViewState.canGoBack()) {
        webViewState.goBack()
    }

    Box(
        modifier = modifier
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
