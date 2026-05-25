package com.example.pr2.presentation

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun NobelListScreen(
    navController: NavController,
    viewModel: NobelViewModel = viewModel()
) {

    val state by viewModel.state.collectAsState()

    var year by remember {
        mutableStateOf("")
    }

    var category by remember {
        mutableStateOf("")
    }

    Column {

        OutlinedTextField(
            value = year,
            onValueChange = {
                year = it
            },
            label = {
                Text("Год")
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = category,
            onValueChange = {
                category = it
            },
            label = {
                Text("Категория")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                viewModel.loadPrizes(
                    year,
                    category
                )
            }
        ) {
            Text("Фильтр")
        }

        when {

            state.isLoading -> {

                CircularProgressIndicator()
            }

            state.error.isNotBlank() -> {

                Text(state.error)
            }

            else -> {

                LazyColumn {

                    items(state.prizes) { prize ->

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .clickable {

                                    navController.navigate(
                                        "detail/" +
                                                Uri.encode(prize.fullName) + "/" +
                                                Uri.encode(prize.motivation) + "/" +
                                                Uri.encode(prize.category) + "/" +
                                                Uri.encode(prize.year) + "/" +
                                                Uri.encode(prize.birthPlace)
                                    )
                                }
                        ) {

                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {

                                Text(prize.fullName)

                                Text(prize.category)

                                Text(prize.year)

                                Text(
                                    prize.motivation.take(100)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}