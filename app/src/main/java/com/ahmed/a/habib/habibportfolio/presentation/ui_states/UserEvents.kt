package com.ahmed.a.habib.habibportfolio.presentation.ui_states

sealed class UserEvents {
    object GetAllData : UserEvents()
    object GetMenuItems : UserEvents()
    object GetPersonalInfo : UserEvents()
    object GetSummaryContent : UserEvents()
}