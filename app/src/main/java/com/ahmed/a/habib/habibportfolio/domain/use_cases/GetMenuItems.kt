package com.ahmed.a.habib.habibportfolio.domain.use_cases

import com.ahmed.a.habib.habibportfolio.domain.CvDataRepo
import com.ahmed.a.habib.habibportfolio.domain.models.MenuItemDto
import com.ahmed.a.habib.habibportfolio.presentation.utils.navigation.CertificatesNavigator
import com.ahmed.a.habib.habibportfolio.presentation.utils.navigation.EducationNavigator
import com.ahmed.a.habib.habibportfolio.presentation.utils.navigation.ExperienceNavigator
import com.ahmed.a.habib.habibportfolio.presentation.utils.navigation.HomeNavigator
import com.ahmed.a.habib.habibportfolio.presentation.utils.navigation.ProjectsNavigator
import com.ahmed.a.habib.habibportfolio.presentation.utils.navigation.SkillsNavigator
import com.ahmed.a.habib.habibportfolio.presentation.utils.navigation.SummaryNavigator
import javax.inject.Inject

class GetMenuItems @Inject constructor(private val repo: CvDataRepo) {

    operator fun invoke(): List<MenuItemDto> {

        val list = arrayListOf<MenuItemDto>()

        val cvData = repo.getCvData()

        val home = MenuItemDto(
            navigator = HomeNavigator(),
            icon = cvData.home.sectionIcon,
            title = cvData.home.sectionName
        )

        val summary = MenuItemDto(
            navigator = SummaryNavigator(),
            icon = cvData.summary.sectionIcon,
            title = cvData.summary.sectionName
        )

        val experience = MenuItemDto(
            navigator = ExperienceNavigator(),
            icon = cvData.experience.sectionIcon,
            title = cvData.experience.sectionName
        )

        val projects = MenuItemDto(
            navigator = ProjectsNavigator(),
            icon = cvData.projects.sectionIcon,
            title = cvData.projects.sectionName
        )

        val skills = MenuItemDto(
            navigator = SkillsNavigator(),
            icon = cvData.skills.sectionIcon,
            title = cvData.skills.sectionName
        )

        val certifications = MenuItemDto(
            navigator = CertificatesNavigator(),
            icon = cvData.certificates.sectionIcon,
            title = cvData.certificates.sectionName
        )

        val education = MenuItemDto(
            navigator = EducationNavigator(),
            icon = cvData.education.sectionIcon,
            title = cvData.education.sectionName
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