package com.example.pr2.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FavoritesScreen(
    viewModel: PrizeViewModel = viewModel()
) {

    val favorites = viewModel.favorites.value

    Column {

        Text(
            text = "Favorites",
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn {

            items(favorites) { prize ->

                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {

                    Column(modifier = Modifier.padding(12.dp)) {

                        Text(prize.fullName)
                        Text(prize.category)

                        Button(
                            onClick = {
                                viewModel.removeFavorite(prize.id)
                            }
                        ) {
                            Text("Remove")
                        }
                    }
                }
            }
        }
    }
}