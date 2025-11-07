package com.ahmed.a.habib.habibportfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahmed.a.habib.habibportfolio.features.contact_me.ContactMeScreen
import com.ahmed.a.habib.habibportfolio.features.main.MainScreen
import com.ahmed.a.habib.habibportfolio.features.splash.SplashScreen
import com.ahmed.a.habib.habibportfolio.utils.theme.HabibPortfolioTheme


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
        startDestination = splash_screen,
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        composable(splash_screen) { SplashScreen(navController) }
        composable(main_screen) { MainScreen(navController) }
        composable(contact_me_screen) { ContactMeScreen() }
    }
}