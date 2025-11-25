package com.ahmed.a.habib.habibportfolio.data.models


data class EducationSection(
    val sectionName: Int,
    val sectionIcon: Int,
    val education: List<EducationModel>,
)

data class EducationModel(
    val degree: Int,
    val studyDate: Int,
    val facultyName: Int,
    val universityName: Int,
)