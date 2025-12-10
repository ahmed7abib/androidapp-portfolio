package com.ahmed.a.habib.habibportfolio.data.models


data class SummarySection(
    val sectionNameResId: Int,
    val sectionIconResId: Int,
    val summaryContent: SummaryContent,
)

data class SummaryContent(
    val fullSummaryResId: Int,
    val targetToBoldResId: Int,
)