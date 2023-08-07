package com.hamaar.maverickapps

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavScreens(
    val route: String,
    val title: String,
    val iconFilled: ImageVector,
    val iconOutline: ImageVector
) {
    object Home : BottomNavScreens(
        route = "home",
        title = "Home",
        iconFilled = Icons.Filled.Home,
        iconOutline = Icons.Outlined.Home
    )

    object Settings : BottomNavScreens(
        route = "settings",
        title = "Settings",
        iconFilled = Icons.Filled.Settings,
        iconOutline = Icons.Outlined.Settings
    )

    object Profile : BottomNavScreens(
        route = "profile",
        title = "Profile",
        iconFilled = Icons.Filled.Person,
        iconOutline = Icons.Outlined.Person
    )

}