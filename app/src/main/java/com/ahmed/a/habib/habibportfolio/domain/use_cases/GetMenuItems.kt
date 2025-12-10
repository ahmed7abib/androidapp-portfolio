package com.ahmed.a.habib.habibportfolio.domain.use_cases

import com.ahmed.a.habib.habibportfolio.domain.CvDataRepo
import com.ahmed.a.habib.habibportfolio.domain.models.MenuItemDto
import com.ahmed.a.habib.habibportfolio.presentation.navigation.CertificatesNavigator
import com.ahmed.a.habib.habibportfolio.presentation.navigation.EducationNavigator
import com.ahmed.a.habib.habibportfolio.presentation.navigation.ExperienceNavigator
import com.ahmed.a.habib.habibportfolio.presentation.navigation.HomeNavigator
import com.ahmed.a.habib.habibportfolio.presentation.navigation.ProjectsNavigator
import com.ahmed.a.habib.habibportfolio.presentation.navigation.SkillsNavigator
import com.ahmed.a.habib.habibportfolio.presentation.navigation.SummaryNavigator
import javax.inject.Inject

class GetMenuItems @Inject constructor(private val repo: CvDataRepo) {

    operator fun invoke(): List<MenuItemDto> {

        val list = arrayListOf<MenuItemDto>()

        val cvData = repo.getCvData()

        val home = MenuItemDto(
            navigator = HomeNavigator(),
            icon = cvData.home.sectionIconResId,
            title = cvData.home.sectionNameResId
        )

        val summary = MenuItemDto(
            navigator = SummaryNavigator(),
            icon = cvData.summary.sectionIconResId,
            title = cvData.summary.sectionNameResId
        )

        val experience = MenuItemDto(
            navigator = ExperienceNavigator(),
            icon = cvData.experience.sectionIconResId,
            title = cvData.experience.sectionNameResId
        )

        val projects = MenuItemDto(
            navigator = ProjectsNavigator(),
            icon = cvData.projects.sectionIconResId,
            title = cvData.projects.sectionNameResId
        )

        val skills = MenuItemDto(
            navigator = SkillsNavigator(),
            icon = cvData.skills.sectionIconResId,
            title = cvData.skills.sectionNameResId
        )

        val certifications = MenuItemDto(
            navigator = CertificatesNavigator(),
            icon = cvData.certificates.sectionIconResId,
            title = cvData.certificates.sectionNameResId
        )

        val education = MenuItemDto(
            navigator = EducationNavigator(),
            icon = cvData.education.sectionIconResId,
            title = cvData.education.sectionNameResId
        )

        list.add(home)
        list.add(summary)
        list.add(experience)
        list.add(projects)
        list.add(skills)
        list.add(certifications)
        list.add(education)

        return list
    }
}