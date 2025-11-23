package com.ahmed.a.habib.habibportfolio.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmed.a.habib.habibportfolio.data.models.CvModel
import com.ahmed.a.habib.habibportfolio.domain.CvDataRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CvDataViewModel @Inject constructor(
    private val cvDataRepo: CvDataRepo,
) : ViewModel() {

    private var _cvData = MutableStateFlow<CvModel?>(null)
    val cvData: StateFlow<CvModel?> get() = _cvData

    init {
        getCvModelData()
    }

    fun getCvModelData() = viewModelScope.launch {
        _cvData.value = cvDataRepo.getCvData()
    }

    fun getCvLink() = cvData.value?.cvLink
}