package com.example.puconnect.presentation.eventsscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.puconnect.R
import com.example.puconnect.mockdata.event.event1
import com.example.puconnect.mockdata.event.eventList
import com.example.puconnect.mockdata.work.workList
import com.example.puconnect.presentation.common.CustomTopAppBar
import com.example.puconnect.presentation.eventsscreen.common.Event
import com.example.puconnect.presentation.navigation.Destinations
import com.example.puconnect.presentation.networkscreen.common.CustomButton3
import com.example.puconnect.presentation.workscreen.common.MyApplications
import com.example.puconnect.presentation.workscreen.common.WorkPost

@Composable
fun EventsScreen(
    navController: NavHostController,
    paddingValues: PaddingValues
) {

    var upcomingSelected by remember {
        mutableStateOf(true)
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(horizontal = 20.dp)
    ) {
        CustomTopAppBar(
            title = "Events",
            onShareClick = {navController.navigate(Destinations.NewMessageScreen.route)},
            onBellClick = {navController.navigate(Destinations.NotificationScreen.route)}
            )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            CustomButton3(
                modifier = Modifier.weight(0.5f),
                exploreSelected = upcomingSelected,
                onClick = { upcomingSelected = true },
                title = "Upcoming Events")

            Spacer(modifier = Modifier.width(12.dp))

            CustomButton3(
                modifier = Modifier.weight(0.5f),
                exploreSelected = !upcomingSelected,
                onClick = { upcomingSelected = false },
                title = "My Events"
            )

        }

        Spacer(modifier = Modifier.height(8.dp))

        if (upcomingSelected) {
            LazyColumn() {
                items(eventList) { event->
                    Event()
                }
            }
        } else {
            MyApplications(
                illustation = R.drawable.calende,
                title = "No events found!"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventScreenpreview() {
   // EventsScreen()
}