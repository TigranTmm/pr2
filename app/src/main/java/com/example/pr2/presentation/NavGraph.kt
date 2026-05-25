package com.example.pr2.presentation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph() {

    val navController =
        rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "list"
    ) {

        composable("list") {

            NobelListScreen(navController)
        }

        composable(
            "detail/{name}/{motivation}/{category}/{year}/{birthPlace}"
        ) { backStack ->

            NobelDetailScreen(

                fullName = Uri.decode(
                    backStack.arguments?.getString("name") ?: ""
                ),

                motivation = Uri.decode(
                    backStack.arguments?.getString("motivation") ?: ""
                ),

                category = Uri.decode(
                    backStack.arguments?.getString("category") ?: ""
                ),

                year = Uri.decode(
                    backStack.arguments?.getString("year") ?: ""
                ),

                birthPlace = Uri.decode(
                    backStack.arguments?.getString("birthPlace") ?: ""
                )
            )
        }
    }
}