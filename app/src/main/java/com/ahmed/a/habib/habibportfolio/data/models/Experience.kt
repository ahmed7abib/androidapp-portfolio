package com.ahmed.a.habib.habibportfolio.data.models


data class ExperienceSection(
    val sectionName: Int,
    val sectionIcon: Int,
    val experience: List<ExperienceModel>,
)

data class ExperienceModel(
    val position: Int,
    val endDate: Int,
    val startDate: Int,
    val companyName: Int,
    val isPresentWorkThere: Boolean,
)