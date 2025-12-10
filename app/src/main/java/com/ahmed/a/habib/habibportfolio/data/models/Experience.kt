package com.ahmed.a.habib.habibportfolio.data.models


data class ExperienceSection(
    val sectionNameResId: Int,
    val sectionIconResId: Int,
    val experience: List<ExperienceModel>,
)

data class ExperienceModel(
    val positionResId: Int,
    val companyNameResId: Int,
    val startDateResId: Int,
    val endDateResId: Int? = null,
    val responsibilitiesResId: Int,
    val isPresentWorkThere: Boolean,
)