package com.ahmed.a.habib.habibportfolio.domain.use_cases

import com.ahmed.a.habib.habibportfolio.domain.CvDataRepo
import com.ahmed.a.habib.habibportfolio.domain.models.CvSection
import com.ahmed.a.habib.habibportfolio.domain.models.MenuItemDto
import javax.inject.Inject

class GetMenuItems @Inject constructor(private val repo: CvDataRepo) {

    operator fun invoke(): List<MenuItemDto> {

        val list = arrayListOf<MenuItemDto>()

        val cvData = repo.getCvData()

        val home = MenuItemDto(
            cvSection = CvSection.HOME,
            icon = cvData.home.sectionIcon,
            title = cvData.home.sectionName
        )

        val summary = MenuItemDto(
            cvSection = CvSection.SUMMARY,
            icon = cvData.summary.sectionIcon,
            title = cvData.summary.sectionName
        )

        val experience = MenuItemDto(
            cvSection = CvSection.EXPERIENCE,
            icon = cvData.experience.sectionIcon,
            title = cvData.experience.sectionName
        )

        val projects = MenuItemDto(
            cvSection = CvSection.PROJECTS,
            icon = cvData.projects.sectionIcon,
            title = cvData.projects.sectionName
        )

        val skills = MenuItemDto(
            cvSection = CvSection.SKILLS,
            icon = cvData.skills.sectionIcon,
            title = cvData.skills.sectionName
        )

        val certifications = MenuItemDto(
            cvSection = CvSection.CERTIFICATES,
            icon = cvData.certificates.sectionIcon,
            title = cvData.certificates.sectionName
        )

        val education = MenuItemDto(
            cvSection = CvSection.EDUCATION,
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