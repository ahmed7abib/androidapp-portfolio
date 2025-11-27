package com.ahmed.a.habib.habibportfolio.presentation.summary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.ahmed.a.habib.habibportfolio.utils.commonUI.medium


@Composable
fun SummaryScreen(summaryContent: Int?) {
    if (summaryContent == null) return

    Text(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        style = medium(fontColor = Color.White),
        text = stringResource(summaryContent)
    )
}