package com.ahmed.a.habib.habibportfolio.data.models


data class CertificateSection(
    val sectionNameResId: Int,
    val sectionIconResId: Int,
    val certificates: List<CertificateModel>,
)

data class CertificateModel(
    val dateResId: Int,
    val imageResId: Int,
    val industryResId: Int,
    val certificateNameResId: Int,
)