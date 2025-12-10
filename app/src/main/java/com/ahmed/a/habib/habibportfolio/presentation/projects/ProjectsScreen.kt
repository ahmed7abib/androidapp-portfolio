package com.ahmed.a.habib.habibportfolio.presentation.projects

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ahmed.a.habib.habibportfolio.R
import com.ahmed.a.habib.habibportfolio.data.models.ProjectModel
import com.ahmed.a.habib.habibportfolio.presentation.shared.SectionHeader
import com.ahmed.a.habib.habibportfolio.utils.commonUI.VerticalSpace
import com.ahmed.a.habib.habibportfolio.utils.commonUI.bold
import com.ahmed.a.habib.habibportfolio.utils.commonUI.regular
import com.ahmed.a.habib.habibportfolio.utils.theme.DarkBlue
import com.ahmed.a.habib.habibportfolio.utils.theme.LightGray

@Composable
fun ProjectsScreen(proModels: List<ProjectModel>) {

    if (proModels.isEmpty()) return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGray)
            .padding(24.dp)
    ) {
        SectionHeader(
            title = stringResource(R.string.projects),
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(proModels) { _, item -> ProjectItem(item) }
        }
    }
}

@Composable
fun ProjectItem(item: ProjectModel) {

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
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillBounds,
                painter = painterResource(id = item.imageResId)
            )

            VerticalSpace(8.dp)

            Text(
                style = bold(),
                text = stringResource(item.projectNameResId)
            )

            VerticalSpace(8.dp)

            Box(
                modifier = Modifier
                    .wrapContentSize()
                    .clip(RoundedCornerShape(12.dp))
                    .background(DarkBlue)
            ) {
                Text(
                    style = regular(fontColor = Color.White),
                    text = stringResource(item.programingLangResId),
                    modifier = Modifier.padding(vertical = 4.dp, horizontal = 12.dp)
                )
            }

            VerticalSpace(8.dp)

            Text(
                style = regular(fontColor = Color.Gray),
                text = stringResource(item.descriptionResId)
            )
        }
    }
}