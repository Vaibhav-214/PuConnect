package com.example.puconnect.mockdata.home

import com.example.puconnect.R

data class NavItem(
    val iconId: Int,
    val iconfilled: Int,
    val screenName: String
)

val navItems = listOf(
    NavItem(iconId = R.drawable.homeicon3, iconfilled = R.drawable.homeicon2, screenName = "Home"),
    NavItem(iconId = R.drawable.network, iconfilled = R.drawable.networkfilled, screenName = "Network"),
    NavItem(iconId = R.drawable.work, iconfilled = R.drawable.workfilled,screenName = "Work"),
    NavItem(iconId = R.drawable.events, iconfilled = R.drawable.eventsfilled,screenName = "Events"),
    NavItem(iconId = R.drawable.usercircle, iconfilled = R.drawable.usercircle,screenName = "Profile")
)
