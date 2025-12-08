package com.ahmed.a.habib.habibportfolio.domain.models

import com.ahmed.a.habib.habibportfolio.presentation.navigation.INavigator

data class MenuItemDto(
    val icon: Int,
    val title: Int,
    val navigator: INavigator,
)