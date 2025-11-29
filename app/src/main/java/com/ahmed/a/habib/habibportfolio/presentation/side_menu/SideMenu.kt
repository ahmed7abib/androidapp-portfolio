package com.ahmed.a.habib.habibportfolio.presentation.side_menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed.a.habib.habibportfolio.domain.models.MenuItemDto
import com.ahmed.a.habib.habibportfolio.presentation.utils.navigation.INavigator


@Composable
fun SideMenu(
    offsetX: Float,
    menuItems: List<MenuItemDto>,
    modifier: Modifier = Modifier,
    navigator: (INavigator) -> Unit,
) {

    LazyColumn(
        verticalArrangement = Arrangement.Top,
        modifier = modifier.padding(vertical = 48.dp)
    ) {
        items(menuItems) { item ->
            DrawMenuItem(
                offsetX = offsetX,
                icon = item.icon,
                title = stringResource(item.title),
            ) {
                navigator(item.navigator)
            }
        }
    }
}

@Composable
fun DrawMenuItem(
    icon: Int,
    title: String,
    offsetX: Float,
    onClick: () -> Unit,
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
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                tint = Color.Black,
                contentDescription = title,
                painter = painterResource(id = icon),
                modifier = Modifier.size(24.dp)
            )

            Text(
                text = title,
                fontSize = 16.sp,
                color = Color.Black
            )
        }

        HorizontalDivider(color = Color.LightGray, thickness = 1.dp)
    }
}