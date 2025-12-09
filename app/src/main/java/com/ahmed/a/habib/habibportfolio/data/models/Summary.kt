package com.ahmed.a.habib.habibportfolio.data.models


data class SummarySection(
    val sectionName: Int,
    val sectionIcon: Int,
    val summaryContent: SummaryContent,
)

data class SummaryContent(
    val fullSummary: Int,
    val targetToBold: Int,
)