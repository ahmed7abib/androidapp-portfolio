package com.ahmed.a.habib.habibportfolio.features.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ahmed.a.habib.habibportfolio.R
import com.ahmed.a.habib.habibportfolio.main_screen
import com.ahmed.a.habib.habibportfolio.utils.commonUI.VerticalSpace
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {

    val logoOffsetY = remember { Animatable(-300f) }
    val headerOffsetY = remember { Animatable(400f) }

    LaunchedEffect(Unit) {
        logoOffsetY.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
        )

        headerOffsetY.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
        )

        delay(1000)
        navController.navigate(main_screen) {
            popUpTo(navController.graph.startDestinationId) { inclusive = true }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(250.dp)
                    .clip(CircleShape),
                contentDescription = "Logo",
                painter = painterResource(R.drawable.ic_logo)
            )

            VerticalSpace(24.dp)

            Column(
                modifier = Modifier.offset(y = headerOffsetY.value.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Hello, I'm Ahmed Adel Habib",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 24.sp
                )

                VerticalSpace(8.dp)

                Text(
                    text = "Senior Android Developer",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Light,
                    color = Color.Black,
                    fontSize = 18.sp
                )
            }
        }
    }
}