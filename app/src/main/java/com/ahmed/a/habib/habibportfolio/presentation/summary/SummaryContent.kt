package com.ahmed.a.habib.habibportfolio.presentation.summary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed.a.habib.habibportfolio.data.models.SummaryContent
import com.ahmed.a.habib.habibportfolio.utils.commonUI.VerticalSpace
import com.ahmed.a.habib.habibportfolio.utils.commonUI.bold
import com.ahmed.a.habib.habibportfolio.utils.commonUI.regular
import com.ahmed.a.habib.habibportfolio.utils.theme.LightGray


@Composable
fun SummaryScreen(summaryContent: SummaryContent?, welcomeMessage: String) {

    if (summaryContent == null) return

    val summaryResId = summaryContent.fullSummaryResId
    val targetResId = summaryContent.targetToBoldResId

    val targetStr = stringResource(targetResId)
    val fullTextStr = stringResource(summaryResId)

    val startIndex = fullTextStr.indexOf(targetStr)
    val endIndex = startIndex + targetStr.length

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGray)
            .padding(24.dp)
    ) {

        Text(text = welcomeMessage, style = bold(fontSize = 32.sp))

        VerticalSpace(8.dp)

        Text(
            text = buildAnnotatedString {
                append(fullTextStr)
                if (startIndex >= 0) {
                    addStyle(
                        style = SpanStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline
                        ),
                        start = startIndex,
                        end = endIndex
                    )
                }
            },
            style = regular()
        )
    }
}