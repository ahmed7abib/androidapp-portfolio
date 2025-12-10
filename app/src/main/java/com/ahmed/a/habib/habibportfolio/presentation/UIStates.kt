package com.ahmed.a.habib.habibportfolio.presentation

import com.ahmed.a.habib.habibportfolio.data.models.ExperienceModel
import com.ahmed.a.habib.habibportfolio.data.models.PersonalInfoModel
import com.ahmed.a.habib.habibportfolio.data.models.SummaryContent
import com.ahmed.a.habib.habibportfolio.domain.models.MenuItemDto

data class UIStates(
    val summaryContent: SummaryContent? = null,
    val personalInfo: PersonalInfoModel? = null,
    val menuItems: List<MenuItemDto> = emptyList(),
    val workExperience: List<ExperienceModel> = emptyList(),
)