package com.ahmed.a.habib.habibportfolio.presentation.shared

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ahmed.a.habib.habibportfolio.R
import com.ahmed.a.habib.habibportfolio.utils.commonUI.extraBold


@Composable
fun SectionHeader(title: String, modifier: Modifier, lineWidth: Int = 100) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = extraBold(),
            modifier = Modifier.wrapContentSize(),
        )

        Image(
            modifier = Modifier
                .height(40.dp)
                .width(lineWidth.dp),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.hor_line)
        )
    }
}
