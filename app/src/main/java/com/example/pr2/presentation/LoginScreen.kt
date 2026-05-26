package com.example.pr2.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pr2.data.RetrofitInstance
import com.example.pr2.data.SessionManager
import com.example.pr2.data.repository.NobelRepositoryImpl
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val repo = NobelRepositoryImpl(RetrofitInstance.api)

    fun login(
        username: String,
        password: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {

        viewModelScope.launch {

            val token = repo.login(username, password)

            if (token != null) {
                SessionManager.token = "Bearer $token"
                onSuccess()
            } else {
                onError()
            }
        }
    }
}





@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    viewModel: AuthViewModel = viewModel()
) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") }
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }
        )

        Button(
            onClick = {
                viewModel.login(
                    username,
                    password,
                    onSuccess = onLoginSuccess,
                    onError = { }
                )
            }
        ) {
            Text("Login")
        }
    }
}