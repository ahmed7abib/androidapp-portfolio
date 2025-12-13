package com.ahmed.a.habib.habibportfolio.domain.models

data class SocialDto(
    val iconRes: Int,
    val email: Int? = null,
    val isEmail: Boolean? = false,
    val socialAppLink: Int? = null,
    val whatsappNumber: Int? = null,
    val isWhatsapp: Boolean? = false,
)
