package com.zuhal.discovergames.ui.components.content

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zuhal.discovergames.R
import com.zuhal.discovergames.data.fake.models.Genre
import com.zuhal.discovergames.ui.components.elements.*
import com.zuhal.discovergames.ui.screen.detail.DetailViewModel

@Composable
fun DetailContent(
    id: Int,
    slug: String,
    name: String,
    backgroundImage: String,
    genres: List<Genre>,
    description: String,
    released: String,
    ratingsCount: Int,
    rating: Double,
    esrbRating: String,
    modifier: Modifier = Modifier,
    onShareButtonClicked: (String) -> Unit,
    onBackClick: () -> Unit,
    isFavorite: Boolean = false,
    viewModel: DetailViewModel
) {
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val shareUrl = stringResource(id = R.string.share_url)
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .testTag(
                stringResource(R.string.detail_tag)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box {
            ImageCoveredBlackGradient(
                url = backgroundImage,
                contentDescription = stringResource(R.string.game_image_description),
                height = if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 280.dp else 400.dp,
            )
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(R.string.back),
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { onBackClick() }
            )
        }
        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 16.dp)
                .testTag(stringResource(R.string.description_detail_tag)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.h4.copy(
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                ),
            )
            GameDetailGenreRow(
                genres = genres,
                modifier = Modifier.semantics(mergeDescendants = true) {
                    contentDescription = context.getString(R.string.genre_row_content_desc)
                })
            ExpandableText(
                text = description,
                maxLines = 3,
                modifier = Modifier.semantics(mergeDescendants = true) {
                    contentDescription = context.getString(R.string.expandable_game_desc)
                }
            )
            AdditionalGameDetail(
                released = released,
                rating = rating,
                ratingsCount = ratingsCount,
                esrbRating = esrbRating,
                modifier = Modifier.height(100.dp)
            )
            PrimaryButton(
                text = if (!isFavorite) stringResource(R.string.add_to_favorite)
                else stringResource(R.string.remove_from_favorite),
                onClick = {
                    if (!isFavorite) viewModel.setIsFavorite(id)
                    else viewModel.removeFromFavorite(id)
                },
                modifier = Modifier.semantics(mergeDescendants = true) {
                    contentDescription = context.getString(R.string.favorite_button)
                }
            )
            PrimaryButton(
                text = stringResource(id = R.string.share_game),
                onClick = {
                    onShareButtonClicked("$shareUrl${slug}")
                },
                modifier = Modifier.semantics(mergeDescendants = true) {
                    contentDescription = context.getString(R.string.share_game_button)
                }
            )
        }
    }
}