package com.example.puconnect.mockdata.event

import com.example.puconnect.R

data class EventData(
    val title: String,
    val date: String,
    val time: String,
    val photo: Int,
)

val event1= EventData(
    title = "The ultimate chatgpt prompt training",
    date = "Friday, June 09",
    time = "7:30 PM",
    photo = R.drawable.adphoto
)

val eventList = listOf(event1, event1, event1)
