package com.ahmed.a.habib.habibportfolio.data

import com.ahmed.a.habib.habibportfolio.R
import com.ahmed.a.habib.habibportfolio.data.models.CertificateSection
import com.ahmed.a.habib.habibportfolio.data.models.CvModel
import com.ahmed.a.habib.habibportfolio.data.models.EducationSection
import com.ahmed.a.habib.habibportfolio.data.models.ExperienceModel
import com.ahmed.a.habib.habibportfolio.data.models.ExperienceSection
import com.ahmed.a.habib.habibportfolio.data.models.HomeSection
import com.ahmed.a.habib.habibportfolio.data.models.PersonalInfoModel
import com.ahmed.a.habib.habibportfolio.data.models.ProjectsSection
import com.ahmed.a.habib.habibportfolio.data.models.SkillsSection
import com.ahmed.a.habib.habibportfolio.data.models.SummaryContent
import com.ahmed.a.habib.habibportfolio.data.models.SummarySection
import com.ahmed.a.habib.habibportfolio.domain.CvDataRepo

class CvDataRepoImpl : CvDataRepo {

    override fun getCvData(): CvModel {

        val home = HomeSection(
            sectionNameResId = R.string.home,
            sectionIconResId = R.drawable.home,
            personalInfo = PersonalInfoModel(
                titleResId = R.string.senior_position,
                cvLinkResId = R.string.cv_link,
                fullNameResId = R.string.full_name
            )
        )

        val summary = SummarySection(
            sectionNameResId = R.string.summary_label,
            sectionIconResId = R.drawable.home,
            summaryContent = SummaryContent(
                fullSummaryResId = R.string.summary,
                targetToBoldResId = R.string.target_to_bold
            )
        )

        val experience = ExperienceSection(
            sectionNameResId = R.string.experience,
            sectionIconResId = R.drawable.home,
            experience = arrayListOf(
                ExperienceModel(
                    isPresentWorkThere = true,
                    positionResId = R.string.senior_position,
                    companyNameResId = R.string.elsewedy_company,
                    startDateResId = R.string.senior_position_start_date,
                    responsibilitiesResId = R.array.senior_responsibilities
                ),
                ExperienceModel(
                    isPresentWorkThere = false,
                    positionResId = R.string.junior_position,
                    companyNameResId = R.string.elsewedy_company,
                    endDateResId = R.string.junior_position_end_date,
                    startDateResId = R.string.junior_position_start_date,
                    responsibilitiesResId = R.array.junior_responsibilities
                ),
                ExperienceModel(
                    isPresentWorkThere = false,
                    companyNameResId = R.string.skep_company,
                    positionResId = R.string.android_position,
                    endDateResId = R.string.android_position_end_date,
                    startDateResId = R.string.android_position_start_date,
                    responsibilitiesResId = R.array.android_responsibilities
                )
            )
        )

        val skills = SkillsSection(
            sectionNameResId = R.string.skills,
            sectionIconResId = R.drawable.home,
            skillsResId = 1 to emptyList()
        )

        val projects = ProjectsSection(
            sectionNameResId = R.string.projects,
            sectionIconResId = R.drawable.home,
            projects = emptyList()
        )

        val education = EducationSection(
            sectionNameResId = R.string.education,
            sectionIconResId = R.drawable.home,
            education = emptyList()
        )

        val certificates = CertificateSection(
            sectionNameResId = R.string.certificates,
            sectionIconResId = R.drawable.home,
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