package com.ahmed.a.habib.habibportfolio.data.models


data class HomeSection(
    val sectionName: Int,
    val sectionIcon: Int,
    val personalInfo: PersonalInfoModel,
)

data class PersonalInfoModel(
    val title: Int,
    val cvLink: Int,
    val fullName: Int,
)