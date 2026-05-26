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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pr2.data.RetrofitInstance
import com.example.pr2.data.repository.NobelRepositoryImpl
import com.example.pr2.domain.model.Prize
import kotlinx.coroutines.launch

class PrizeViewModel : ViewModel() {

    private val repo = NobelRepositoryImpl(RetrofitInstance.api)

    var state = mutableStateOf<List<Prize>>(emptyList())
        private set

    var favorites = mutableStateOf<List<Prize>>(emptyList())
        private set

    init {
        loadPrizes()
        loadFavorites()
    }

    fun loadPrizes() {
        viewModelScope.launch {
            state.value = repo.getPrizes()
        }
    }

    fun loadFavorites() {
        viewModelScope.launch {
            favorites.value = repo.getFavorites()
        }
    }

    fun addFavorite(id: Int) {
        viewModelScope.launch {
            repo.addFavorite(id)
            loadFavorites()
        }
    }

    fun removeFavorite(id: Int) {
        viewModelScope.launch {
            repo.removeFavorite(id)
            loadFavorites()
        }
    }
}





@Composable
fun PrizeListScreen(
    navController: NavController,
    viewModel: PrizeViewModel = viewModel()
) {

    val prizes = viewModel.state.value

    Column {

        Button(
            onClick = {
                navController.navigate("favorites")
            }
        ) {
            Text("Go to Favorites")
        }

        LazyColumn {

            items(prizes) { prize ->

                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {

                    Column(modifier = Modifier.padding(12.dp)) {

                        Text(prize.fullName)
                        Text(prize.category)
                        Text(prize.motivation)

                        Button(
                            onClick = {
                                viewModel.addFavorite(prize.id)
                            }
                        ) {
                            Text("Add to favorites")
                        }
                    }
                }
            }
        }
    }
}