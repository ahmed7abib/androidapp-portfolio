package com.ahmed.a.habib.habibportfolio.presentation.home

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed.a.habib.habibportfolio.R
import com.ahmed.a.habib.habibportfolio.data.models.PersonalInfoModel
import com.ahmed.a.habib.habibportfolio.utils.commonUI.VerticalSpace
import com.ahmed.a.habib.habibportfolio.utils.commonUI.extraBold
import com.ahmed.a.habib.habibportfolio.utils.commonUI.medium
import com.ahmed.a.habib.habibportfolio.utils.openLink
import com.ahmed.a.habib.habibportfolio.utils.showToast
import com.ahmed.a.habib.habibportfolio.utils.theme.DarkBlue


@Composable
fun DrawHomeContent(
    personalInfo: PersonalInfoModel?,
    isExploreMoreBtnClicked: () -> Unit,
) {

    val context = LocalContext.current

    HomeContent(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 32.dp),
        personalInfo = personalInfo,
        isDownloadCvBtnClicked = {
            val link = personalInfo?.cvLink
            if (link == null) {
                context.showToast(context.getString(R.string.invalid_link))
            } else {
                context.openLink(context.getString(link))
            }
        },
        isExploreMoreBtnClicked = { isExploreMoreBtnClicked() }
    )
}

@Composable
private fun HomeContent(
    modifier: Modifier = Modifier,
    personalInfo: PersonalInfoModel?,
    isDownloadCvBtnClicked: () -> Unit,
    isExploreMoreBtnClicked: () -> Unit,
) {

    val context = LocalContext.current

    Column(modifier = modifier.padding(top = 60.dp)) {

        Text(
            text = context.getWelcomeMsg(personalInfo?.fullName),
            style = extraBold(fontSize = 32.sp, fontColor = Color.White)
        )

        VerticalSpace(8.dp)

        Text(
            style = medium(fontColor = Color.White),
            text = context.getTitle(personalInfo?.title)
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

private fun Context.getWelcomeMsg(str: Int?): String {
    if (str == null) return getString(R.string.hello_dear)
    return "${getString(R.string.hello_i_m)}\n${getString(str)}"
}

private fun Context.getTitle(str: Int?): String {
    if (str == null) return ""
    return getString(str)
}
