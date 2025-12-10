package com.ahmed.a.habib.habibportfolio.presentation.navigation

import androidx.navigation.NavHostController
import com.ahmed.a.habib.habibportfolio.utils.projects_screen


class ProjectsNavigator : INavigator {
    override fun navigateTo(navController: NavHostController) {
        navController.navigate(projects_screen) { popUpTo(0) { inclusive = true } }
    }
}
