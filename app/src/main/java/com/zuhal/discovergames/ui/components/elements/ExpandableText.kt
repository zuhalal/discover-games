package com.zuhal.discovergames.ui.components.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import com.zuhal.discovergames.R

@Composable
fun ExpandableText(
    modifier: Modifier = Modifier,
    text: String,
    maxLines: Int = 1,
    style: TextStyle = MaterialTheme.typography.body1
) {
    var expanded by remember { mutableStateOf(false) }

    if (expanded) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
            Text(
                text = text,
                textAlign = TextAlign.Start,
                style = style
            )
            TextButton(onClick = { expanded = false }) {
                Text(
                    text = stringResource(R.string.show_less),
                    style = MaterialTheme.typography.subtitle1.copy(
                        color = Color.LightGray,
                        textDecoration = TextDecoration.Underline
                    )
                )
            }
        }
    } else {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
            Text(
                text = text,
                maxLines = maxLines,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start,
                style = style
            )
            TextButton(onClick = { expanded = true }) {
                Text(
                    text = stringResource(R.string.show_more),
                    style = MaterialTheme.typography.subtitle1.copy(
                        color = Color.LightGray,
                        textDecoration = TextDecoration.Underline
                    )
                )
            }
        }
    }
}