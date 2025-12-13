package com.ahmed.a.habib.habibportfolio.data.models


data class CvModel(
    val home: HomeSection,
    val skills: SkillsSection,
    val summary: SummarySection,
    val projects: ProjectsSection,
    val education: EducationSection,
    val experience: ExperienceSection,
    val socialMedia: SocialMediaModel,
    val certificates: CertificateSection,
)