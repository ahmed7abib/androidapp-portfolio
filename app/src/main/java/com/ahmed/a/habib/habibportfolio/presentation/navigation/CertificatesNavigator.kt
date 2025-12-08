package com.ahmed.a.habib.habibportfolio.presentation.navigation

import androidx.navigation.NavHostController
import com.ahmed.a.habib.habibportfolio.certificates_screen


class CertificatesNavigator : INavigator {
    override fun navigateTo(navController: NavHostController) {
        navController.navigate(certificates_screen) { popUpTo(0) { inclusive = true } }
    }
}