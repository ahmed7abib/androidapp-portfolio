package com.ahmed.a.habib.habibportfolio.utils.commonUI

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp


fun light(
    fontSize: TextUnit = 14.sp,
    fontColor: Color = Color.Unspecified,
) = TextStyle(
    color = fontColor,
    fontSize = fontSize,
    fontWeight = FontWeight.Light,
    fontFamily = englishFontFamily,
)

fun regular(
    fontSize: TextUnit = 18.sp,
    fontColor: Color = Color.Unspecified,
) = TextStyle(
    color = fontColor,
    fontSize = fontSize,
    fontWeight = FontWeight.Normal,
    fontFamily = englishFontFamily,
)

fun medium(
    fontSize: TextUnit = 20.sp,
    fontColor: Color = Color.Unspecified,
) = TextStyle(
    color = fontColor,
    fontSize = fontSize,
    fontWeight = FontWeight.Medium,
    fontFamily = englishFontFamily
)

fun bold(
    fontSize: TextUnit = 24.sp,
    fontColor: Color = Color.Unspecified,
) = TextStyle(
    color = fontColor,
    fontSize = fontSize,
    fontWeight = FontWeight.Bold,
    fontFamily = englishFontFamily,
)

fun extraBold(
    fontSize: TextUnit = 28.sp,
    fontColor: Color = Color.Unspecified,
) = TextStyle(
    color = fontColor,
    fontSize = fontSize,
    fontFamily = englishFontFamily,
    fontWeight = FontWeight.ExtraBold,
)