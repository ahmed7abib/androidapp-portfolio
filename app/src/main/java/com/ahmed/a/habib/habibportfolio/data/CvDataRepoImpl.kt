package com.ahmed.a.habib.habibportfolio.data

import com.ahmed.a.habib.habibportfolio.R
import com.ahmed.a.habib.habibportfolio.data.models.CertificateModel
import com.ahmed.a.habib.habibportfolio.data.models.CertificateSection
import com.ahmed.a.habib.habibportfolio.data.models.CvModel
import com.ahmed.a.habib.habibportfolio.data.models.EducationModel
import com.ahmed.a.habib.habibportfolio.data.models.EducationSection
import com.ahmed.a.habib.habibportfolio.data.models.ExperienceModel
import com.ahmed.a.habib.habibportfolio.data.models.ExperienceSection
import com.ahmed.a.habib.habibportfolio.data.models.HomeSection
import com.ahmed.a.habib.habibportfolio.data.models.PersonalInfoModel
import com.ahmed.a.habib.habibportfolio.data.models.ProjectModel
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

        val projects = ProjectsSection(
            sectionNameResId = R.string.projects,
            sectionIconResId = R.drawable.home,
            projects = listOf(
                ProjectModel(
                    imageResId = R.drawable.meterops,
                    projectNameResId = R.string.meter_ops,
                    programingLangResId = R.string.kotlin,
                    descriptionResId = R.string.meterops_description,
                ),
                ProjectModel(
                    imageResId = R.drawable.azka,
                    projectNameResId = R.string.azka_pay,
                    programingLangResId = R.string.kotlin,
                    descriptionResId = R.string.azka_pay_description,
                ),
                ProjectModel(
                    projectNameResId = R.string.scu,
                    imageResId = R.drawable.default_proj,
                    programingLangResId = R.string.java,
                    descriptionResId = R.string.scu_description,
                ),
                ProjectModel(
                    imageResId = R.drawable.nano_jobs,
                    projectNameResId = R.string.nano_jobs,
                    programingLangResId = R.string.flutter,
                    descriptionResId = R.string.nano_jobs_description,
                ),
                ProjectModel(
                    projectNameResId = R.string.ecash,
                    imageResId = R.drawable.default_proj,
                    programingLangResId = R.string.kotlin,
                    descriptionResId = R.string.ecash_description,
                ),
                ProjectModel(
                    imageResId = R.drawable.skep,
                    projectNameResId = R.string.skep_home,
                    programingLangResId = R.string.kotlin,
                    descriptionResId = R.string.skep_description,
                ),
                ProjectModel(
                    imageResId = R.drawable.default_proj,
                    projectNameResId = R.string.ethiopia,
                    programingLangResId = R.string.java,
                    descriptionResId = R.string.ethiopia_description,
                ),
                ProjectModel(
                    imageResId = R.drawable.teamknot,
                    projectNameResId = R.string.teamknot,
                    programingLangResId = R.string.kotlin,
                    descriptionResId = R.string.teamknot_description,
                ),
                ProjectModel(
                    imageResId = R.drawable.default_proj,
                    projectNameResId = R.string.biut,
                    programingLangResId = R.string.kotlin,
                    descriptionResId = R.string.biut_description,
                )
            )
        )

        val skills = SkillsSection(
            sectionNameResId = R.string.skills,
            sectionIconResId = R.drawable.home,
            skillsResId = listOf(
                R.string.programming_language to listOf(
                    R.string.kotlin,
                    R.string.java,
                    R.string.flutter
                ),
                R.string.core_android to listOf(
                    R.string.mxl,
                    R.string.android_sdk,
                    R.string.jetpack_compose,
                ),
                R.string.arc_and_design to listOf(
                    R.string.mvvm,
                    R.string.mvi,
                    R.string.mvp,
                    R.string.clean_arc,
                    R.string.app_modularization
                ), R.string.jetpack_libs to listOf(
                    R.string.view_model,
                    R.string.data_binding,
                    R.string.lifecycle,
                    R.string.navigation,
                    R.string.room
                ), R.string.networking to listOf(
                    R.string.retrofit,
                    R.string.ktor,
                    R.string.rest_api,
                    R.string.graphql
                ), R.string.dependency_injection to listOf(
                    R.string.hilt,
                    R.string.koin,
                ), R.string.reactive_programming to listOf(
                    R.string.coroutines,
                    R.string.flow,
                    R.string.rx_java,
                    R.string.live_data,
                ), R.string.other_tchnologies to listOf(
                    R.string.firebase,
                    R.string.google_maps,
                    R.string.nfc,
                    R.string.git,
                    R.string.unit_test,
                    R.string.rsa_aes
                )
            )
        )

        val certificates = CertificateSection(
            sectionNameResId = R.string.certificates,
            sectionIconResId = R.drawable.home,
            certificates = listOf(
                CertificateModel(
                    dateResId = R.string.spring_certificate_date,
                    imageResId = R.drawable.cer_spring,
                    industryResId = R.string.udemy,
                    certificateNameResId = R.string.spring_certificate_name
                ),
                CertificateModel(
                    dateResId = R.string.nano_degree_certificate_date,
                    imageResId = R.drawable.cer_nanodegree,
                    industryResId = R.string.udacity,
                    certificateNameResId = R.string.nano_degree_certificate_name
                ),
                CertificateModel(
                    dateResId = R.string.design_patterns_certificate_date,
                    imageResId = R.drawable.cer_design_patterns,
                    industryResId = R.string.udemy,
                    certificateNameResId = R.string.design_patterns_certificate_name
                ),
                CertificateModel(
                    dateResId = R.string.testing_certificate_date,
                    imageResId = R.drawable.cer_spring,
                    industryResId = R.string.udemy,
                    certificateNameResId = R.string.testing_certificate_name
                )
            )
        )

        val education = EducationSection(
            sectionNameResId = R.string.education,
            sectionIconResId = R.drawable.home,
            education = listOf(
                EducationModel(
                    countryResId = R.string.egypt,
                    educationFieldResId = R.string.cs_field,
                    educationDegreeResId = R.string.cs_degree,
                    universityResId = R.string.university_benha,
                    studyDateResId = R.string.study_date
                )
            )
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