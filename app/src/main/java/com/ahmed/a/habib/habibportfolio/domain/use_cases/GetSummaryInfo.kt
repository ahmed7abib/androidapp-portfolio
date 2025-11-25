package com.ahmed.a.habib.habibportfolio.domain.use_cases

import com.ahmed.a.habib.habibportfolio.domain.CvDataRepo
import javax.inject.Inject

class GetSummaryInfo @Inject constructor(private val repo: CvDataRepo) {

    operator fun invoke() = repo.getCvData().summary.summaryContent
}