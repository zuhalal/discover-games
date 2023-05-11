package com.zuhal.discovergames.ui.components.content

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zuhal.discovergames.data.fake.models.Game
import com.zuhal.discovergames.ui.components.elements.GameItem
import com.zuhal.discovergames.ui.components.elements.SearchBar
import com.zuhal.discovergames.ui.theme.DiscoverGamesTheme

@Composable
fun HomeContent(
    games: List<Game>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Game) -> Unit,
    query: String,
    onQueryChange: (String) -> Unit,
) {
    LazyColumn(
        contentPadding = PaddingValues(28.dp),
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        item {
            SearchBar(
                query = query,
                onQueryChange = onQueryChange,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
        items(games, key = { it.id }) { data ->
            GameItem(
                image = data.backgroundImage ?: "",
                name = data.name,
                rating = data.rating,
                modifier = Modifier.clickable {
                    navigateToDetail(data)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DiscoverGamesTheme {}
}