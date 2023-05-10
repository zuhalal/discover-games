package com.zuhal.discovergames.ui.screen.detail

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zuhal.discovergames.data.fake.models.Game
import com.zuhal.discovergames.ui.components.content.DetailContent

@Composable
fun DetailScreen(
    game: Game,
    modifier: Modifier = Modifier,
    onShareButtonClicked: (String) -> Unit
) {
    DetailContent(game = game, modifier = modifier, onShareButtonClicked = onShareButtonClicked)
}