package com.ahmed.a.habib.habibportfolio.data.models


data class CertificateSection(
    val sectionNameResId: Int,
    val sectionIconResId: Int,
    val certificates: List<CertificateModel>,
)

data class CertificateModel(
    val imageResId: Int,
    val certificateNameResId: Int,
)