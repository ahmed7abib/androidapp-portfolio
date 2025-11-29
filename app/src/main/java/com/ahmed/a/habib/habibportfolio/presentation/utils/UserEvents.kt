package com.ahmed.a.habib.habibportfolio.presentation.utils

sealed class UserEvents {
    object GetAllData : UserEvents()
    object GetMenuItems : UserEvents()
    object GetPersonalInfo : UserEvents()
    object GetSummaryContent : UserEvents()
}