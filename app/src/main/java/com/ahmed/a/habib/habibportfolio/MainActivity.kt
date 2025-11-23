package com.ahmed.a.habib.habibportfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahmed.a.habib.habibportfolio.presentation.main.HomeScreen
import com.ahmed.a.habib.habibportfolio.utils.theme.HabibPortfolioTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { HabibPortfolioTheme { MainApp() } }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = home_screen,
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        composable(home_screen) { HomeScreen(navController) }
    }
}