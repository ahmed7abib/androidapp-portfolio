package com.ahmed.a.habib.habibportfolio.presentation.utils.mvi

sealed class UserEvents {
    object GetAllData : UserEvents()
    object GetMenuItems : UserEvents()
    object GetPersonalInfo : UserEvents()
    object GetSummaryContent : UserEvents()
}