package com.ahmed.a.habib.habibportfolio.presentation.side_menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed.a.habib.habibportfolio.R
import com.ahmed.a.habib.habibportfolio.utils.commonUI.HorizontalSpace
import com.ahmed.a.habib.habibportfolio.utils.commonUI.VerticalSpace


@Composable
fun SideMenu(
    offsetX: Float,
    modifier: Modifier = Modifier,
) {

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier.padding(vertical = 62.dp)
    ) {

        DrawMenuItem(
            title = "Home",
            offsetX = offsetX,
            icon = R.drawable.home,
        )

        VerticalSpace(16.dp)

        DrawMenuItem(
            title = "Summary",
            offsetX = offsetX,
            icon = R.drawable.home,
        )

        VerticalSpace(16.dp)

        DrawMenuItem(
            title = "Experience",
            offsetX = offsetX,
            icon = R.drawable.home,
        )

        VerticalSpace(16.dp)

        DrawMenuItem(
            title = "Projects",
            offsetX = offsetX,
            icon = R.drawable.home,
        )

        VerticalSpace(16.dp)

        DrawMenuItem(
            title = "Skills",
            offsetX = offsetX,
            icon = R.drawable.home,
        )

        VerticalSpace(16.dp)

        DrawMenuItem(
            title = "Education",
            offsetX = offsetX,
            icon = R.drawable.home,
        )

        VerticalSpace(16.dp)

        DrawMenuItem(
            title = "Contact Info",
            offsetX = offsetX,
            icon = R.drawable.home,
        )

    }
}

@Composable
fun DrawMenuItem(
    icon: Int,
    title: String,
    offsetX: Float,
    onClick: () -> Unit = {},
) {

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val remainingSpace = screenWidth - offsetX.dp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(
                start = 16.dp,
                end = remainingSpace,
            ),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                tint = Color.Black,
                contentDescription = title,
                painter = painterResource(id = icon),
                modifier = Modifier.size(24.dp)
            )

            HorizontalSpace(12.dp)

            Text(
                text = title,
                fontSize = 16.sp,
                color = Color.Black
            )
        }

        VerticalSpace(8.dp)

        HorizontalDivider(color = Color.LightGray, thickness = 1.dp)
    }
}