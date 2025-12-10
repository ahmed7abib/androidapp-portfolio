package com.ahmed.a.habib.habibportfolio.data.models


data class SkillsSection(
    val sectionNameResId: Int,
    val sectionIconResId: Int,
    val skillsResId: Pair<Int, List<Int>>,
)