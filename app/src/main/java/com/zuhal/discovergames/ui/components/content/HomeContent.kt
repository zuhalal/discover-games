package com.zuhal.discovergames.ui.components.content

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zuhal.discovergames.R
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
    val context = LocalContext.current

    LazyColumn(
        contentPadding = PaddingValues(24.dp),
        modifier = modifier.testTag(stringResource(R.string.game_list)),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            SearchBar(
                query = query,
                onQueryChange = onQueryChange,
                modifier = Modifier
                    .padding(horizontal = 0.dp, vertical = 16.dp)
                    .semantics(mergeDescendants = true) {
                        contentDescription = context.getString(R.string.search_bar)
                    }
            )
        }
        if (games.isNotEmpty()) {
            items(games, key = { it.id }) { data ->
                GameItem(
                    context = context,
                    image = data.backgroundImage,
                    name = data.name,
                    rating = data.rating,
                    modifier = Modifier.clickable {
                        navigateToDetail(data)
                    }
                )
            }
        } else {
            item {
                Text(
                    text = stringResource(R.string.game_not_found),
                    modifier = Modifier.testTag(stringResource(R.string.not_found_tag)),
                    style = MaterialTheme.typography.body1.copy(
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DiscoverGamesTheme {}
}