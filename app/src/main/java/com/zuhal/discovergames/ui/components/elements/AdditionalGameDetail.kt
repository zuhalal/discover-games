package com.zuhal.discovergames.ui.components.elements

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = modifier) {
        item {
            AdditionalGameDetailSection(title = stringResource(R.string.release_date), content = released.withDateFormat() )
        }
        item {
            AdditionalGameDetailSection(title = stringResource(R.string.rating), content = rating.toString() )
        }
        item {
            AdditionalGameDetailSection(title = stringResource(R.string.ratings_count), content = ratingsCount.toString() )
        }
        item {
            AdditionalGameDetailSection(title = stringResource(R.string.esrb_rating), content = esrbRating )
        }
    }
}