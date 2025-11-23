package com.ahmed.a.habib.habibportfolio.presentation.main


import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ahmed.a.habib.habibportfolio.R
import com.ahmed.a.habib.habibportfolio.presentation.CvDataViewModel
import com.ahmed.a.habib.habibportfolio.presentation.home.HomeContent
import com.ahmed.a.habib.habibportfolio.presentation.side_menu.SideMenu
import com.ahmed.a.habib.habibportfolio.utils.openLink
import com.ahmed.a.habib.habibportfolio.utils.showToast


@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: CvDataViewModel = hiltViewModel(),
) {

    val context = LocalContext.current
    val isMenuOpen = remember { mutableStateOf(false) }
    val transition = updateTransition(targetState = isMenuOpen.value)

    val scale by transition.animateFloat { if (it) 0.85f else 1f }
    val radius by transition.animateDp { if (it) 25.dp else 0.dp }
    val offsetX by transition.animateDp { if (it) 250.dp else 0.dp }

    Box(modifier = Modifier.fillMaxSize()) {

        SideMenu(
            offsetX = offsetX.value,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .statusBarsPadding()
        )

        Box(
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    translationX = offsetX.toPx()
                    shadowElevation = if (isMenuOpen.value) 16f else 0f
                    shape = RoundedCornerShape(radius)
                    clip = true
                }
                .fillMaxSize()
                .background(Color.Black)
        ) {

            Image(
                contentDescription = null,
                modifier = Modifier.align(Alignment.BottomStart),
                painter = painterResource(R.drawable.ahmed_bg),
            )

            HomeContent(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .systemBarsPadding(),
                isMenuOpen = isMenuOpen.value,
                onMenuClick = { isMenuOpen.value = it },
                isDownloadCvBtnClicked = {
                    val link = viewModel.getCvLink()
                    if (link == null) {
                        context.showToast(context.getString(R.string.invalid_link))
                    } else {
                        context.openLink(context.getString(link))
                    }
                },
                isExploreMoreBtnClicked = { isMenuOpen.value = true }
            )
        }
    }
}