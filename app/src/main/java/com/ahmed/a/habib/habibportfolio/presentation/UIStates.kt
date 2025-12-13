package com.ahmed.a.habib.habibportfolio.presentation

import com.ahmed.a.habib.habibportfolio.data.models.CertificateModel
import com.ahmed.a.habib.habibportfolio.data.models.EducationModel
import com.ahmed.a.habib.habibportfolio.data.models.ExperienceModel
import com.ahmed.a.habib.habibportfolio.data.models.PersonalInfoModel
import com.ahmed.a.habib.habibportfolio.data.models.ProjectModel
import com.ahmed.a.habib.habibportfolio.data.models.SummaryContent
import com.ahmed.a.habib.habibportfolio.domain.models.MenuItemDto
import com.ahmed.a.habib.habibportfolio.domain.models.SocialDto

data class UIStates(
    val summaryContent: SummaryContent? = null,
    val personalInfo: PersonalInfoModel? = null,
    val socialMedia: List<SocialDto> = emptyList(),
    val menuItems: List<MenuItemDto> = emptyList(),
    val projects: List<ProjectModel> = emptyList(),
    val educations: List<EducationModel> = emptyList(),
    val skills: List<Pair<Int, List<Int>>> = emptyList(),
    val certificates: List<CertificateModel> = emptyList(),
    val workExperience: List<ExperienceModel> = emptyList(),
)