package com.ahmed.a.habib.habibportfolio.data.models

data class ProjectsSection(
    val sectionNameResId: Int,
    val sectionIconResId: Int,
    val projects: List<ProjectModel>,
)

data class ProjectModel(
    val imageResId: Int,
    val projectNameResId: Int,
    val descriptionResId: Int,
)