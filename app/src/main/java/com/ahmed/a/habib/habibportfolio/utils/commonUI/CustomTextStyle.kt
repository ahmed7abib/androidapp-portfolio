package com.ahmed.a.habib.habibportfolio.utils.commonUI

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp


fun light(
    fontSize: TextUnit = 14.sp,
    fontColor: Color = Color.Unspecified,
    textDecoration: TextDecoration? = null,
) = TextStyle(
    color = fontColor,
    fontSize = fontSize,
    fontFamily = englishFontFamily,
    textDecoration = textDecoration
)

fun regular(
    fontSize: TextUnit = 16.sp,
    fontColor: Color = Color.Unspecified,
    textDecoration: TextDecoration? = null,
) = TextStyle(
    color = fontColor,
    fontSize = fontSize,
    fontFamily = englishFontFamily,
    textDecoration = textDecoration
)

fun medium(
    fontSize: TextUnit = 18.sp,
    fontColor: Color = Color.Unspecified,
    textDecoration: TextDecoration? = null,
) = TextStyle(
    color = fontColor,
    fontSize = fontSize,
    fontFamily = englishFontFamily,
    textDecoration = textDecoration
)

fun bold(
    fontSize: TextUnit = 24.sp,
    fontColor: Color = Color.Unspecified,
    textDecoration: TextDecoration? = null,
) = TextStyle(
    color = fontColor,
    fontSize = fontSize,
    fontWeight = FontWeight.Bold,
    fontFamily = englishFontFamily,
    textDecoration = textDecoration
)

fun extraBold(
    fontSize: TextUnit = 28.sp,
    fontColor: Color = Color.Unspecified,
    textDecoration: TextDecoration? = null,
) = TextStyle(
    color = fontColor,
    fontSize = fontSize,
    fontFamily = englishFontFamily,
    fontWeight = FontWeight.ExtraBold,
    textDecoration = textDecoration
)