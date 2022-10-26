package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.movieDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OtherDetails() {

    Row(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Length",
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.secondaryVariant
            )
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = "2h 38 mins",
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.onPrimary
            )
        }
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Language",
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.secondaryVariant
            )
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = "English",
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.onPrimary
            )
        }
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Rating",
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.secondaryVariant
            )
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = "18+",
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.onPrimary
            )
        }

    }
}