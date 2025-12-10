package com.ahmed.a.habib.habibportfolio.presentation

import androidx.lifecycle.ViewModel
import com.ahmed.a.habib.habibportfolio.domain.use_cases.GetMenuItems
import com.ahmed.a.habib.habibportfolio.domain.use_cases.GetPersonalInfo
import com.ahmed.a.habib.habibportfolio.domain.use_cases.GetProjects
import com.ahmed.a.habib.habibportfolio.domain.use_cases.GetSummaryInfo
import com.ahmed.a.habib.habibportfolio.domain.use_cases.GetWorkExperience
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


@HiltViewModel
class CvDataViewModel @Inject constructor(
    private val getProjects: GetProjects,
    private val getMenuItems: GetMenuItems,
    private val getSummaryInfo: GetSummaryInfo,
    private val getPersonalInfo: GetPersonalInfo,
    private val getWorkExperience: GetWorkExperience,
) : ViewModel() {

    val state = MutableStateFlow(UIStates())

    init {
        onEvent(event = UserEvents.GetAllData)
    }

    fun onEvent(event: UserEvents) {
        when (event) {
            UserEvents.GetAllData -> getAllData()
            UserEvents.GetProjects -> getProjectsData()
            UserEvents.GetSummaryContent -> getSummary()
            UserEvents.GetMenuItems -> getMenuItemsList()
            UserEvents.GetPersonalInfo -> getPersonalData()
            UserEvents.GetWorkExperience -> getWorkExperienceData()
        }
    }

    private fun getAllData() {
        getSummary()
        getPersonalData()
        getProjectsData()
        getMenuItemsList()
        getWorkExperienceData()
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

    private fun reduce(updateState: UIStates.() -> UIStates) {
        state.value = updateState(state.value)
    }
}