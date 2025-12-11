package com.ahmed.a.habib.habibportfolio.data.models


data class EducationSection(
    val sectionNameResId: Int,
    val sectionIconResId: Int,
    val education: List<EducationModel>,
)

data class EducationModel(
    val countryResId: Int,
    val universityResId: Int,
    val studyDateResId: Int,
    val educationFieldResId: Int,
    val educationDegreeResId: Int,
)