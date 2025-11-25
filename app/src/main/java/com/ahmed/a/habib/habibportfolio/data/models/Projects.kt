package com.ahmed.a.habib.habibportfolio.data.models

data class ProjectsSection(
    val sectionName: Int,
    val sectionIcon: Int,
    val projects: List<ProjectModel>,
)

data class ProjectModel(
    val image: Int,
    val sectionName: Int,
    val projectName: Int,
    val description: Int,
)