package com.zuhal.discovergames.ui.screen.about

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zuhal.discovergames.ui.components.content.AboutContent

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier
) {
    AboutContent(modifier.padding(28.dp).fillMaxWidth())
}