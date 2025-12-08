package com.ahmed.a.habib.habibportfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahmed.a.habib.habibportfolio.presentation.CvDataViewModel
import com.ahmed.a.habib.habibportfolio.presentation.home.HomeScreen
import com.ahmed.a.habib.habibportfolio.presentation.side_menu.SideMenu
import com.ahmed.a.habib.habibportfolio.presentation.summary.SummaryScreen
import com.ahmed.a.habib.habibportfolio.utils.theme.HabibPortfolioTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HabibPortfolioTheme { MainApp() }
        }
    }
}

@Composable
fun MainApp(viewModel: CvDataViewModel = hiltViewModel()) {

    val state by viewModel.state.collectAsState()
    val summaryContent = state.summaryContent
    val menuItems = state.menuItems
    val personalInfo = state.personalInfo

    var isMenuOpen by remember { mutableStateOf(false) }
    val transition = updateTransition(targetState = isMenuOpen)

    val scale by transition.animateFloat { if (it) 0.85f else 1f }
    val radius by transition.animateDp { if (it) 25.dp else 0.dp }
    val offsetX by transition.animateDp { if (it) 250.dp else 0.dp }

    val toolbarColor = if (isMenuOpen) Color.White else Color.Black
    val menuIconColor = if (isMenuOpen) Color.Black else Color.White
    val menuIcon = if (isMenuOpen) R.drawable.close_icon else R.drawable.side_medu

    val navController = rememberNavController()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(toolbarColor)
                .padding(top = 16.dp, bottom = 8.dp)
        ) {
            Image(
                contentDescription = null,
                painter = painterResource(menuIcon),
                colorFilter = ColorFilter.tint(menuIconColor),
                modifier = Modifier
                    .size(70.dp)
                    .statusBarsPadding()
                    .clickable { isMenuOpen = !isMenuOpen }
            )
        }

        Box {
            SideMenu(
                offsetX = offsetX.value,
                menuItems = menuItems,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) { navigator ->
                isMenuOpen = false
                navigator.navigateTo(navController)
            }

            NavHost(
                startDestination = home_screen,
                navController = navController,
                modifier = Modifier
                    .fillMaxSize()
                    .navigationBarsPadding()
                    .graphicsLayer {
                        clip = true
                        scaleX = scale
                        scaleY = scale
                        translationX = offsetX.toPx()
                        shadowElevation = if (isMenuOpen) 16f else 0f
                        shape = RoundedCornerShape(radius)
                    }
            ) {
                composable(home_screen) {
                    HomeScreen(personalInfo = personalInfo) { isMenuOpen = true }
                }

                composable(summary_screen) { SummaryScreen(summaryContent) }
            }
        }
    }
}