package com.zuhal.discovergames.ui.components.content

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.zuhal.discovergames.R
import com.zuhal.discovergames.data.fake.models.Game
import com.zuhal.discovergames.ui.components.elements.AdditionalGameDetail
import com.zuhal.discovergames.ui.components.elements.ExpandableText
import com.zuhal.discovergames.ui.components.elements.ImageCoveredBlackGradient

@Composable
fun DetailContent(
    game: Game,
    modifier: Modifier = Modifier,
    onShareButtonClicked: (String) -> Unit,
) {
    val configuration = LocalConfiguration.current
    val shareUrl = stringResource(id = R.string.share_url)

    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageCoveredBlackGradient(
            url = game.backgroundImage,
            contentDescription = stringResource(R.string.game_image_description),
            height = if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 280.dp else 400.dp
        )
        Column(
            modifier = Modifier
                .offset(y = (-48).dp)
                .padding(horizontal = 12.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(
                text = game.name, style = MaterialTheme.typography.h4.copy(
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            )
            LazyRow(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(game.genres, key = { _, genre -> genre.id }) { index, genre ->
                    Text(
                        text = genre.name, style = MaterialTheme.typography.subtitle1.copy(
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline
                        )
                    )
                    if (index != game.genres.size - 1) {
                        Text(
                            text = ",",
                            style = MaterialTheme.typography.subtitle1.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
            ExpandableText(
                text = game.description,
                maxLines = 3
            )
            AdditionalGameDetail(
                released = game.released,
                rating = game.rating,
                ratingsCount = game.ratingsCount,
                esrbRating = game.esrbRating,
                modifier = Modifier.height(100.dp)
            )
            Button(
                onClick = { onShareButtonClicked("$shareUrl${game.slug}") },
                modifier = modifier
                    .fillMaxWidth()
                    .height(48.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.share_game),
                    modifier = Modifier.align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.button.copy(
                        color = Color.White
                    )
                )
            }
        }
    }
}