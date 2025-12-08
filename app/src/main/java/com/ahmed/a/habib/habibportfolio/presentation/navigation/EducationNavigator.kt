package com.ahmed.a.habib.habibportfolio.presentation.navigation

import androidx.navigation.NavHostController
import com.ahmed.a.habib.habibportfolio.education_screen


class EducationNavigator : INavigator {
    override fun navigateTo(navController: NavHostController) {
        navController.navigate(education_screen) { popUpTo(0) { inclusive = true } }
    }
}