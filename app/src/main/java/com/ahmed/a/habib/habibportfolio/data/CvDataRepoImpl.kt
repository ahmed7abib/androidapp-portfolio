package com.ahmed.a.habib.habibportfolio.data


import com.ahmed.a.habib.habibportfolio.R
import com.ahmed.a.habib.habibportfolio.data.models.CertificateSection
import com.ahmed.a.habib.habibportfolio.data.models.CvModel
import com.ahmed.a.habib.habibportfolio.data.models.EducationSection
import com.ahmed.a.habib.habibportfolio.data.models.ExperienceSection
import com.ahmed.a.habib.habibportfolio.data.models.HomeSection
import com.ahmed.a.habib.habibportfolio.data.models.PersonalInfoModel
import com.ahmed.a.habib.habibportfolio.data.models.ProjectsSection
import com.ahmed.a.habib.habibportfolio.data.models.SkillsSection
import com.ahmed.a.habib.habibportfolio.data.models.SummarySection
import com.ahmed.a.habib.habibportfolio.domain.CvDataRepo

class CvDataRepoImpl : CvDataRepo {

    override fun getCvData(): CvModel {

        val home = HomeSection(
            sectionName = R.string.home,
            sectionIcon = R.drawable.home,
            personalInfo = PersonalInfoModel(
                title = R.string.title,
                cvLink = R.string.cv_link,
                fullName = R.string.full_name
            )
        )

        val skills = SkillsSection(
            sectionName = R.string.skills,
            sectionIcon = R.drawable.home,
            skills = "" to emptyList()
        )

        val summary = SummarySection(
            sectionName = R.string.summary_label,
            sectionIcon = R.drawable.home,
            summaryContent = R.string.summary
        )

        val projects = ProjectsSection(
            sectionName = R.string.projects,
            sectionIcon = R.drawable.home,
            projects = emptyList()
        )

        val education = EducationSection(
            sectionName = R.string.education,
            sectionIcon = R.drawable.home,
            education = emptyList()
        )

        val experience = ExperienceSection(
            sectionName = R.string.experience,
            sectionIcon = R.drawable.home,
            experience = emptyList()
        )

        val certificates = CertificateSection(
            sectionName = R.string.certificates,
            sectionIcon = R.drawable.home,
            certificates = emptyList()
        )

        return CvModel(
            home = home,
            skills = skills,
            summary = summary,
            projects = projects,
            education = education,
            experience = experience,
            certificates = certificates
        )
    }
}