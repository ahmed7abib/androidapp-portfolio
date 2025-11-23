package com.ahmed.a.habib.habibportfolio.domain

import com.ahmed.a.habib.habibportfolio.data.models.CvModel

interface CvDataRepo {
    fun getCvData(): CvModel
}