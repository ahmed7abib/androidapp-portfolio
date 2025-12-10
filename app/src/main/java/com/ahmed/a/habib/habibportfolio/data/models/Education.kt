package com.ahmed.a.habib.habibportfolio.data.models


data class EducationSection(
    val sectionNameResId: Int,
    val sectionIconResId: Int,
    val education: List<EducationModel>,
)

data class EducationModel(
    val degreeResId: Int,
    val studyDateResId: Int,
    val facultyNameResId: Int,
    val universityNameResId: Int,
)