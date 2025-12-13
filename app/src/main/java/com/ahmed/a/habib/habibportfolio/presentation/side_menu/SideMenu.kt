package com.ahmed.a.habib.habibportfolio.presentation.side_menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.ahmed.a.habib.habibportfolio.R
import com.ahmed.a.habib.habibportfolio.domain.models.MenuItemDto
import com.ahmed.a.habib.habibportfolio.domain.models.SocialDto
import com.ahmed.a.habib.habibportfolio.presentation.navigation.INavigator
import com.ahmed.a.habib.habibportfolio.utils.commonUI.HorizontalSpace
import com.ahmed.a.habib.habibportfolio.utils.openGmail
import com.ahmed.a.habib.habibportfolio.utils.openWebPage
import com.ahmed.a.habib.habibportfolio.utils.openWhatsapp
import com.ahmed.a.habib.habibportfolio.utils.showToast


@Composable
fun SideMenu(
    offsetX: Float,
    menuItems: List<MenuItemDto>,
    socialMedia: List<SocialDto>,
    modifier: Modifier = Modifier,
    navigator: (INavigator) -> Unit,
) {

    ConstraintLayout(
        modifier = modifier.padding(vertical = 48.dp)
    ) {

        val (
            menu,
            social,
        ) = createRefs()

        LazyColumn(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .constrainAs(menu) {
                    verticalBias = 0f
                    top.linkTo(parent.top)
                    bottom.linkTo(social.top)
                    start.linkTo(parent.start)
                }
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

        SocialMedia(
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp)
                .constrainAs(social) {
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                },
            socialMedia = socialMedia
        )
    }
}

@Composable
fun DrawMenuItem(
    icon: Int,
    title: String,
    offsetX: Float,
    onClick: () -> Unit,
) {

    val config = LocalConfiguration.current
    val remainingSpace = config.screenWidthDp.dp - offsetX.dp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = remainingSpace
            )
            .clickable { onClick() },
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

@Composable
private fun SocialMedia(
    modifier: Modifier,
    socialMedia: List<SocialDto>,
) {
    val context = LocalContext.current

    LazyRow(modifier = modifier) {
        items(socialMedia) { item ->
            Icon(
                tint = Color.Black,
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        when {
                            item.isEmail == true -> {
                                if (item.email == null) {
                                    context.showToast(context.getString(R.string.invalid_email))
                                } else {
                                    context.openGmail(context.getString(item.email))
                                }
                            }

                            item.isWhatsapp == true -> {
                                if (item.whatsappNumber == null) {
                                    context.showToast(context.getString(R.string.invalid_whatsapp_number))
                                } else {
                                    context.openWhatsapp(
                                        context.getString(item.whatsappNumber),
                                        context.getString(R.string.hello_i_want_to_contact_you)
                                    )
                                }
                            }

                            else -> {
                                if (item.socialAppLink == null) {
                                    context.showToast(context.getString(R.string.invalid_link))
                                } else {
                                    context.openWebPage(context.getString(item.socialAppLink))
                                }
                            }
                        }
                    },
                painter = painterResource(id = item.iconRes)
            )

            HorizontalSpace(12.dp)
        }
    }
}