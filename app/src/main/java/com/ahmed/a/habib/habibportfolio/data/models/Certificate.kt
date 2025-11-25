package com.ahmed.a.habib.habibportfolio.data.models


data class CertificateSection(
    val sectionName: Int,
    val sectionIcon: Int,
    val certificates: List<CertificateModel>,
)

data class CertificateModel(
    val image: Int,
    val certificateName: Int,
)