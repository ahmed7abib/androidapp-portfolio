package com.ahmed.a.habib.habibportfolio.presentation.experience

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ahmed.a.habib.habibportfolio.R
import com.ahmed.a.habib.habibportfolio.data.models.ExperienceModel
import com.ahmed.a.habib.habibportfolio.presentation.shared.SectionHeader
import com.ahmed.a.habib.habibportfolio.utils.commonUI.VerticalSpace
import com.ahmed.a.habib.habibportfolio.utils.commonUI.bold
import com.ahmed.a.habib.habibportfolio.utils.commonUI.regular
import com.ahmed.a.habib.habibportfolio.utils.theme.LightGray


@Composable
fun ExperienceScreen(experience: List<ExperienceModel>) {

    if (experience.isEmpty()) return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGray)
            .padding(24.dp)
    ) {

        SectionHeader(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(R.string.work_experience),
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(experience) { _, item -> ExperienceItem(item) }
        }
    }
}

@Composable
fun ExperienceItem(item: ExperienceModel) {

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(
                stringResource(item.positionResId),
                style = bold(fontColor = Color.Black)
            )

            val endDate = if (item.isPresentWorkThere) {
                stringResource(R.string.present)
            } else {
                item.endDateResId?.let { stringResource(it) }
            }

            Text(
                stringResource(item.companyNameResId),
                style = regular(fontColor = Color.Gray)
            )

            VerticalSpace(4.dp)

            Text(
                "${stringResource(item.startDateResId)} - $endDate",
                style = regular(fontColor = Color.Gray)
            )

            VerticalSpace(12.dp)

            val responsibilities = stringArrayResource(item.responsibilitiesResId).toList()

            responsibilities.forEach {
                Row {
                    Text("• ", style = regular(fontColor = Color.Black))
                    Text(it, style = regular(fontColor = Color.Black))
                }
            }
        }
    }
}
