package com.ahmed.a.habib.habibportfolio.data.models

data class SocialMediaModel(
    val email: Email,
    val whatsapp: Whatsapp,
    val socialApp: List<SocialApplication>,
)

data class Email(
    val iconRes: Int,
    val email: Int,
)

data class Whatsapp(
    val iconRes: Int,
    val number: Int,
)

data class SocialApplication(
    val iconRes: Int,
    val socialLink: Int,
)