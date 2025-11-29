package com.ahmed.a.habib.habibportfolio.presentation.utils

import com.ahmed.a.habib.habibportfolio.data.models.PersonalInfoModel
import com.ahmed.a.habib.habibportfolio.domain.models.MenuItemDto

data class UIStates (
    val summaryContent: Int? = null,
    val personalInfo: PersonalInfoModel? = null,
    val menuItems: List<MenuItemDto> = emptyList(),
)