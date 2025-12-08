package com.ahmed.a.habib.habibportfolio.presentation.navigation

import androidx.navigation.NavHostController
import com.ahmed.a.habib.habibportfolio.summary_screen


class SummaryNavigator : INavigator {
    override fun navigateTo(navController: NavHostController) {
        navController.navigate(summary_screen) { popUpTo(0) { inclusive = true } }
    }
}