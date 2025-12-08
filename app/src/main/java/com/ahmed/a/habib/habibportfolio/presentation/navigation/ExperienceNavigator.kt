package com.ahmed.a.habib.habibportfolio.presentation.navigation

import androidx.navigation.NavHostController
import com.ahmed.a.habib.habibportfolio.experience_screen


class ExperienceNavigator : INavigator {
    override fun navigateTo(navController: NavHostController) {
        navController.navigate(experience_screen) { popUpTo(0) { inclusive = true } }
    }
}
