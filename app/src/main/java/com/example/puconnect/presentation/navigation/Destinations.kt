package com.example.puconnect.presentation.navigation

import com.example.puconnect.R

sealed class Destinations(val route: String) {
    object HomeScreen: Destinations("home")
    object CodingGuildScreen: Destinations("code")
    object AiGuildScreen: Destinations("ai")
    object DesignGuildScreen: Destinations("design")
    object ChemGuildScreen: Destinations("chem")
    object ArtGuildScreen: Destinations("art")
    object ChatScreen: Destinations("engage/{queId}") {
        fun createRoute(queId: String) = "engage/$queId"
    }
}


sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val iconId: Int,
    val filledIcon: Int
) {
    object HomeScreen: BottomBarScreen(
        route = "home",
        title = "Home",
        iconId = R.drawable.homeicon3,
        filledIcon = R.drawable.homeicon2
        )
    object NetworkScreen: BottomBarScreen(
        route = "network",
        title = "Network",
        iconId = R.drawable.network,
        filledIcon = R.drawable.networkfilled
        )

    object WorkScreen: BottomBarScreen(
        route = "work",
        title = "Work",
        iconId = R.drawable.work,
        filledIcon = R.drawable.workfilled
    )

    object EventsScreen: BottomBarScreen(
        route = "events",
        title = "Events",
        iconId = R.drawable.events,
        filledIcon = R.drawable.eventsfilled
    )

    object ProfileScreen: BottomBarScreen(
        route = "network",
        title = "Network",
        iconId = R.drawable.usercircle,
        filledIcon = R.drawable.usercircle
    )
}
