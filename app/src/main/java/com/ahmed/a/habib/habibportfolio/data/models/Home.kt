package com.ahmed.a.habib.habibportfolio.data.models


data class HomeSection(
    val sectionNameResId: Int,
    val sectionIconResId: Int,
    val personalInfo: PersonalInfoModel,
)

data class PersonalInfoModel(
    val titleResId: Int,
    val cvLinkResId: Int,
    val fullNameResId: Int,
)