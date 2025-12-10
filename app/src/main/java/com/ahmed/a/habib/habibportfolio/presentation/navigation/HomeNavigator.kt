package com.ahmed.a.habib.habibportfolio.presentation.navigation

import androidx.navigation.NavHostController
import com.ahmed.a.habib.habibportfolio.utils.home_screen


class HomeNavigator : INavigator {
    override fun navigateTo(navController: NavHostController) {
        navController.navigate(home_screen) { popUpTo(0) { inclusive = true } }
    }
}
