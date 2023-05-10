package com.zuhal.discovergames.ui.components.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zuhal.discovergames.data.fake.models.Game
import com.zuhal.discovergames.ui.components.elements.GameItem
import com.zuhal.discovergames.ui.theme.DiscoverGamesTheme

@Composable
fun HomeContent(
    games: List<Game>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(160.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(games) { data ->
            GameItem(
                image = data.backgroundImage ?: "",
                name = data.name,
                rating = data.rating,
//                modifier = Modifier.clickable {
//                    navigateToDetail(data.reward.id)
//                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DiscoverGamesTheme {}
}