package com.ahmed.a.habib.habibportfolio.presentation.experience

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ahmed.a.habib.habibportfolio.R
import com.ahmed.a.habib.habibportfolio.data.models.ExperienceModel
import com.ahmed.a.habib.habibportfolio.utils.commonUI.VerticalSpace
import com.ahmed.a.habib.habibportfolio.utils.commonUI.bold
import com.ahmed.a.habib.habibportfolio.utils.commonUI.extraBold
import com.ahmed.a.habib.habibportfolio.utils.commonUI.light
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

        Text(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally),
            text = stringResource(R.string.work_experience),
            style = extraBold()
        )

        Image(
            painter = painterResource(id = R.drawable.hor_line),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(100.dp)
                .height(40.dp)
                .align(Alignment.CenterHorizontally)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(experience) { _, item -> TimelineItem(item) }
        }
    }
}

@Composable
fun TimelineItem(
    item: ExperienceModel,
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
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

            Text(
                "${stringResource(item.companyNameResId)} | ${stringResource(item.startDateResId)}",
                style = regular(fontColor = Color.Gray)
            )

            VerticalSpace(12.dp)

            val responsibilities = stringArrayResource(item.responsibilitiesResId).toList()

            responsibilities.forEach {
                Row {
                    Text("• ", style = light(fontColor = Color.Black))
                    Text(it, style = light(fontColor = Color.Black))
                }
            }
        }
    }
}
