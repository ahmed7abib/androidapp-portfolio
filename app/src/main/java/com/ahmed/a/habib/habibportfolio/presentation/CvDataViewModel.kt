package com.ahmed.a.habib.habibportfolio.presentation

import androidx.lifecycle.ViewModel
import com.ahmed.a.habib.habibportfolio.domain.use_cases.GetCertificates
import com.ahmed.a.habib.habibportfolio.domain.use_cases.GetEducations
import com.ahmed.a.habib.habibportfolio.domain.use_cases.GetMenuItems
import com.ahmed.a.habib.habibportfolio.domain.use_cases.GetPersonalInfo
import com.ahmed.a.habib.habibportfolio.domain.use_cases.GetProjects
import com.ahmed.a.habib.habibportfolio.domain.use_cases.GetSkills
import com.ahmed.a.habib.habibportfolio.domain.use_cases.GetSocialMedia
import com.ahmed.a.habib.habibportfolio.domain.use_cases.GetSummaryInfo
import com.ahmed.a.habib.habibportfolio.domain.use_cases.GetWorkExperience
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


@HiltViewModel
class CvDataViewModel @Inject constructor(
    private val getSkills: GetSkills,
    private val getProjects: GetProjects,
    private val getMenuItems: GetMenuItems,
    private val getEducation: GetEducations,
    private val getSummaryInfo: GetSummaryInfo,
    private val getSocialMedia: GetSocialMedia,
    private val getPersonalInfo: GetPersonalInfo,
    private val getCertificates: GetCertificates,
    private val getWorkExperience: GetWorkExperience,
) : ViewModel() {

    val state = MutableStateFlow(UIStates())

    init {
        onEvent(event = UserEvents.GetAllData)
    }

    fun onEvent(event: UserEvents) {
        when (event) {
            UserEvents.GetAllData -> getAllData()
            UserEvents.GetSkills -> getSkillsData()
            UserEvents.GetProjects -> getProjectsData()
            UserEvents.GetSummaryContent -> getSummary()
            UserEvents.GetMenuItems -> getMenuItemsList()
            UserEvents.GetEducations -> getEducationData()
            UserEvents.GetPersonalInfo -> getPersonalData()
            UserEvents.GetSocialMedia -> getSocialMediaData()
            UserEvents.GetCertificates -> getCertificatesData()
            UserEvents.GetWorkExperience -> getWorkExperienceData()
        }
    }

    private fun getAllData() {
        getSummary()
        getSkillsData()
        getPersonalData()
        getProjectsData()
        getEducationData()
        getMenuItemsList()
        getSocialMediaData()
        getCertificatesData()
        getWorkExperienceData()
    }

    private fun getSocialMediaData() {
        reduce { copy(socialMedia = getSocialMedia()) }
    }

    private fun getEducationData() {
        reduce { copy(educations = getEducation()) }
    }

    private fun getSkillsData() {
        reduce { copy(skills = getSkills()) }
    }

    private fun getMenuItemsList() {
        reduce { copy(menuItems = getMenuItems()) }
    }

    private fun getSummary() {
        reduce { copy(summaryContent = getSummaryInfo()) }
    }

    private fun getPersonalData() {
        reduce { copy(personalInfo = getPersonalInfo()) }
    }

    private fun getProjectsData() {
        reduce { copy(projects = getProjects()) }
    }

    private fun getWorkExperienceData() {
        reduce { copy(workExperience = getWorkExperience()) }
    }

    private fun getCertificatesData() {
        reduce { copy(certificates = getCertificates()) }
    }

    private fun reduce(updateState: UIStates.() -> UIStates) {
        state.value = updateState(state.value)
    }
}