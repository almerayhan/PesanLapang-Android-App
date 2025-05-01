package com.example.pesanlapang_android_app.core.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pesanlapang_android_app.module.detail.presentation.DetailScreen
import com.example.pesanlapang_android_app.module.home.model.popularNearYouSport
import com.example.pesanlapang_android_app.module.home.presentation.HomeScreen
import com.example.pesanlapang_android_app.module.seat_selector.presentation.CourtSelectorScreen

object AppRoute {

    @Composable
    fun GenerateRoute(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = AppRouteName.Home,
        ) {
            composable(AppRouteName.Home) {
               HomeScreen(navController = navController)
            }
            composable("${AppRouteName.Detail}/{id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")
                val sport = popularNearYouSport.first{ it.id == id }

                DetailScreen(navController = navController, sport)
            }
            composable(AppRouteName.CourtSelector) {
                CourtSelectorScreen(navController = navController)
            }
        }
    }
}