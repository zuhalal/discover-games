package com.zuhal.discovergames.ui.components.elements

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.zuhal.discovergames.R

@Composable
fun GameItem(
    image: String,
    name: String,
    rating: Double,
    modifier: Modifier = Modifier,
) {
    // Fetching current app configuration
    val configuration = LocalConfiguration.current

    Card(modifier = modifier, elevation = 20.dp) {
        Column {
            AsyncImage(
                model = image,
                contentDescription = stringResource(R.string.game_image_description),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 280.dp else 200.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = name,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 20.sp,
                    ),
                    modifier = Modifier.weight(if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 9f else 4f)
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_star_24),
                        contentDescription = stringResource(
                            R.string.rating
                        ),
                        tint = Color.Yellow
                    )
                    Text(
                        text = rating.toString(),
                        style = MaterialTheme.typography.body2.copy(
                            fontSize = 16.sp
                        )
                    )
                }
            }
        }
    }
}