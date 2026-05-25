package com.example.pr2.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NobelDetailScreen(
    fullName: String,
    category: String,
    year: String,
    motivation: String,
    birthPlace: String
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = fullName
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Категория: $category"
        )

        Text(
            text = "Год: $year"
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = motivation
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Место рождения: $birthPlace"
        )
    }
}