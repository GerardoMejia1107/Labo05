package com.gmmrcinco.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gmmrcinco.myapplication.screens.MainScreen
import com.gmmrcinco.myapplication.ui.theme.MyApplicationTheme
import com.gmmrcinco.myapplication.utils.BlogsitoViewModel

sealed class GRAPH(val graph: String) {
    data object MAIN: GRAPH(graph = "MAIN")
}

sealed class MainScreens(val route: String) {
    data object MainScreen: MainScreens(route = "main_screen")
    data object DetailsScreen: MainScreens(route = "details_screen")
}

@Composable
fun RootNavigation(
    viewModel: BlogsitoViewModel
) {
    val navController = rememberNavController()
    MyApplicationTheme {
        NavHost(
            navController = navController,
            route = GRAPH.MAIN.graph,
            startDestination = MainScreens.MainScreen.route
        ) {
            composable(MainScreens.MainScreen.route) {
                MainScreen(
                    viewModel = viewModel,
                    onClick = { navController.navigate(MainScreens.DetailsScreen.route) }
                )
            }
        }
    }
}