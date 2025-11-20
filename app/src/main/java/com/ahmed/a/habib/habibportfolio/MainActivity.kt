package com.ahmed.a.habib.habibportfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahmed.a.habib.habibportfolio.features.home.HomeScreen
import com.ahmed.a.habib.habibportfolio.utils.theme.HabibPortfolioTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { HabibPortfolioTheme { MainApp() } }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = home_screen,
        modifier = Modifier.navigationBarsPadding()
    ) {
        composable(home_screen) { HomeScreen(navController) }
    }
}