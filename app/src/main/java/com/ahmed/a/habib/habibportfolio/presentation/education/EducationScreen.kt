package com.ahmed.a.habib.habibportfolio.presentation.education

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed.a.habib.habibportfolio.R
import com.ahmed.a.habib.habibportfolio.data.models.EducationModel
import com.ahmed.a.habib.habibportfolio.presentation.shared.RoundedTextBox
import com.ahmed.a.habib.habibportfolio.presentation.shared.SectionHeader
import com.ahmed.a.habib.habibportfolio.utils.commonUI.HorizontalSpace
import com.ahmed.a.habib.habibportfolio.utils.commonUI.VerticalSpace
import com.ahmed.a.habib.habibportfolio.utils.commonUI.bold
import com.ahmed.a.habib.habibportfolio.utils.commonUI.medium
import com.ahmed.a.habib.habibportfolio.utils.theme.DarkBlue
import com.ahmed.a.habib.habibportfolio.utils.theme.LightGray
import com.ahmed.a.habib.habibportfolio.utils.theme.LightGray2

@Composable
fun EducationScreen(educations: List<EducationModel>) {

    if (educations.isEmpty()) return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGray)
            .padding(24.dp)
    ) {
        SectionHeader(
            title = stringResource(R.string.education),
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(educations) { _, item -> EducationItem(item) }
        }
    }
}

@Composable
private fun EducationItem(item: EducationModel) {

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardColors(
            contentColor = LightGray2,
            containerColor = LightGray2,
            disabledContainerColor = LightGray2,
            disabledContentColor = LightGray2
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                stringResource(item.educationDegreeResId),
                style = bold(fontColor = Color.Black, fontSize = 18.sp)
            )

            VerticalSpace(8.dp)

            Text(
                stringResource(item.educationFieldResId),
                style = medium(fontColor = Color.Gray, fontSize = 16.sp)
            )

            VerticalSpace(8.dp)

            RoundedTextBox(
                modifier = Modifier
                    .wrapContentSize()
                    .clip(RoundedCornerShape(12.dp))
                    .background(DarkBlue)
                    .padding(4.dp),
                text = stringResource(item.studyDateResId)
            )

            VerticalSpace(8.dp)

            Row {
                RoundedTextBox(
                    modifier = Modifier
                        .wrapContentSize()
                        .clip(RoundedCornerShape(12.dp))
                        .background(DarkBlue)
                        .padding(4.dp),
                    text = stringResource(item.universityResId)
                )

                HorizontalSpace(4.dp)

                RoundedTextBox(
                    modifier = Modifier
                        .wrapContentSize()
                        .clip(RoundedCornerShape(12.dp))
                        .background(DarkBlue)
                        .padding(4.dp),
                    text = stringResource(item.countryResId)
                )
            }
        }
    }
}