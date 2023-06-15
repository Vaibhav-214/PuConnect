package com.example.puconnect.presentation.navigation

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.example.puconnect.presentation.welcomescreen.AnimatedSplashScreen
import com.example.puconnect.presentation.welcomescreen.WelcomeScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RootNavigationGraph() {

    Log.d("ROOT", "In ROOT nav graph")


    val navController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController = navController,
        startDestination = Graphs.AUTH) {



        composable(route = Graphs.MAIN) {
            MainScreen()
        }

        composable(route = Graphs.AUTH) {
            WelcomeScreen(navController = navController)
        }


    }

}