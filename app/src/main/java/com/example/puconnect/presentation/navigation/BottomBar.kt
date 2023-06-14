package com.example.puconnect.presentation.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.puconnect.presentation.homescreen.components.BottomNavBarIcons
import com.example.puconnect.presentation.homescreen.components.BottomNavigationBar

@Composable
fun BottomBar(
    navController: NavHostController
) {
    val bottomScreens = listOf<BottomBarScreen>(
        BottomBarScreen.HomeScreen,
        BottomBarScreen.NetworkScreen,
        BottomBarScreen.WorkScreen,
        BottomBarScreen.EventsScreen,
        BottomBarScreen.ProfileScreen
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentDestination = navBackStackEntry?.destination

    BottomAppBar (
        containerColor = Color.White
    ){

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
            //.padding(horizontal = (screenWidth*0.064f).dp),

        ) {
            bottomScreens.forEach {screen->
                AddItem(screen = screen, currentDestination = currentDestination, navController = navController)
            }
        }

    }
}


@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {

    BottomNavBarIcons(
        iconId = screen.iconId,
        filledIconId = screen.filledIcon,
        screenName = screen.title,
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {navController.navigate(screen.route)}
        )

}