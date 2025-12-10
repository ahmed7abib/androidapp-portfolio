package com.ahmed.a.habib.habibportfolio.presentation.home

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed.a.habib.habibportfolio.R
import com.ahmed.a.habib.habibportfolio.data.models.PersonalInfoModel
import com.ahmed.a.habib.habibportfolio.utils.commonUI.VerticalSpace
import com.ahmed.a.habib.habibportfolio.utils.commonUI.extraBold
import com.ahmed.a.habib.habibportfolio.utils.commonUI.medium
import com.ahmed.a.habib.habibportfolio.utils.openWebPage
import com.ahmed.a.habib.habibportfolio.utils.showToast
import com.ahmed.a.habib.habibportfolio.utils.theme.DarkBlue


@Composable
fun HomeScreen(
    personalInfo: PersonalInfoModel?,
    openSideMenu: () -> Unit,
) {

    val context = LocalContext.current

    HomeContent(
        personalInfo = personalInfo,
        isDownloadCvBtnClicked = {
            val url = personalInfo?.cvLinkResId
            if (url == null) {
                val errorMessage = context.getString(R.string.invalid_link)
                context.showToast(errorMessage)
            } else {
                context.openWebPage(context.getString(url))
            }
        },
        isExploreMoreBtnClicked = { openSideMenu() }
    )
}

@Composable
private fun HomeContent(
    personalInfo: PersonalInfoModel?,
    isDownloadCvBtnClicked: () -> Unit,
    isExploreMoreBtnClicked: () -> Unit,
) {

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Image(
            contentDescription = null,
            modifier = Modifier.align(Alignment.BottomStart),
            painter = painterResource(R.drawable.ahmed_bg),
        )

        Column(modifier = Modifier.padding(24.dp)) {

            Text(
                text = context.getWelcomeMsg(personalInfo?.fullNameResId),
                style = extraBold(fontSize = 32.sp, fontColor = Color.White)
            )

            VerticalSpace(8.dp)

            Text(
                style = medium(fontColor = Color.White),
                text = context.getTitle(personalInfo?.titleResId)
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
}

fun Context.getWelcomeMsg(str: Int?): String {
    if (str == null) return getString(R.string.hello_dear)
    return "${getString(R.string.hello_i_m)}\n${getString(str)}"
}

private fun Context.getTitle(str: Int?): String {
    if (str == null) return ""
    return getString(str)
}
