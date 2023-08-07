package com.hamaar.maverickapps

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hamaar.maverickapps.screens.HomeScreen
import com.hamaar.maverickapps.screens.ProfileScreen
import com.hamaar.maverickapps.screens.SettingsScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavScreens.Home.route
    ) {
        composable(route = BottomNavScreens.Home.route) {
            HomeScreen()
        }
        composable(route = BottomNavScreens.Profile.route) {
            ProfileScreen()
        }
        composable(route = BottomNavScreens.Settings.route) {
            SettingsScreen()
        }
    }
}