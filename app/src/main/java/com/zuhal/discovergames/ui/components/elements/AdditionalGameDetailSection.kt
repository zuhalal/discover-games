package com.zuhal.discovergames.ui.components.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun AdditionalGameDetailSection(
    modifier: Modifier = Modifier,
    title: String,
    content: String,
) {
    Column(modifier = modifier) {
        Text(
            text = title, style = MaterialTheme.typography.body2.copy(
                fontWeight = FontWeight.Bold
            )
        )
        Text(text = content, style = MaterialTheme.typography.body2)
    }
}