package com.ahmed.a.habib.habibportfolio.presentation

import androidx.lifecycle.ViewModel
import com.ahmed.a.habib.habibportfolio.domain.use_cases.GetMenuItems
import com.ahmed.a.habib.habibportfolio.domain.use_cases.GetPersonalInfo
import com.ahmed.a.habib.habibportfolio.domain.use_cases.GetSummaryInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class CvDataViewModel @Inject constructor(
    private val getMenuItems: GetMenuItems,
    private val getSummaryInfo: GetSummaryInfo,
    private val getPersonalInfo: GetPersonalInfo,
) : ViewModel() {

    val state = MutableStateFlow(UIStates())

    init {
        onEvent(event = UserEvents.GetAllData)
    }

    fun onEvent(event: UserEvents) {
        when (event) {
            UserEvents.GetAllData -> getAllData()
            UserEvents.GetSummaryContent -> getSummary()
            UserEvents.GetMenuItems -> getMenuItemsList()
            UserEvents.GetPersonalInfo -> getPersonalData()
        }
    }

    private fun getAllData() {
        getSummary()
        getPersonalData()
        getMenuItemsList()
    }

    private fun getMenuItemsList() {
        reduce {
            copy(menuItems = getMenuItems())
        }
    }

    private fun getSummary() {
        reduce {
            copy(summaryContent = getSummaryInfo())
        }
    }

    private fun getPersonalData() {
        reduce {
            copy(personalInfo = getPersonalInfo())
        }
    }

    private fun reduce(updateState: UIStates.() -> UIStates) {
        state.value = updateState(state.value)
    }
}