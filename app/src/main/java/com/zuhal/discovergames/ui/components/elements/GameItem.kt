package com.zuhal.discovergames.ui.components.elements

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun GameItem(
    image: String,
    name: String,
    rating: Double,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier, elevation = 20.dp) {
        Column {
            AsyncImage(
                model = image,
                contentDescription = "Game Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(120.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    modifier = Modifier.weight(4f),
                    text = name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.ExtraBold,
                    )
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = rating.toString(),
                    style = MaterialTheme.typography.body2.copy(
                        fontSize = 12.sp
                    )
                )
            }
        }
    }
}