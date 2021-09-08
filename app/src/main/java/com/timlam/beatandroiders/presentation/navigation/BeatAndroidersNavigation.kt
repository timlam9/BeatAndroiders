package com.timlam.beatandroiders.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.timlam.beatandroiders.presentation.screens.details.DetailsScreen
import com.timlam.beatandroiders.presentation.screens.main.MainScreen

@Composable
fun BeatAndroidersNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Main.route,
    ) {
        composable(
            route = Screen.Main.route
        ) {
            MainScreen { androider ->
                navController.navigate(
                    Screen.Details.route.replace("{$ANDROIDER_ID}", androider.id.toString())
                )
            }
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(
                navArgument(ANDROIDER_ID) { type = NavType.IntType }
            )
        ) { backStackEntry ->
            backStackEntry.arguments?.let { arguments ->
                val id: Int = arguments.getInt(ANDROIDER_ID)

                DetailsScreen(androiderID = id)
            }
        }
    }
}
