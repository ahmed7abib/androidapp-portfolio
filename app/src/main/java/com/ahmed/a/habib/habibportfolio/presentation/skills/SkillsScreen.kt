package com.ahmed.a.habib.habibportfolio.presentation.skills

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
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
import com.ahmed.a.habib.habibportfolio.presentation.shared.RoundedTextBox
import com.ahmed.a.habib.habibportfolio.presentation.shared.SectionHeader
import com.ahmed.a.habib.habibportfolio.utils.commonUI.VerticalSpace
import com.ahmed.a.habib.habibportfolio.utils.commonUI.bold
import com.ahmed.a.habib.habibportfolio.utils.theme.DarkBlue
import com.ahmed.a.habib.habibportfolio.utils.theme.LightGray
import com.ahmed.a.habib.habibportfolio.utils.theme.LightGray2


@Composable
fun SkillsScreen(skills: List<Pair<Int, List<Int>>>) {

    if (skills.isEmpty()) return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGray)
            .padding(24.dp)
    ) {
        SectionHeader(
            title = stringResource(R.string.tech_skills),
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(skills) { _, item -> SkillCategory(item) }
        }
    }
}

@Composable
private fun SkillCategory(item: Pair<Int, List<Int>>) {

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
                style = bold(fontColor = Color.Black, fontSize = 20.sp),
                text = stringResource(item.first)
            )

            VerticalSpace(12.dp)

            FlowRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                item.second.forEach {
                    RoundedTextBox(
                        modifier = Modifier
                            .padding(4.dp)
                            .wrapContentSize()
                            .clip(RoundedCornerShape(12.dp))
                            .background(DarkBlue)
                            .padding(4.dp),
                        text = stringResource(it)
                    )
                }
            }
        }
    }
}