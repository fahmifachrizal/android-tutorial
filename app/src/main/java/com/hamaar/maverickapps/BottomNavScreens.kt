package com.hamaar.maverickapps

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavScreens(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomNavScreens(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Profile : BottomNavScreens(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )

    object Settings : BottomNavScreens(
        route = "settings",
        title = "Settings",
        icon = Icons.Default.Settings
    )
}