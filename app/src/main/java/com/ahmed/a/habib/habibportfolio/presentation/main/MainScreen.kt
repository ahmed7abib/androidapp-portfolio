package com.ahmed.a.habib.habibportfolio.presentation.main


import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ahmed.a.habib.habibportfolio.R
import com.ahmed.a.habib.habibportfolio.domain.models.CvSection
import com.ahmed.a.habib.habibportfolio.presentation.CvDataViewModel
import com.ahmed.a.habib.habibportfolio.presentation.home.DrawHomeContent
import com.ahmed.a.habib.habibportfolio.presentation.side_menu.SideMenu
import com.ahmed.a.habib.habibportfolio.presentation.summary.DrawSummaryContent


@Composable
fun HomeScreen(
    viewModel: CvDataViewModel = hiltViewModel(),
) {

    val state by viewModel.state.collectAsState()
    val menuItems = state.menuItems
    val personalInfo = state.personalInfo
    val summaryContent = state.summaryContent

    var isMenuOpen by remember { mutableStateOf(false) }
    val transition = updateTransition(targetState = isMenuOpen)

    val scale by transition.animateFloat { if (it) 0.85f else 1f }
    val radius by transition.animateDp { if (it) 25.dp else 0.dp }
    val offsetX by transition.animateDp { if (it) 250.dp else 0.dp }

    var selectedSection by remember { mutableStateOf(CvSection.HOME) }

    val menuIcon = if (isMenuOpen) R.drawable.close_icon else R.drawable.side_medu

    Box(modifier = Modifier.fillMaxSize()) {

        SideMenu(
            offsetX = offsetX.value,
            menuItems = menuItems,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .systemBarsPadding()
        ) {
            isMenuOpen = false
            selectedSection = it
        }

        Box(
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    translationX = offsetX.toPx()
                    shadowElevation = if (isMenuOpen) 16f else 0f
                    shape = RoundedCornerShape(radius)
                    clip = true
                }
                .fillMaxSize()
                .background(Color.Black)
                .systemBarsPadding()
                .padding(top = 16.dp, start = 16.dp)
        ) {

            Image(
                contentDescription = null,
                modifier = Modifier.align(Alignment.BottomStart),
                painter = painterResource(R.drawable.ahmed_bg),
            )

            Image(
                contentDescription = null,
                painter = painterResource(menuIcon),
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.TopStart)
                    .clickable { isMenuOpen = !isMenuOpen }
            )

            when (selectedSection) {
                CvSection.HOME -> DrawHomeContent(personalInfo) { isMenuOpen = true }
                CvSection.SKILLS -> DrawSummaryContent(summaryContent)
                CvSection.SUMMARY -> TODO()
                CvSection.PROJECTS -> TODO()
                CvSection.EDUCATION -> TODO()
                CvSection.EXPERIENCE -> TODO()
                CvSection.CERTIFICATES -> TODO()
            }
        }
    }
}