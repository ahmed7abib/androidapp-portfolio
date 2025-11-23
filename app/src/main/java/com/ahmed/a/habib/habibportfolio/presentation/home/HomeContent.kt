package com.ahmed.a.habib.habibportfolio.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed.a.habib.habibportfolio.R
import com.ahmed.a.habib.habibportfolio.utils.commonUI.VerticalSpace
import com.ahmed.a.habib.habibportfolio.utils.commonUI.extraBold
import com.ahmed.a.habib.habibportfolio.utils.commonUI.medium
import com.ahmed.a.habib.habibportfolio.utils.theme.DarkBlue


@Composable
fun HomeContent(
    isMenuOpen: Boolean,
    modifier: Modifier = Modifier,
    onMenuClick: (Boolean) -> Unit,
    isDownloadCvBtnClicked: () -> Unit,
    isExploreMoreBtnClicked: () -> Unit,
) {

    val menuIcon = if (isMenuOpen) R.drawable.close_icon else R.drawable.side_medu

    Column(modifier = modifier) {
        Image(
            contentDescription = null,
            modifier = Modifier
                .wrapContentSize()
                .clickable { onMenuClick(!isMenuOpen) },
            colorFilter = ColorFilter.tint(Color.White),
            painter = painterResource(menuIcon)
        )

        VerticalSpace(62.dp)

        Text(
            text = stringResource(R.string.hello_i_m_ahmed_adel_habib),
            style = extraBold(fontSize = 32.sp, fontColor = Color.White)
        )

        VerticalSpace(8.dp)

        Text(
            text = stringResource(R.string.title),
            style = medium(fontColor = Color.White)
        )

        VerticalSpace(32.dp)

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { isDownloadCvBtnClicked() },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = DarkBlue)
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = stringResource(R.string.download_cv),
                    style = medium(fontColor = Color.White, fontSize = 16.sp)
                )
            }

            OutlinedButton(
                onClick = { isExploreMoreBtnClicked() },
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, Color.White)
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = stringResource(R.string.explore_more),
                    style = medium(fontColor = Color.White, fontSize = 16.sp)
                )
            }
        }
    }
}