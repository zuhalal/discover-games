package com.zuhal.discovergames.ui.components.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.zuhal.discovergames.R

@Composable
fun AboutContent(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.verticalScroll(rememberScrollState()),
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
            ),
            modifier = Modifier.semantics {
                contentDescription = context.getString(R.string.about_us_name_content_desc)
            }
        )
        Text(
            text = stringResource(R.string.profile_email),
            style = MaterialTheme.typography.body1.copy(
                color = Color.White
            ),
            modifier = Modifier.semantics {
                contentDescription = context.getString(R.string.about_us_email_content_desc)
            }
        )
    }
}