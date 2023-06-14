package com.example.puconnect.presentation.navigation

import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.puconnect.mockdata.home.codeGuildQueList
import com.example.puconnect.mockdata.home.designGuildQueList
import com.example.puconnect.mockdata.home.siddhiQue
import com.example.puconnect.mockdata.home.userQueList
import com.example.puconnect.presentation.chatscreen.ChatScreen
import com.example.puconnect.presentation.guildscreen.common.GuildScreen
import com.example.puconnect.presentation.homescreen.HomeScreen
import com.example.puconnect.presentation.homescreen.components.BottomNavigationBar
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavHost() {
    val navController: NavHostController = rememberAnimatedNavController()

    val bottomNavBar =  BottomNavigationBar()
   // val rememberBottomBar = remember {bottomNavBar}

    AnimatedNavHost(
        navController = navController,
        startDestination = Destinations.HomeScreen.route) {

        composable(
            route = Destinations.CodingGuildScreen.route,
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
            GuildScreen(guildName = "Coding Guild", guildList = codeGuildQueList, navController)
        }

        composable(
            route = Destinations.DesignGuildScreen.route,
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
            GuildScreen(guildName = "Design Guild", guildList = designGuildQueList, navController)
        }

        composable(
            route = Destinations.ChemGuildScreen.route,
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
            GuildScreen(guildName = "Chem Guild", guildList = designGuildQueList, navController)
        }

        composable(
            route = Destinations.ArtGuildScreen.route,
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
            GuildScreen(guildName = "Art Guild", guildList = designGuildQueList, navController)
        }

        composable(
            route = Destinations.AiGuildScreen.route,
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
            GuildScreen(guildName = "AI Guild", guildList = designGuildQueList, navController)
        }
        composable(
            route = Destinations.HomeScreen.route
        ) {
//            HomeScreen(
//                navController = navController
//            )
        }

        composable(
            route = Destinations.ChatScreen.route,
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
        ) {navBackStackEntry ->
            val questionId = navBackStackEntry.arguments?.getString("queId")
            if (questionId == null) {
                Toast.makeText(LocalContext.current, "userId is required for navigation", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val queData = userQueList.find {userQueData ->
                    userQueData.questionId == questionId
                } ?: siddhiQue
                ChatScreen(queData = queData, navController)
            }
        }
    }
}