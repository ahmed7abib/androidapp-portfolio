package com.ahmed.a.habib.habibportfolio.domain.use_cases

import com.ahmed.a.habib.habibportfolio.domain.CvDataRepo
import com.ahmed.a.habib.habibportfolio.domain.models.SocialDto
import javax.inject.Inject

class GetSocialMedia @Inject constructor(private val repo: CvDataRepo) {

    operator fun invoke(): List<SocialDto> {

        val social = repo.getCvData().socialMedia

        val gmail = social.email
        val whatsapp = social.whatsapp
        val socialApps = social.socialApp

        val gmailDto = SocialDto(
            isEmail = true,
            email = gmail.email,
            iconRes = gmail.iconRes
        )

        val whatsappDto = SocialDto(
            isWhatsapp = true,
            iconRes = whatsapp.iconRes,
            whatsappNumber = whatsapp.number
        )

        val socialAppDto = socialApps.map {
            SocialDto(
                iconRes = it.iconRes,
                socialAppLink = it.socialLink
            )
        }.toMutableList()

        socialAppDto.add(gmailDto)
        socialAppDto.add(whatsappDto)

        return socialAppDto
    }
}