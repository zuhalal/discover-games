package com.zuhal.discovergames.ui.components.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun GameItem(
    image: String,
    name: String,
    rating: Double,
    ratingsCount: Int,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        AsyncImage(
            model = image,
            contentDescription = "Game Image",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .padding(8.dp)
        )
        Text(
            text = name,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.subtitle1.copy(
                fontWeight = FontWeight.ExtraBold
            )
        )
    }
}