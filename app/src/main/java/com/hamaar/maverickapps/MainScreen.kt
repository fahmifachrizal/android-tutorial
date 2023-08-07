package com.hamaar.maverickapps

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNav(navController = navController) }
    ) {
        BottomNavGraph(navController = navController)
    }
}


@Composable
fun BottomNav(navController: NavHostController){
    val screens = listOf(
        BottomNavScreens.Home,
        BottomNavScreens.Profile,
        BottomNavScreens.Settings,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = Color.White,
    ) {
        screens.forEach { screen ->
            val selected = currentDestination?.hierarchy?.any {
                it.route == screen.route
            } == true
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController,
                selected = selected
            )
        }
    }
}

@Composable
fun NavigationBarItemDefaults.bniColors(
    selectedIconColor: Color = Color(red = 255, green = 135, blue = 36),
    selectedTextColor: Color = Color(red = 255, green = 135, blue = 36),
    unselectedIconColor: Color = Color.Gray,
    unselectedTextColor: Color = Color.Gray,
    indicatorColor: Color = Color.White,
) = colors(
    selectedIconColor = selectedIconColor,
    selectedTextColor = selectedTextColor,
    unselectedIconColor = unselectedIconColor,
    unselectedTextColor = unselectedTextColor,
    indicatorColor = indicatorColor
)

@Composable
fun RowScope.AddItem(
    screen: BottomNavScreens,
    currentDestination: NavDestination?,
    navController: NavHostController,
    selected: Boolean
) {
    NavigationBarItem(
        colors = NavigationBarItemDefaults.bniColors(),
        label = {
            Text(
                text = screen.title,
//                color = Color(red = 255, green = 135, blue = 36)
            )
        },
        icon = {
            Icon(
                imageVector = if (selected){screen.iconFilled} else {screen.iconOutline},
                contentDescription = "Navigation Icon",
//                tint = Color(red = 255, green = 135, blue = 36)
            )
        },
        selected = selected,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },

    )
}