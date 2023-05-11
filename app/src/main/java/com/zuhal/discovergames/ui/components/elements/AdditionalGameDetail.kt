package com.zuhal.discovergames.ui.components.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.zuhal.discovergames.R
import com.zuhal.discovergames.withDateFormat

@Composable
fun AdditionalGameDetail(
    released: String,
    rating: Double,
    ratingsCount: Int,
    esrbRating: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            AdditionalGameDetailSection(
                title = stringResource(R.string.release_date),
                content = released.withDateFormat(),
                modifier = Modifier.semantics(mergeDescendants = true) {
                    contentDescription = context.getString(R.string.release_date_section)
                }
            )
        }
        item {
            AdditionalGameDetailSection(
                title = stringResource(R.string.rating),
                content = rating.toString(),
                modifier = Modifier.semantics(mergeDescendants = true) {
                    contentDescription = context.getString(R.string.rating_section)
                }
            )
        }
        item {
            AdditionalGameDetailSection(
                title = stringResource(R.string.ratings_count),
                content = ratingsCount.toString(),
                modifier = Modifier.semantics(mergeDescendants = true) {
                    contentDescription = context.getString(R.string.ratings_count_section)
                }
            )
        }
        item {
            AdditionalGameDetailSection(
                title = stringResource(R.string.esrb_rating),
                content = esrbRating,
                modifier = Modifier.semantics(mergeDescendants = true) {
                    contentDescription = context.getString(R.string.esrb_rating_section)
                }
            )
        }
    }
}