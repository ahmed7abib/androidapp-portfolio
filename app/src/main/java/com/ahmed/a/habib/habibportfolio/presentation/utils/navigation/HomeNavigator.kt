package com.ahmed.a.habib.habibportfolio.presentation.utils.navigation

import androidx.navigation.NavHostController
import com.ahmed.a.habib.habibportfolio.home_screen


class HomeNavigator : INavigator {
    override fun navigateTo(navController: NavHostController) {
        navController.navigate(home_screen) { popUpTo(0) { inclusive = true } }
    }
}
