package com.ahmed.a.habib.habibportfolio.presentation.shared

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ahmed.a.habib.habibportfolio.utils.commonUI.regular

@Composable
fun RoundedTextBox(modifier: Modifier, text: String) {
    Box(modifier = modifier) {
        Text(
            text = text,
            style = regular(fontColor = Color.White),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 12.dp)
        )
    }
}