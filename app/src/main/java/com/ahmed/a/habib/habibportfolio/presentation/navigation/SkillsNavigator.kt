package com.ahmed.a.habib.habibportfolio.presentation.navigation

import androidx.navigation.NavHostController
import com.ahmed.a.habib.habibportfolio.skills_screen


class SkillsNavigator : INavigator {
    override fun navigateTo(navController: NavHostController) {
        navController.navigate(skills_screen) { popUpTo(0) { inclusive = true } }
    }
}
