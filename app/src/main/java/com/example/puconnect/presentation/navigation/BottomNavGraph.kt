package com.example.puconnect.presentation.navigation

import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.puconnect.mockdata.home.codeGuildQueList
import com.example.puconnect.mockdata.home.designGuildQueList
import com.example.puconnect.mockdata.home.siddhiQue
import com.example.puconnect.mockdata.home.userQueList
import com.example.puconnect.presentation.chatscreen.ChatScreen
import com.example.puconnect.presentation.creatediscussion.CreateDiscussion
import com.example.puconnect.presentation.eventsscreen.EventsScreen
import com.example.puconnect.presentation.guildscreen.common.GuildScreen
import com.example.puconnect.presentation.homescreen.HomeScreen
import com.example.puconnect.presentation.messagescreen.MessageScreen
import com.example.puconnect.presentation.networkscreen.NetworkScreen
import com.example.puconnect.presentation.notificationscreen.NewMessagesScreen
import com.example.puconnect.presentation.notificationscreen.NotificationScreen
import com.example.puconnect.presentation.profilescreen.EditProfileScreen
import com.example.puconnect.presentation.profilescreen.ProfileScreen
import com.example.puconnect.presentation.profilescreen.SkillCircles
import com.example.puconnect.presentation.profilescreen.SkillsScreen
import com.example.puconnect.presentation.workscreen.WorkScreen
import com.example.puconnect.presentation.workscreen.common.NewBottomSheet
import com.example.puconnect.presentation.workscreen.common.WorkScreenWithBottomSheet
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BottomNavGraph(navController: NavHostController, padding: PaddingValues) {

    AnimatedNavHost(
        route = Graphs.MAIN,
        navController = navController,
        startDestination = BottomBarScreen.HomeScreen.route) {

        composable(
            route = BottomBarScreen.HomeScreen.route,

        ) {
            HomeScreen(navController = navController, padding = padding)
        }

        composable(
            route = BottomBarScreen.NetworkScreen.route,

        ) {
            NetworkScreen(padding = padding, navController = navController)
        }

        composable(
            route = BottomBarScreen.WorkScreen.route,

            ) {
           WorkScreen(paddingValues = padding, navController = navController)
        }
        composable(
            route = BottomBarScreen.EventsScreen.route,
            ) {
            EventsScreen(navController = navController, paddingValues = padding)
        }

        composable(
            route = BottomBarScreen.ProfileScreen.route,

            ) {
            ProfileScreen(paddingValues = padding, navController = navController)
        }

        composable(
            route = Destinations.NewMessageScreen.route,
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
            NewMessagesScreen(navController = navController)
        }

        composable(
            route = Destinations.NotificationScreen.route,
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
            NotificationScreen(navController = navController)
        }

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
                val queData = userQueList.find { userQueData ->
                    userQueData.questionId == questionId
                } ?: siddhiQue
                ChatScreen(queData = queData, navController)
            }
        }

        composable(
            route = Destinations.DirectMessageScreen.route,
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
            val userName = navBackStackEntry.arguments?.getString("name")
            val photoId = navBackStackEntry.arguments?.getString("photoId")
            if (userName == null || photoId == null) {
                Toast.makeText(LocalContext.current, "userId is required for navigation", Toast.LENGTH_SHORT)
                    .show()
            } else {
                MessageScreen(navController = navController, userName = userName , userPhoto = photoId.toInt())
            }


        }
        
        composable(
            route = Destinations.NewDiscussionScreen.route,
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
            CreateDiscussion(navController = navController)
        }

        composable(
            route = Destinations.EditSkillsScreen.route,
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
           SkillsScreen(navController = navController)
        }

        composable(
            route = Destinations.EditProfileScreen.route,
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
           EditProfileScreen(navController = navController)
        }


    }
}