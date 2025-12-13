package com.ahmed.a.habib.habibportfolio.presentation

sealed class UserEvents {
    object GetSkills : UserEvents()
    object GetAllData : UserEvents()
    object GetProjects : UserEvents()
    object GetMenuItems : UserEvents()
    object GetEducations : UserEvents()
    object GetSocialMedia : UserEvents()
    object GetCertificates : UserEvents()
    object GetPersonalInfo : UserEvents()
    object GetSummaryContent : UserEvents()
    object GetWorkExperience : UserEvents()
}