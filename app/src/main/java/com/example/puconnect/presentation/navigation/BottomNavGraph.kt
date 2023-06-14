package com.example.puconnect.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.puconnect.presentation.homescreen.HomeScreen
import com.example.puconnect.presentation.networkscreen.NetworkScreen
import com.example.puconnect.presentation.workscreen.WorkScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BottomNavGraph(navController: NavHostController, padding: PaddingValues) {
    AnimatedNavHost(
        navController = navController,
        startDestination = BottomBarScreen.HomeScreen.route) {

        composable(
            route = BottomBarScreen.HomeScreen.route,
            exitTransition = {
                slideOutHorizontally (
                    animationSpec = tween(
                        durationMillis = 300
                    ),
                    targetOffsetX = {1000}
                ) + fadeOut(animationSpec = tween(300))

            },
            enterTransition = {
                slideInHorizontally (
                    animationSpec = tween(
                        durationMillis = 300
                    ),
                    initialOffsetX = {1000}
                ) + fadeIn(animationSpec = tween(300))
            }
        ) {
            HomeScreen(navController = navController, padding = padding)
        }

        composable(
            route = BottomBarScreen.NetworkScreen.route,
            exitTransition = {
                slideOutHorizontally (
                    animationSpec = tween(
                        durationMillis = 300
                    ),
                    targetOffsetX = {1000}
                ) + fadeOut(animationSpec = tween(300))

            },
            enterTransition = {
                slideInHorizontally (
                    animationSpec = tween(
                        durationMillis = 300
                    ),
                    initialOffsetX = {1000}
                ) + fadeIn(animationSpec = tween(300))
            }
        ) {
            NetworkScreen(padding = padding)
        }

        composable(BottomBarScreen.WorkScreen.route) {
            WorkScreen(paddingValues = padding)
        }
        composable(BottomBarScreen.EventsScreen.route) {
            NetworkScreen(padding = padding)
        }

        composable(BottomBarScreen.ProfileScreen.route) {
            NetworkScreen(padding = padding)
        }


    }
}