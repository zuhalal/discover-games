package com.zuhal.discovergames.ui.components.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.zuhal.discovergames.R

@Composable
fun AboutContent(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AsyncImage(
            model = stringResource(R.string.profile_picture_link),
            contentDescription = stringResource(R.string.profile_image_content_desc),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = stringResource(R.string.profile_name), style = MaterialTheme.typography.h5.copy(
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )
        Text(
            text = stringResource(R.string.profile_email), style = MaterialTheme.typography.body1.copy(
                color = Color.White
            )
        )
    }
}