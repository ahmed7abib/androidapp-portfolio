package com.ahmed.a.habib.habibportfolio.features.home


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ahmed.a.habib.habibportfolio.R
import com.ahmed.a.habib.habibportfolio.features.side_menu.SideMenu
import com.ahmed.a.habib.habibportfolio.utils.commonUI.VerticalSpace
import com.ahmed.a.habib.habibportfolio.utils.commonUI.extraBold
import com.ahmed.a.habib.habibportfolio.utils.commonUI.medium
import com.ahmed.a.habib.habibportfolio.utils.theme.DarkBlue
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(navController: NavHostController) {

    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            painter = painterResource(R.drawable.home_bg),
        )

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = { SideMenu() }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .systemBarsPadding()
            ) {
                Image(
                    contentDescription = null,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(16.dp)
                        .align(Alignment.TopStart)
                        .clickable { scope.launch { drawerState.open() } },
                    colorFilter = ColorFilter.tint(Color.White),
                    painter = painterResource(R.drawable.side_medu)
                )

                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterStart)
                ) {
                    Text(
                        text = stringResource(R.string.hello_i_m_ahmed_adel_habib),
                        style = extraBold(fontSize = 32.sp, fontColor = Color.White)
                    )

                    VerticalSpace(8.dp)

                    Text(
                        text = stringResource(R.string.senior_android_developer),
                        style = medium(fontColor = Color.White)
                    )

                    VerticalSpace(32.dp)

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = {},
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
                            onClick = {},
                            shape = RoundedCornerShape(12.dp),
                            border = BorderStroke(1.dp, DarkBlue)
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
    }
}