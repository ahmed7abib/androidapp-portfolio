package com.ahmed.a.habib.habibportfolio.data


import com.ahmed.a.habib.habibportfolio.R
import com.ahmed.a.habib.habibportfolio.data.models.CertificateModel
import com.ahmed.a.habib.habibportfolio.data.models.CvModel
import com.ahmed.a.habib.habibportfolio.data.models.EducationModel
import com.ahmed.a.habib.habibportfolio.data.models.ExperienceModel
import com.ahmed.a.habib.habibportfolio.data.models.ProjectModel
import com.ahmed.a.habib.habibportfolio.domain.CvDataRepo

class CvDataRepoImpl : CvDataRepo {

    override fun getCvData(): CvModel {

        val education = EducationModel(
            degree = R.string.degree_cs,
            facultyName = R.string.faculty_cs,
            studyDate = R.string.cs_study_date,
            universityName = R.string.university_benha
        )

        val projects = emptyList<ProjectModel>()
        val experience = emptyList<ExperienceModel>()
        val skills = "" to emptyList<String>()
        val certificates = emptyList<CertificateModel>()

        return CvModel(
            title = R.string.title,
            cvLink = R.string.cv_link,
            summary = R.string.summary,
            fullName = R.string.full_name,
            skills = skills,
            projects = projects,
            education = education,
            experience = experience,
            certificates = certificates
        )
    }
}