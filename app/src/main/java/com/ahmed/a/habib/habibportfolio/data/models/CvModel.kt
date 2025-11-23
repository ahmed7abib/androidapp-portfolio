package com.ahmed.a.habib.habibportfolio.data.models

data class CvModel(
    val fullName: Int,
    val title: Int,
    val cvLink: Int,
    val summary: Int,
    val education: EducationModel,
    val projects: List<ProjectModel>,
    val experience: List<ExperienceModel>,
    val skills: Pair<String, List<String>>,
    val certificates: List<CertificateModel>,
)

data class EducationModel(
    val degree: Int,
    val studyDate: Int,
    val facultyName: Int,
    val universityName: Int,
)

data class ExperienceModel(
    val position: Int,
    val endDate: Int,
    val startDate: Int,
    val companyName: Int,
    val isPresentWorkThere: Boolean,
)

data class ProjectModel(
    val image: Int,
    val projectName: Int,
    val description: Int,
)

data class CertificateModel(
    val image: Int,
    val certificateName: Int,
)